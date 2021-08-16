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
import com.github.peep.R
import com.github.peep.SettingActivity
import com.github.peep.databinding.FragmentHomeBinding
import com.peep.githubapitest.githubpapi.ApiClient
import com.peep.githubapitest.githubpapi.GithubInterface
import com.peep.githubapitest.model.Repo
import com.peep.githubapitest.model.User
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {
    companion object{
        var reponame:String =""
        var username:String=""
        var login : String = ""
        var id  : String = ""
        var public_repos = 0
        var fllowers = 0
        var following = 0
        var clickcount = 0
        var repos:List<Repo>? = null
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

        //새로 고침
        mBinding?.renewBtn?.setOnClickListener {
            getUser()
            getUserRepos()
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

        mBinding?.peepHomeImageview?.setOnClickListener {
            clickcount ++;
            peep_home_imageview.setImageResource(R.drawable.happyaction)
            when (clickcount){
                4 -> {
                    clickcount =0 ;
                    peep_home_imageview.setImageResource(R.drawable.happybasic)
                }
                1 -> peep_home_imageview.setImageResource(R.drawable.happyaction)
                2 -> peep_home_imageview.setImageResource(R.drawable.happyaction2)
                3 -> {
                    peep_home_imageview.setImageResource(R.drawable.happyaction3)
                }

            }
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
                    username= user?.name.toString()
                    Toast.makeText(getActivity(), "username : $username", Toast.LENGTH_SHORT).show()
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