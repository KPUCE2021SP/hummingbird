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
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.github.peep.App.Companion.prefs
import com.github.peep.CollectionActicity
import com.github.peep.R
import com.github.peep.SettingActivity
import com.github.peep.databinding.FragmentHomeBinding
import com.github.peep.model.Events
import com.peep.githubapitest.githubpapi.ApiClient
import com.peep.githubapitest.githubpapi.GithubInterface
import com.peep.githubapitest.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*


class HomeFragment : Fragment() {

    companion object {
        var username: String = ""
        var useremail: String = ""
        var usereRealName: String = ""
        var id: String = ""
        var events: Events? = null

        //유저가 처음 받는 기본 병아리는 yellow
        var currentPeep: String? = "yellow"

        var df1: DateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
        var df2: DateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")

    }

    private var nextPeep: String? = null
    private var mBinding: FragmentHomeBinding? = null
    private lateinit var yPeepHome: AnimationDrawable



    override fun onCreate(savedInstanceState: Bundle?) {

        Log.d("timezone",df1.timeZone.toString())
//        df1.timeZone= TimeZone.getTimeZone("GMT-0:00") //한국 (default)
        df2.timeZone= TimeZone.getTimeZone("GMT-0:00") //미국
        Log.d("view","onCreate")
        super.onCreate(savedInstanceState)
        getUser()
        username= prefs.getString("username","")



    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("view","onCreateView")
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        mBinding = binding

        init()
        getEvents(username)

        view()



        //새로 고침
        //현재는 오늘의 커밋 가져오기로 사용 중
        mBinding?.renewBtn?.setOnClickListener {
            getEvents(username)
        }

        //세팅창
        mBinding?.settingBtn?.setOnClickListener {
            var intent = Intent(activity, SettingActivity::class.java)
            startActivity(intent)
        }


        //경험치 정보
        mBinding?.commitExpInfoBtn?.setOnClickListener {
            val ad = AlertDialog.Builder(activity)
                .create()
            ad.setCancelable(false)
            ad.setTitle("경험치 정보")
            ad.setMessage("커밋 할수록 경험치가 찹니다. \n경험치가 다 차면 상단 컬렉션에서 모으신 병아리를 확인 하실 수 있습니다.")
            ad.setButton(
                "확인"
            ) { dialog, which -> dialog.dismiss() }
            ad.show()
        }

        nextPeep = getActivity()?.getIntent()?.getStringExtra("nextPeep")
        //병아리 일러 추후 애니메이션 작업 할 예정
        //병아리 일러스트, 애니메이션 작업이 남아 있기 때문에 함수화 하지 않고 하드코딩했다.
        mBinding?.peepHomeImageview?.apply {
            if (nextPeep != null) {
                currentPeep = nextPeep
                when (currentPeep) {
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
                    "pigeon" -> {
                        mBinding!!.peepHomeImageview.setImageResource(R.drawable.basic_happy_pigeon)
                    }
                    //뱁새 추가 예정
                }
            } else {
                when (currentPeep) {
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
                    "pigeon" -> {
                        mBinding!!.peepHomeImageview.setImageResource(R.drawable.basic_happy_pigeon)
                    }
                    //뱁새 추가 예정
                }
            }
        }

        //기존 애니메이션 작업
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
                if (response.code() == 200) {
                    val user=response.body()
                    username= user?.login.toString()
                    useremail= user?.email.toString()
                    usereRealName= user?.name.toString()
                    Log.d("useremail", useremail)
                    prefs.setString("username", username)
                    prefs.setString("useremail", useremail)
                    prefs.setString("userRealName", usereRealName)

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
        var count:Int=0
        var GithubService=ApiClient.client.create((GithubInterface::class.java))
        val call=GithubService.getEvents(username)
        val now: String = LocalDate.now().toString() //현재 날짜
        val date:String=prefs.getString("date","") //반영된 날짜
        val savedCount:Int=prefs.getString("count","").toInt() //이미 반영된 count 수

        if(date!=now){ //date가 현재 날짜와 다를 경우
            prefs.remove("date")
            prefs.remove("count") //날짜를 초기화했기 때문에 카운트도 초기화
            init()
        }
        call!!.enqueue(object :Callback<Events>{
            override fun onResponse(call: Call<Events>, response: Response<Events>) {
                if (response.code() == 200) {
                    events= response.body()
                    var created_at:Date
                    var kor_created_at:Date
                    var str_date:String
                    for(i in events!!.indices){
                        var dateString:String = events!![i].created_at.replace("Z", "GMT+00:00")
                        created_at= df1.parse(dateString)
                        kor_created_at= convert(created_at)!!
                        str_date=df1.format(kor_created_at)

                        if(events!![i].type=="PushEvent"&&
                            str_date.substring(0,10)==date&&
                            events!![i].payload.ref=="refs/heads/main"){
                            count++
                        }
                    }
                    Log.d("saveCount ",savedCount.toString())
                    Log.d("count",count.toString())
                    if(savedCount < count){ //반영된 count가 현재 count 보다 작을 경우
                        for(i in 1..(count-savedCount)){
                            if(i<3){
                                progress(i)
                            }
                        }
                    }
                    upCount(count)
                    view()
                } else {
                    Log.e("err",response.code().toString())
                }
            }

            override fun onFailure(call: Call<Events>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun refreshFragment(fragment: Fragment, framentManager: FragmentManager?) {
        val ft: FragmentTransaction = requireFragmentManager().beginTransaction()
        if (Build.VERSION.SDK_INT >= 26) {
            ft.setReorderingAllowed(false)
        }
        ft.detach(this).attach(this).commit()
    }

    fun upCount(count:Int){
        prefs.setString("count",count.toString())
        mBinding?.todayCommitCountTextview?.setText(count.toString())
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
        var exp:Int=prefs.getString("exp","").toInt()
        var level:Int=prefs.getString("level","").toInt()


        mBinding?.commitExpProgressbar?.progress = prefs.getString("exp","").toInt()
        mBinding?.currentLevelTv?.text = "lv : "+prefs.getString("level","")
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
                    graduation()
                    level=1
                }
            }

            Log.d("value",exp.toString())
            Log.d("value",level.toString())
            prefs.setString("exp",exp.toString())
            prefs.setString("level",level.toString())
        }
    }

    fun convert(date: Date?): Date? { //시차 변환
        val calendar = Calendar.getInstance()
        calendar.time = date
        return calendar.time
    }

    fun graduation(){
        var intent = Intent(activity, CollectionActicity::class.java)
        intent.putExtra("currentPeep", currentPeep)
        startActivity(intent)
        requireActivity().finish()
    }
}
