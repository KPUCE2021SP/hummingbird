package com.github.peep

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.peep.App.Companion.prefs
import com.github.peep.databinding.ActivityHomeBinding
import com.github.peep.databinding.ActivityMainBinding
import com.github.rahul.githuboauth.ErrorCallback
import com.github.rahul.githuboauth.GithubAuthenticator
import com.github.rahul.githuboauth.SuccessCallback
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.startActivityForResult
import org.jetbrains.anko.toast


class HomeActivity : AppCompatActivity() {
    private val mContext: Context?=null
    private lateinit var auth:String


    private lateinit var mBinding : ActivityHomeBinding



    val githubPrivateAuthenticatorBuilder = GithubAuthenticator.builder(this)
        .clientId(BuildConfig.CLIENT_ID)
        .clientSecret(BuildConfig.CLIENT_SECRET)
        .scopeList(arrayListOf("repo"))
        .onSuccess(object : SuccessCallback {
            override fun onSuccess(result: String) {
                runOnUiThread {
                    val intent= Intent(this@HomeActivity,MainActivity::class.java)
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
                    val intent= Intent(this@HomeActivity,MainActivity::class.java)
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

        if(prefs.getString("token","").equals("")){ //토큰이 없는 거

            setContentView(mBinding.root)

            // Target specific email with login hint.
            mBinding.loginBtn.setOnClickListener {
                val intent = Intent(this, RepoAuthActivity:: class.java)
                startActivityForResult(intent, 100)
//                githubAuthenticator.authenticate()

            }

        }

        else{
            var intent=Intent(this,MainActivity::class.java)
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
//                    githubAuthenticator.authenticate()
                }
            }
        }
    }
}