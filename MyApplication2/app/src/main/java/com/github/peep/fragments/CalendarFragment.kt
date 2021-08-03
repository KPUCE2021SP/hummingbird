package com.github.peep.fragments

import android.annotation.SuppressLint
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.catlove.gitcat.CalendarSelectedDecorator
import com.catlove.gitcat.CalendarTodayDecorator
import com.catlove.gitcat.CalendarUnselectedDecorator
import com.github.peep.R
import com.github.peep.databinding.FragmentCalendarBinding
import com.github.peep.decorator.CalendarDesign
import com.github.peep.model.CommitRoot
import com.peep.githubapitest.githubpapi.ApiClient
import com.peep.githubapitest.githubpapi.GithubInterface
import com.peep.githubapitest.model.Repo
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import kotlinx.android.synthetic.main.fragment_calendar.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CalendarFragment : Fragment() {

    private var mBinding : FragmentCalendarBinding?=null
    var detailCommits = JSONObject()

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCalendarBinding.inflate(inflater,container,false)
        val settings: SharedPreferences = requireActivity().getSharedPreferences("testlogin", MODE_PRIVATE)
        val calendarView = binding.calendarView


        // default 날짜는 오늘 날짜로
        val selectedDate: CalendarDay = CalendarDay.today()
        var preDay: CalendarDay = CalendarDay.today()
        calendarView.addDecorator(CalendarTodayDecorator(activity!!))//오늘 날짜
        calendarView.setOnDateChangedListener { widget, date, selected ->
            loading_img.visibility = View.VISIBLE//로딩화면 나타나기
            val Year = date.year.toString()
            var dateScore : String = Year

            //하나씩 선택되는 drawable
            calendarView.addDecorator(CalendarUnselectedDecorator(preDay,requireActivity()))
            calendarView.addDecorator(CalendarSelectedDecorator(date,requireActivity()))
            preDay = date

            //날짜에 맞는 값들 뿌려주기

            val valueList = ArrayList<String>()

            valueList.add("2")
            valueList.add("20")
            valueList.add("3")
            //count, score, levelUp 순으로

            commit_score.text = valueList[1]
            commit_totalCommit.text = valueList[0]
            if(valueList[2].isEmpty()){
                commit_item.text= "없음!"
                commit_item.textSize = 14F
                commit_item.setTextColor(resources.getColor(R.color.colorText))
            }else{
                Log.d("onCreateView", "onCreateView: else ")
                commitLayout.visibility = View.VISIBLE
                noCommitText.visibility = View.GONE
                commit_item.text = valueList[2]
                commit_item.textSize = 20F
                commit_item.setTextColor(resources.getColor(R.color.colorTextDark))
            }
            Log.d("onCreateView", "onCreateView: ")
            calendarView?.clearSelection()
        }


        calendarView.setOnMonthChangedListener { widget, date ->
            getUserRepos()
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
    fun getUserRepos(){
        var reposNameList:List<String>? = null
        var repos:List<Repo>? = null
        var GithubService=ApiClient.client.create(GithubInterface::class.java)
        val call=GithubService.getUserRepos()
        call.enqueue(object :Callback<List<Repo>>{
            override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {

                Log.d("fullresponse", response.toString())
                if (response.code() == 200) {
                    repos = response.body()
                    Toast.makeText(getActivity(), repos!![0].node_id, Toast.LENGTH_SHORT).show()
                    Log.i("log",repos!![0].owner.repos_url.toString())
                } else {
                    Log.e("err",response.code().toString())
                }
            }

            override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

//    fun getCommitByRepo(){
//        val usernameEx ="kim1387"
//        val reponameEx ="spring-mentoring-goal"
//
//        var commits:List<CommitRoot>? = null
//        val GithubService=ApiClient.client.create(GithubInterface::class.java)
//        val call=GithubService.getRepoCommit(usernameEx,reponameEx)
//        call?.enqueue(object : Callback<List<CommitRoot>> {
//            override fun onResponse(call: Call<List<CommitRoot>>, response: Response<List<CommitRoot>>) {
//
//                Log.d("fullresponse", response.toString())
//                if (response.code() == 200) {
//                    commits= response.body()
//                    Toast.makeText(getActivity(), commits!![0].node_id, Toast.LENGTH_SHORT).show()
//                } else {
//                    Log.e("err",response.code().toString())
//                }
//            }
//
//            override fun onFailure(call: Call<List<CommitRoot>>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//        })
//
//    }
    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }
}

