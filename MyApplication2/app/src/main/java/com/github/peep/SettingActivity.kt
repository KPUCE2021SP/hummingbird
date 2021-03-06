package com.github.peep

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.github.peep.App.Companion.prefs
import com.github.peep.DB.UserDB

import com.github.peep.databinding.ActivitySettingBinding
import com.github.peep.decorator.AlertDesign
import com.peep.githubapitest.githubpapi.ApiClient
import com.peep.githubapitest.githubpapi.GithubInterface
import com.peep.githubapitest.model.User
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SettingActivity : AppCompatActivity() {
    lateinit var mBinding: ActivitySettingBinding
    //private var userDb : UserDB? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        //userDb = UserDB.getInstance(this)

//        val removeRunnable = Runnable{
//            userDb?.userDao()?.deleteAll()
//        }


        //사용자 프로필, 이름 가져오기
        getUser()

        //로그아웃
        mBinding.settingLogoutBtn.setOnClickListener {
            showSettingPopup("로그아웃 하시겠습니까?")
        }

        //레포짓토리 권한 변경
        mBinding.settingRepoBtn.setOnClickListener {
            showSettingPopup("권한을 변경하시겠습니까?\n변경 시, 재로그인이 필요합니다.")
        }
        // 병아리 초기화
        mBinding.settingPeepInitBtn.setOnClickListener {
//            val removeThread = Thread(removeRunnable)
//            removeThread.start()
        }
    }

    fun getUser(){
        var GithubService= ApiClient.client.create(GithubInterface::class.java)
        val call=GithubService.getUser()
        call.enqueue(object: Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.code() == 200) {
                    val user=response.body()
                    Picasso.get().load(user?.avatar_url).into(mBinding.settingProfileIv)
                    mBinding.settingUsername.text = user?.login
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
        App.prefs.clear()
    }

    fun showSettingPopup(string : String){
        AlertDesign(this)
            .setTitle("권한 변경")
            .setMessage(string)
            .setPositiveButton("예") {
                logout()
                var intent=Intent(this,HomeActivity::class.java)
                finishAffinity()
                startActivity(intent)
            }
            .setNegativeButton("취소"){
                finish()
            }
    }
}