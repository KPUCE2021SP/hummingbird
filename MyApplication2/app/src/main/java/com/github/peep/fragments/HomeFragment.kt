package com.github.peep.fragments

import android.app.AlertDialog
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.github.peep.App.Companion.prefs
import com.github.peep.CollectionActicity
import kotlinx.android.synthetic.main.fragment_home.*
import com.github.peep.DB.UserDB
import com.github.peep.MainActivity
import com.github.peep.R
import com.github.peep.SettingActivity
import com.github.peep.databinding.FragmentHomeBinding
import com.github.peep.model.EventResponse
import com.github.peep.model.EventResponseItem
import com.github.peep.model.Events
import com.peep.githubapitest.githubpapi.ApiClient
import com.peep.githubapitest.githubpapi.GithubInterface
import com.peep.githubapitest.model.Repo
import com.peep.githubapitest.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDate


class HomeFragment : Fragment() {

    companion object{
        var username:String=""
        var id  : String = ""
        var events:Events?=null
    }

    private var mBinding : FragmentHomeBinding?=null
    private lateinit var yPeepHome: AnimationDrawable

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentHomeBinding.inflate(inflater,container,false)
        Log.d("reset", "onCreateView: 생성됨")
        getUser()

        username=prefs.getString("username","")
        mBinding = binding

        init()
        getEvents(username)
        view()



        //새로 고침
        //현재는 오늘의 커밋 가져오기로 사용 중
        mBinding?.renewBtn?.setOnClickListener {
            getEvents(username)
            view()
        }

        //세팅창
        mBinding?.settingBtn?.setOnClickListener {
            var intent = Intent(activity,SettingActivity::class.java)
            startActivity(intent)
        }

        //경험치 정보
        mBinding?.commitExpInfoBtn?.setOnClickListener {
            val ad = AlertDialog.Builder(activity)
                .create()
            ad.setCancelable(false)
            ad.setTitle("경험치 정보")
            ad.setMessage("커밋 할수록 경험치가 찹니다. \n경험치가 다 차면 상단 컬렉션에서 모으신 병아리를 확인 하실 수 있습니다.")
            ad.setButton("확인"
            ) { dialog, which -> dialog.dismiss() }
            ad.show()
        }
        

        mBinding?.peepHomeImageview?.apply {
            setBackgroundResource(R.drawable.yellow_peep_ani)
            yPeepHome = background as AnimationDrawable
            yPeepHome.start()
        }

        mBinding?.peepHomeImageview?.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(activity, R.anim.rotation)
            peep_home_imageview.startAnimation(animation)
        }

        return mBinding?.root
    }

    fun getUser(){
        var GithubService=ApiClient.client.create(GithubInterface::class.java)
        val call=GithubService.getUser()
        call.enqueue(object: Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                Log.d("fullresponse", response.toString())
                if (response.code() == 200) {
                    val user=response.body()
                    username= user?.login.toString()
                    prefs.setString("username", username)

                } else {
                    Log.e("err",response.code().toString())
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.d("error","error")
            }
        })
    }



    fun upCount(count:Int){
        prefs.setString("count",count.toString())
    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun getEvents(username:String){
        var count:Int=0
        var GithubService=ApiClient.client.create((GithubInterface::class.java))
        val call=GithubService.getEvents(username)
        val now: String = LocalDate.now().toString() //현재 날짜
        val date:String=prefs.getString("date","") //반영된 날짜
        val savedCount:Int=prefs.getString("count","").toInt() //이미 반영된 count 수

        if(date!=now){ //date가 현재 날짜와 다르거나 설정된 적이 없을 경우
            prefs.setString("date",now)
            prefs.remove("count") //날짜를 초기화했기 때문에 카운트도 초기화
            init()
        }
        call!!.enqueue(object :Callback<Events>{
            override fun onResponse(call: Call<Events>, response: Response<Events>) {
                Log.d("fullresponse", response.toString())
                if (response.code() == 200) {
                    events= response.body()
                    for(i in events!!.indices){
                        if(events!![i].type=="PushEvent"&&
                            events!![i].created_at.substring(0,10)==date&&
                            events!![i].payload.ref=="refs/heads/main"){
                            count++
                        }
                    }
                    Log.d("saveCount ",savedCount.toString())
                    Log.d("count",count.toString())
                    if(savedCount < count){ //반영된 count가 현재 count 보다 작을 경우

                        for(i in savedCount..count){
                            if(i<3&&i>0){
                                progress(i)
                            }

                        }
                        upCount(count)

                    }
                } else {
                    Log.e("err",response.code().toString())
                }
            }

            override fun onFailure(call: Call<Events>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun refreshFragment(fragment:Fragment, framentManager: FragmentManager?){
        val ft: FragmentTransaction = requireFragmentManager().beginTransaction()
        if (Build.VERSION.SDK_INT >= 26) {
            ft.setReorderingAllowed(false)
        }
        ft.detach(this).attach(this).commit()
    }

    fun checkInit(key:String):Boolean{
        var value:String=prefs.getString(key,"")
        if(value==""){
            return true
        }
        return false
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun init(){
        //경험치, 레벨, 날짜, 카운트 초기화 되어있지 않은 경우 초기화 해주기
        if(checkInit("exp")){
            prefs.setString("exp","0")
        }

        if(checkInit("level")){
            prefs.setString("level","1")
        }

        if(checkInit("date")){
            prefs.setString("date",LocalDate.now().toString())
        }

        if(checkInit("count")){
            prefs.setString("count","0")
        }

    }

    fun view(){
        mBinding?.commitExpProgressbar?.setProgress(prefs.getString("exp","").toInt())
        mBinding?.currentLevelTv?.setText("현재 레벨 : "+prefs.getString("level",""))
        mBinding?.todayCommitCountTextview?.setText(prefs.getString("count",""))
    }

    fun progress(count:Int){
        var exp:Int=prefs.getString("exp","").toInt()
        var level:Int=prefs.getString("level","").toInt()

        if(count<3){
            if(exp<80){
                exp+=20
            }
            else{
                exp=0
                if(level<5){
                    level++
                }
                else{
                    //졸업
                    level=1
                }
            }
            prefs.setString("exp",exp.toString())
            prefs.setString("level",level.toString())
        }
        else{
        }


    }



}