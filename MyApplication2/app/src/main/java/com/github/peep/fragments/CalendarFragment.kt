package com.github.peep.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.apollographql.apollo.ApolloClient
import com.catlove.gitcat.CalendarSelectedDecorator
import com.catlove.gitcat.CalendarTodayDecorator
import com.catlove.gitcat.CalendarUnselectedDecorator
import com.github.peep.App
import com.github.peep.App.Companion.prefs
import com.github.peep.R
import com.github.peep.databinding.FragmentCalendarBinding
import com.github.peep.graphql.apolloClient
import com.github.peep.model.CommitRoot
import com.github.peep.model.EventResponse
import com.peep.githubapitest.githubpapi.ApiClient
import com.peep.githubapitest.githubpapi.GithubInterface
import com.peep.githubapitest.model.Repo
import com.prolificinteractive.materialcalendarview.CalendarDay
import kotlinx.android.synthetic.main.fragment_calendar.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class CalendarFragment : Fragment() {

    private var mBinding : FragmentCalendarBinding?=null
    var detailCommits = JSONObject()

    companion object{
        var id  : String = ""
        var repos:List<Repo>? = null
        var repoCommitsResponse:List<CommitRoot>? = null
        var events:EventResponse?=null
        var todayDate: Date =Date()
        var commitCount: Int = 0

    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCalendarBinding.inflate(inflater,container,false)
        //val settings: SharedPreferences = requireActivity().getSharedPreferences("testlogin", MODE_PRIVATE)
        val calendarView = binding.calendarView
        getUserCommitByRepos()
        // default 날짜는 오늘 날짜로
        val selectedDate: CalendarDay = CalendarDay.today()
        var preDay: CalendarDay = CalendarDay.today()
        calendarView.addDecorator(CalendarTodayDecorator(activity!!))//오늘 날짜
        calendarView.setOnDateChangedListener { widget, date, selected ->
            loading_img.visibility = View.VISIBLE//로딩화면 나타나기
            val Year = date.year.toString()
            var dateScore : String = Year
            commitCount = 0
            todayDate = date.date
            Log.d("fullresponse", "Date: "+ todayDate)
            getUserCommitByRepos()
            //하나씩 선택되는 drawable
            calendarView.addDecorator(CalendarUnselectedDecorator(preDay,requireActivity()))
            calendarView.addDecorator(CalendarSelectedDecorator(date,requireActivity()))
            preDay = date

            //날짜에 맞는 값들 뿌려주기

            val valueList = ArrayList<String>()

            valueList.add("2")
            valueList.add(commitCount.toString())
            valueList.add("3")
            //count, score, levelUp 순으로

            commit_score.text = valueList[0]
            commit_totalCommit.text = commitCount.toString()
            if(valueList[2].isEmpty()){
                commit_item.text= "없음!"
                commit_item.setTextColor(resources.getColor(R.color.colorText))
            }else{
                Log.d("onCreateView", "onCreateView: else ")
                commitLayout.visibility = View.VISIBLE
                noCommitText.visibility = View.GONE
                commit_item.text = valueList[2]
                commit_item.setTextColor(resources.getColor(R.color.colorTextDark))
            }
            Log.d("onCreateView", "onCreateView: ")
            calendarView?.clearSelection()
        }


        calendarView.setOnMonthChangedListener { widget, date ->
            val mYear = date.year
            val mMonth = date.month
            val mDay = date.day

            Log.i("Move date", mYear.toString() + "")
            Log.i("Move date", mMonth.toString() + "")
            Log.i("Move date", mDay.toString() + "")

            //아마 초기화
            detailCommits = JSONObject()

        }
        mBinding = binding
        return mBinding?.root
    }
    fun getUserCommitByRepos(){
        var GithubService=ApiClient.client.create(GithubInterface::class.java)
        val call=GithubService.getUserRepos()
        var reposNameList: MutableList<String> = mutableListOf()
        call.enqueue(object :Callback<List<Repo>>{
            override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {

                //Log.d("fullresponse", response.code().toString())
                if (response.code() == 200) {

                    // list<repos>

                    repos = response.body()

                    repos!!.forEach {
                        getReposCommits(it.name)
                        reposNameList.add(it.name)
                    }
                    Log.d("fullresponse", reposNameList.toString()+reposNameList.count())
                } else {
                    Log.e("err",response.code().toString())
                }
            }

            override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }
    fun getReposCommits(name:String){
        var GithubService=ApiClient.client.create(GithubInterface::class.java)
        // TODO kim1387를 사용자 이름으로 수정해야함
        Log.d("fullresponse", "getReposCommits: username"+ prefs.getString("username",""))
        val commitCall = GithubService.getRepoCommit(prefs.getString("username",""),name)
        commitCall.enqueue(object :Callback<List<CommitRoot>>{
            @RequiresApi(Build.VERSION_CODES.O)
            @SuppressLint("SimpleDateFormat")
            override fun onResponse(
                call: Call<List<CommitRoot>>,
                response: Response<List<CommitRoot>>
            ) {
                if (response.code() == 200) {
                    val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd")
                    repoCommitsResponse = response.body()
                    repoCommitsResponse!!.filter {
                        Log.d("fullresponsetime", "onResponse: "+dateFormat.format(it.commit.author.date)+"----"+ dateFormat.format(todayDate))
                        dateFormat.format(it.commit.author.date)
                            // TODO kim1387를 사용자 이름으로 수정해야함
                            .equals(dateFormat.format(todayDate))&&it.commit.committer.name.equals(prefs.getString("username",""))
                    }.forEach {
                        commitCount += 1
                        Log.d("fullresponsedate", "onResponse: ${dateFormat.format(it.commit.author.date)}")
                        Log.d("fullresponse ${name}", "message: "+it.commit.message)

                    }
                    commit_totalCommit.text = commitCount.toString()
                    if (commitCount!=0){
                        Log.d("fullresponse+개수", commitCount.toString())
                    }

                    // Log.d("fullresponse", repoCommitsResponse!![0].count.toString())
                } else {
                    Log.e("err1",response.toString())
                }
            }

            override fun onFailure(call: Call<List<CommitRoot>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }




    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }
}

