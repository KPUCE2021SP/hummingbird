package com.github.peep

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.peep.App.Companion.prefs
import com.github.peep.DB.User
import com.github.peep.DB.UserDB
import com.github.peep.databinding.ActivityHomeBinding
import com.github.rahul.githuboauth.ErrorCallback
import com.github.rahul.githuboauth.GithubAuthenticator
import com.github.rahul.githuboauth.SuccessCallback

class HomeActivity : AppCompatActivity() {
    private val mContext: Context?=null
    private lateinit var auth:String
    private lateinit var mBinding : ActivityHomeBinding

    //DB연결
    private var userDb : UserDB? = null
    val githubPrivateAuthenticatorBuilder = GithubAuthenticator.builder(this)
        .clientId(BuildConfig.CLIENT_ID)
        .clientSecret(BuildConfig.CLIENT_SECRET)
        .scopeList(arrayListOf("repo"))
        .onSuccess(object : SuccessCallback {
            override fun onSuccess(result: String) {
                runOnUiThread {
                    val intent= Intent(this@HomeActivity,ProfileActivity::class.java)
                    prefs.setString("token",result)
                    finish()
                    startActivity(intent)
                }
            }
        })
        .onError(object : ErrorCallback {
            override fun onError(error: Exception) {
                runOnUiThread {
                    Toast.makeText(this@HomeActivity,error.message, Toast.LENGTH_SHORT).show()
                }
            }
        })

    val githubPublicAuthenticatorBuilder = GithubAuthenticator.builder(this)
        .clientId(BuildConfig.CLIENT_ID)
        .clientSecret(BuildConfig.CLIENT_SECRET)
        .scopeList(arrayListOf("public-repo"))
        .onSuccess(object : SuccessCallback {
            override fun onSuccess(result: String) {
                runOnUiThread {
                    val intent= Intent(this@HomeActivity,ProfileActivity::class.java)
                    prefs.setString("token",result)
                    finish()
                    startActivity(intent)
                }
            }
        })
        .onError(object : ErrorCallback {
            override fun onError(error: Exception) {
                runOnUiThread {
                    Toast.makeText(this@HomeActivity,error.message, Toast.LENGTH_SHORT).show()
                }
            }
        })

    override fun onCreate(savedInstanceState: Bundle?) {

        mBinding= ActivityHomeBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        //토근이 저장되어 있지 않다면
        //데이터 베이스 생성
        if(prefs.getString("token","").equals("")){
            setContentView(mBinding.root)

            mBinding.loginBtn.setOnClickListener {
                val intent = Intent(this, RepoAuthActivity:: class.java)
                startActivityForResult(intent, 100)

            }

        }
        //토큰이 있는거 -> 이후 자동 로그인
        else{
            var intent=Intent(this,SplashActivity::class.java)
            finish()
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                100 -> {
                    auth= data!!.getStringExtra("auth")!!
                    Log.d("auth",auth)
                    if(auth=="public"){
                        val githubAuthenticator = githubPublicAuthenticatorBuilder.build()
                        githubAuthenticator.authenticate()
                    }
                    else if(auth=="private"){
                        val githubAuthenticator = githubPrivateAuthenticatorBuilder.build()
                        githubAuthenticator.authenticate()
                    }
                }
            }
        }
    }
}