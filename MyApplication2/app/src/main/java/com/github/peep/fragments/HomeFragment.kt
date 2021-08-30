package com.github.peep.fragments

import android.app.Activity
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
import com.github.peep.*
import com.github.peep.App.Companion.prefs
import com.github.peep.DB.UserDB
import com.github.peep.databinding.FragmentHomeBinding
import com.github.peep.model.Events
import com.peep.githubapitest.githubpapi.ApiClient
import com.peep.githubapitest.githubpapi.GithubInterface
import com.peep.githubapitest.model.User
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDate


class HomeFragment : Fragment() {

    companion object{
        var username:String=""
        var id  : String = ""
        var events:Events?=null
        var count:Int=0
        //유저가 처음 받는 기본 병아리는 yellow
        var currentPeep : String? = "yellow"
    }
    private var nextPeep : String? = null
    private var mBinding : FragmentHomeBinding?=null
    private var userDb : UserDB? = null
    private lateinit var yPeepHome: AnimationDrawable

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater,container,false)
        Log.d("reset", "onCreateView: 생성됨")
        mBinding = binding

        userDb = UserDB.getInstance(requireContext() as MainActivity)
        getUser()

        nextPeep = getActivity()?.getIntent()?.getStringExtra("nextPeep").toString()

        //새로 고침
        //현재는 오늘의 커밋 가져오기로 사용 중
        mBinding?.renewBtn?.setOnClickListener {
            getEvents(prefs.getString("username",""))
            Toast.makeText(activity,"nextPeep : ${nextPeep}",Toast.LENGTH_SHORT).show()
        }

        //세팅창
        mBinding?.settingBtn?.setOnClickListener {
            var intent = Intent(activity,SettingActivity::class.java)
            startActivity(intent)
        }
        //병아리 졸업
        mBinding?.gradBtn?.setOnClickListener {
            var intent = Intent(activity,CollectionActicity::class.java)
            intent.putExtra("currentPeep", currentPeep)
            startActivity(intent)
            requireActivity().finish()
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
        
        //병아리 일러 추후 애니메이션 작업 할 예정
        //병아리 일러스트, 애니메이션 작업이 남아 있기 때문에 함수화 하지 않고 하드코딩했다.
        mBinding?.peepHomeImageview?.apply{
            if(nextPeep!= null){
                currentPeep = nextPeep
                when(currentPeep){
                    "yellow" -> {
                        mBinding!!.peepHomeImageview.setImageResource(R.drawable.basic_neutral)
                    }
                    //빨간 병아리
                    "red" -> {
                        mBinding!!.peepHomeImageview.setImageResource(R.drawable.basic_neutral_red)
                    }
                    //초록 병아리
                    "green" -> {
                        mBinding!!.peepHomeImageview.setImageResource(R.drawable.basic_neutral_green)
                    }
                    //파랑 병아리
                    "blue" -> {
                        mBinding!!.peepHomeImageview.setImageResource(R.drawable.basic_neutral_blue)
                    }
                    //비둘기
                    "peigeon" -> {
                        mBinding!!.peepHomeImageview.setImageResource(R.drawable.basic_happy_pigeon)
                    }
                    //뱁새 추가 예정
                }
            }
            else{
                when(currentPeep){
                    "yellow" -> {
                        mBinding!!.peepHomeImageview.setImageResource(R.drawable.basic_neutral)
                    }
                    //빨간 병아리
                    "red" -> {
                        mBinding!!.peepHomeImageview.setImageResource(R.drawable.basic_neutral_red)
                    }
                    //초록 병아리
                    "green" -> {
                        mBinding!!.peepHomeImageview.setImageResource(R.drawable.basic_neutral_green)
                    }
                    //파랑 병아리
                    "blue" -> {
                        mBinding!!.peepHomeImageview.setImageResource(R.drawable.basic_neutral_blue)
                    }
                    //비둘기
                    "peigeon" -> {
                        mBinding!!.peepHomeImageview.setImageResource(R.drawable.basic_happy_pigeon)
                    }
                    //뱁새 추가 예정
                }
            }
        }


//        mBinding?.peepHomeImageview?.apply {
//            setBackgroundResource(R.drawable.yellow_peep_ani)
//            yPeepHome = background as AnimationDrawable
//            yPeepHome.start()
//        }

//        mBinding?.peepHomeImageview?.setOnClickListener {
//            val animation = AnimationUtils.loadAnimation(activity, R.anim.rotation)
//            peep_home_imageview.startAnimation(animation)
//        }

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
//                    Toast.makeText(getActivity(), "username : $username", Toast.LENGTH_SHORT).show()

                } else {
                    Log.e("err",response.code().toString())
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.d("error","error")
            }
        })
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getEvents(username:String){
        count=0
        var GithubService=ApiClient.client.create((GithubInterface::class.java))
        val call=GithubService.getEvents(username)
        val date: LocalDate = LocalDate.now()
        Log.d("date",date.toString())
        call!!.enqueue(object :Callback<Events>{
            override fun onResponse(call: Call<Events>, response: Response<Events>) {
                Log.d("fullresponse", response.toString())
                if (response.code() == 200) {
                    events= response.body()
                    for(i in events!!.indices){
                        Log.d("date2",events!![i].created_at.substring(0,10))
                        if(events!![i].type=="PushEvent"&&
                            events!![i].created_at.substring(0,10)==date.toString()){
                            count++
                        }
                    }
                    today_commit_count_textview.setText(count.toString())
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
}