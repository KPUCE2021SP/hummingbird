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
import com.github.peep.DB.UserDB
import com.github.peep.MainActivity
import com.github.peep.SettingActivity
import com.github.peep.databinding.FragmentHomeBinding
import com.github.peep.model.EventResponse
import com.github.peep.model.EventResponseItem
import com.peep.githubapitest.githubpapi.ApiClient
import com.peep.githubapitest.githubpapi.GithubInterface
import com.peep.githubapitest.model.Repo
import com.peep.githubapitest.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {

    companion object{
        var username:String=""
        var id  : String = ""
        var repos:List<Repo>? = null
        var events:EventResponse?=null
    }

    private var mBinding : FragmentHomeBinding?=null
    private var userDb : UserDB? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater,container,false)
        Log.d("reset", "onCreateView: 생성됨")
        mBinding = binding


        userDb = UserDB.getInstance(requireContext() as MainActivity)

        val addRunnable = Runnable {
            userDb?.userDao()?.updateHappy()
            userDb?.userDao()?.updateSad()
            userDb?.userDao()?.updateLevel()
        }
        //새로 고침
        //현재는 레벨업, 병아리 졸업 기능으로 사용
        mBinding?.renewBtn?.setOnClickListener {

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
        //컬렉션 이동
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

    fun getUserRepos(){
        var GithubService=ApiClient.client.create(GithubInterface::class.java)
        val call=GithubService.getUserRepos()
        call.enqueue(object :Callback<List<Repo>>{
            override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {

                Log.d("fullresponse", "homefragment"+response.toString())
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
    fun refreshFragment(fragment:Fragment, framentManager: FragmentManager?){
        val ft: FragmentTransaction = requireFragmentManager().beginTransaction()
        if (Build.VERSION.SDK_INT >= 26) {
            ft.setReorderingAllowed(false)
        }
        ft.detach(this).attach(this).commit()
    }
    
    fun getUserEvents(username:String){
        var GithubService=ApiClient.client.create(GithubInterface::class.java)
        val call=GithubService.getUserEvents(prefs.getString("username",""))
        call.enqueue(object :Callback<EventResponse>{
            override fun onResponse(call: Call<EventResponse>, response: Response<EventResponse>) {
                Log.d("fullresponse", response.toString())
                if (response.code() == 200) {
                    events=response.body()
                    Toast.makeText(getActivity(), events!![1].created_at, Toast.LENGTH_SHORT).show()
                } else {
                    Log.e("err",response.code().toString())
                }
            }

            override fun onFailure(call: Call<EventResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }

    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }


}