package com.github.peep

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
                Log.d("fullresponse", response.toString())
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
    }

    fun showSettingPopup(string : String){
//        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//        val view = inflater.inflate(R.layout.alert_popup,null)
//        var textView = view.findViewById<TextView>(R.id.alert_textview)
//        textView.text = string

        AlertDesign(this)
            .setTitle("권한 변경")
            .setMessage(string)
            .setPositiveButton("예") {
                logout()
//                임의로
                var intent=Intent(this, PickPeepActivity::class.java)
                finish()
                startActivity(intent)
            }
            .setNegativeButton("취소"){}
            .show()

//        val alertDialog = AlertDesign.CustomDialogBuilder()
//            .setTitle("권한 설정 변경")
//            .setPositiveButton("확인"){ dialog, which ->
//                logout()
//                var intent=Intent(this,HomeActivity::class.java)
//                finish()
//                startActivity(intent)
//            }
//            .setNegativeButton("취소",null)
//            .create()
//
//        alertDialog.setView(view)
//        alertDialog.show()
    }
    override fun onDestroy() {
        UserDB.destroyInstance()
        super.onDestroy()
    }
}