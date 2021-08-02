package com.github.peep.fragments

import android.content.Context
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
import com.github.peep.HomeActivity
import com.github.peep.MainActivity
import com.github.peep.R
import com.github.peep.databinding.FragmentHomeBinding
import com.github.peep.githubpapi.GithubInterface
import com.github.peep.model.Repo
import com.github.peep.model.User
import com.github.peep.githubpapi.ApiClient
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Header
import java.net.CookieManager


class HomeFragment : Fragment() {
        var reponame:String =""
        var username:String=""

    private var mBinding : FragmentHomeBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater,container,false)
        Log.d("reset", "onCreateView: 생성됨")
        mBinding = binding
        
        //새로 고침
        mBinding?.renewBtn?.setOnClickListener {
//            getUser()
            getUserRepos()
//            for(i in repos!!.indices){
//                Log.d("repos",repos!![i].name.toString())
//            }
//            refreshFragment(this,getFragmentManager())
        }

        mBinding?.settingBtn?.setOnClickListener {
            val mActivity=activity as MainActivity
            logout()
            var intent=Intent(mActivity,HomeActivity::class.java)
            mActivity.finish()
            startActivity(intent)

        }


        return mBinding?.root
    }

    fun getUser(){
        var GithubService= ApiClient.client.create(GithubInterface::class.java)
        val call=GithubService.getUser()
        call.enqueue(object: Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                Log.d("fullresponse", response.toString())
                if (response.code() == 200) {
                    val user=response.body()
                    username= user?.name.toString()
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
                    var repos= response.body()!!
                    Toast.makeText(getActivity(), repos!![2].name, Toast.LENGTH_SHORT).show()


                } else {
                    Log.e("err",response.code().toString())
                }
            }

            override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun logout(){
        prefs.remove("token")
        android.webkit.CookieManager.getInstance().removeAllCookie()
    }

//    fun refreshFragment(fragment:Fragment, framentManager: FragmentManager?){
//        val ft: FragmentTransaction = requireFragmentManager().beginTransaction()
//        if (Build.VERSION.SDK_INT >= 26) {
//            ft.setReorderingAllowed(false)
//        }
//        ft.detach(this).attach(this).commit()
//    }

    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }


}