package com.github.peep

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.github.peep.DB.UserDB
import com.github.peep.databinding.ActivityProfileBinding
import com.github.peep.decorator.AlertDesign
import com.peep.githubapitest.githubpapi.ApiClient
import com.peep.githubapitest.githubpapi.GithubInterface
import com.peep.githubapitest.model.User
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.alert_popup.view.*
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileActivity : AppCompatActivity() {
    lateinit var mBinding : ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_profile)
        mBinding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        getUser()
        mBinding.startButton.setOnClickListener {
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        mBinding.backButton.setOnClickListener {
            showSettingPopup("로그아웃 하시겠습니까?")
        }
    }
    fun showSettingPopup(string : String){
        AlertDesign(this)
            .setTitle("권한 변경")
            .setMessage(string)
            .setPositiveButton("예") {
                logout()
                var intent=Intent(this,HomeActivity::class.java)
                finish()
                startActivity(intent)
            }
            .setNegativeButton("취소"){
                finish()
            }

            .show()
    }
    fun getUser(){
        var GithubService= ApiClient.client.create(GithubInterface::class.java)
        val call=GithubService.getUser()
        call.enqueue(object: Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                Log.d("fullresponse", response.toString())
                if (response.code() == 200) {
                    val user=response.body()
                    Glide.with(this@ProfileActivity).load(user?.avatar_url).circleCrop().into(mBinding.gitProfileIv)
                    mBinding.gitUsernameTv.text = user?.login
                } else {
                    Log.e("err",response.code().toString())
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.d("error","error")
            }
        })
    }
    fun logout(){
        App.prefs.remove("token")
        android.webkit.CookieManager.getInstance().removeAllCookie()
    }
    override fun onDestroy() {
        UserDB.destroyInstance()
        super.onDestroy()
    }

    override fun onBackPressed() {
        //super.onBackPressed()
        Toast.makeText(this,"시작하기 버튼을 눌러주세요.",Toast.LENGTH_SHORT).show()
    }
}