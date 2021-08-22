package com.github.peep.fragments

import android.app.AlertDialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.github.peep.App.Companion.prefs
import com.github.peep.CollectionActicity
import com.github.peep.SettingActivity
import com.github.peep.databinding.FragmentHomeBinding
import com.github.peep.model.Events
import com.peep.githubapitest.githubpapi.ApiClient
import com.peep.githubapitest.githubpapi.GithubInterface
import com.peep.githubapitest.model.Repo
import com.peep.githubapitest.model.User
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDate


class HomeFragment : Fragment() {
    companion object{
        var reponame:String =""
        var username:String=""
        var login : String = ""
        var id  : String = ""
        var public_repos = 0
        var fllowers = 0
        var following = 0
        var repos:List<Repo>? = null
        var events:Events?=null
        var count:Int=0

    }

    private var mBinding : FragmentHomeBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater,container,false)
        Log.d("reset", "onCreateView: 생성됨")
        mBinding = binding
        getUser()
        Log.d("username", prefs.getString("username",""))
        getEvents(prefs.getString("username",""))

        //새로 고침
        mBinding?.renewBtn?.setOnClickListener {
            getEvents(prefs.getString("username",""))
//            getUser()
//            getUserRepos()
//            for(i in repos!!.indices){
//                Log.d("repos",repos!![i].name.toString())
//            }
//            refreshFragment(this,getFragmentManager())
        }

        mBinding?.settingBtn?.setOnClickListener {
            var intent = Intent(activity,SettingActivity::class.java)
            startActivity(intent)
        }

//        mBinding?.settingBtn?.setOnClickListener {
//            val mActivity=activity as MainActivity
//            logout()
//            var intent=Intent(mActivity,HomeActivity::class.java)
//            mActivity.finish()
//            startActivity(intent)
//        }

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
        mBinding?.peepCollectionBtn?.setOnClickListener {
            var intent = Intent(activity,CollectionActicity::class.java)
            startActivity(intent)
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
                    prefs.setString("username",username)
                } else {
                    Log.e("err",response.code().toString())
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.d("error","error")
            }
        })
    }

    fun getUserRepos(){
        var GithubService=ApiClient.client.create(GithubInterface::class.java)
        val call=GithubService.getUserRepos()
        call.enqueue(object :Callback<List<Repo>>{
            override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {

                Log.d("fullresponse", response.toString())
                if (response.code() == 200) {
                    repos= response.body()
                    Toast.makeText(getActivity(), repos!![1].name, Toast.LENGTH_SHORT).show()
                } else {
                    Log.e("err",response.code().toString())
                }
            }

            override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }

    fun getEvents(username:String){
        count=0 //count 초기화
        var savedCount:Int=0

        var GithubService=ApiClient.client.create((GithubInterface::class.java))
        val call=GithubService.getEvents(username)
        val now: LocalDate = LocalDate.now() //현재 날짜

        val date:String=prefs.getString("date","") //prefs의 date 가져오기

        if(date==""||date!=now.toString()){ //date가 현재와 다르거나 설정된 적이 없으면 date 설정
            prefs.setString("date",now.toString())
            prefs.remove("count") //날짜가 변경되었기 때문에 반영된 count 정보 삭제
        }
        call!!.enqueue(object :Callback<Events>{
            override fun onResponse(call: Call<Events>, response: Response<Events>) {
                Log.d("fullresponse", response.toString())
                if (response.code() == 200) {
                    events= response.body()
                    for(i in events!!.indices){
                        Log.d("date2",events!![i].created_at.substring(0,10))
                        if(events!![i].type=="PushEvent"&&
                            events!![i].created_at.substring(0,10)==date.toString()&&
                                events!![i].payload.ref=="refs/heads/main"){
                            count++ //push Event count
                        }
                    }

                    if(prefs.getString("count","")==""){ //count가 설정된 적 없을 경우
                        prefs.setString("count",count.toString()) //반영된 count 정보 갱신
                        today_commit_count_textview.setText(count.toString())
                        if(count<2&&count!=0){
                            commit_exp_progressbar.incrementProgressBy(20 * count)
                        }
                        else{
                            commit_exp_progressbar.incrementProgressBy(20)
                        }
                    }
                    else{ //count가 설정된 적 있을 경우
                        savedCount=prefs.getString("count","").toInt()
                        if(savedCount<2){ //반영된 count가 2 미만일 경우만 반영됨
                            if(count>2){
                                commit_exp_progressbar.incrementProgressBy(20 * (2-savedCount)) //최대 점수는 2점이기 때문에
                            }
                            else if((count<=2)&&(count>0)){
                                commit_exp_progressbar.incrementProgressBy(20 * (count-savedCount)) //현재 카운트에서 이미 반영된 카운트 빼기]
                            }
                            commit_exp_progressbar.incrementProgressBy(20 * (count))
                        }
                        prefs.setString("count",count.toString()) //반영된 count 정보 갱신
                        today_commit_count_textview.setText(count.toString())
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

    fun logout(){
        prefs.remove("token")
        android.webkit.CookieManager.getInstance().removeAllCookie()
    }

    fun refreshFragment(fragment:Fragment, framentManager: FragmentManager?){
        val ft: FragmentTransaction = requireFragmentManager().beginTransaction()
        if (Build.VERSION.SDK_INT >= 26) {
            ft.setReorderingAllowed(false)
        }
        ft.detach(this).attach(this).commit()
    }


    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }


}