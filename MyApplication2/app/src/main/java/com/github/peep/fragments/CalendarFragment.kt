package com.github.peep.fragments

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.exception.ApolloException
import com.catlove.gitcat.CalendarSelectedDecorator
import com.catlove.gitcat.CalendarTodayDecorator
import com.catlove.gitcat.CalendarUnselectedDecorator
<<<<<<< HEAD
=======
import com.github.peep.App
>>>>>>> 50b55522df534ebcb77f28fbcac7f1a468459220
import com.github.peep.App.Companion.prefs
import com.github.peep.R
import com.github.peep.ResultQuery
import com.github.peep.databinding.FragmentCalendarBinding
<<<<<<< HEAD
import com.github.peep.decorator.EventDecorator
import com.github.peep.fragments.HomeFragment.Companion.df1
import com.github.peep.fragments.HomeFragment.Companion.df2
import com.github.peep.graphql.apolloClient
import com.github.peep.type.RepositoryPrivacy
=======
import com.github.peep.model.CommitRoot
import com.github.peep.model.EventResponse
import com.peep.githubapitest.githubpapi.ApiClient
import com.peep.githubapitest.githubpapi.GithubInterface
import com.peep.githubapitest.model.Repo
>>>>>>> 50b55522df534ebcb77f28fbcac7f1a468459220
import com.prolificinteractive.materialcalendarview.CalendarDay
import kotlinx.android.synthetic.main.fragment_calendar.*
<<<<<<< HEAD
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
=======
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
>>>>>>> 50b55522df534ebcb77f28fbcac7f1a468459220

class CalendarFragment : Fragment() {

    private var mBinding : FragmentCalendarBinding?=null

    companion object{
        var id  : String = ""
<<<<<<< HEAD
        var todayDate: Date =Date()
        var commitCount: Int = 0

        var monthCount=HashMap<Int,Int>()

=======
        var repos:List<Repo>? = null
        var repoCommitsResponse:List<CommitRoot>? = null
        var events:EventResponse?=null
        var todayDate: Date =Date()
        var commitCount: Int = 0
>>>>>>> 50b55522df534ebcb77f28fbcac7f1a468459220
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
<<<<<<< HEAD




        val binding = FragmentCalendarBinding.inflate(inflater,container,false)
        //val settings: SharedPreferences = requireActivity().getSharedPreferences("testlogin", MODE_PRIVATE)
        val calendarView = binding.calendarView
=======
        val binding = FragmentCalendarBinding.inflate(inflater,container,false)
        //val settings: SharedPreferences = requireActivity().getSharedPreferences("testlogin", MODE_PRIVATE)
        val calendarView = binding.calendarView
        getUserCommitByRepos()
>>>>>>> 50b55522df534ebcb77f28fbcac7f1a468459220
        // default 날짜는 오늘 날짜로
        val selectedDate: CalendarDay = CalendarDay.today()

        var preDay: CalendarDay = CalendarDay.today()
        calendarView.addDecorator(CalendarTodayDecorator(activity!!))//오늘 날짜

        var month= if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LocalDate.now().monthValue
        } else {
            TODO("VERSION.SDK_INT < O")
        }
        var year=LocalDate.now().year
        monthCount.clear()

        getEvents(month,year,calendarView)
        Log.d("monthCount", monthCount.toString())

        calendarView.setOnDateChangedListener { widget, date, selected ->
            loading_img.visibility = View.VISIBLE//로딩화면 나타나기
<<<<<<< HEAD
            val year = date.year
            val month=date.month+1
            val day = date.day
            //getDateEvent(month, year, day)

=======
            val Year = date.year.toString()
            var dateScore : String = Year
            commitCount = 0
            todayDate = date.date
            Log.d("fullresponse", "Date: "+ todayDate)
            getUserCommitByRepos()
>>>>>>> 50b55522df534ebcb77f28fbcac7f1a468459220
            //하나씩 선택되는 drawable
            calendarView.addDecorator(CalendarUnselectedDecorator(preDay,requireActivity()))
            calendarView.addDecorator(CalendarSelectedDecorator(date,requireActivity()))
            preDay = date

            //날짜에 맞는 값들 뿌려주기

<<<<<<< HEAD
            val todayCommit = monthCount.getOrDefault(day,0)
            Log.d("todayCommit", todayCommit.toString())
            commit_totalCommit.text = todayCommit.toString()
            //count, score, levelUp 순으로

            if(todayCommit==0||todayCommit==null){
                commitLayout.visibility = View.GONE
                noCommitText.visibility = View.VISIBLE
=======
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
>>>>>>> 50b55522df534ebcb77f28fbcac7f1a468459220
            }else{
                Log.d("onCreateView", "onCreateView: else ")
                commitLayout.visibility = View.VISIBLE
                noCommitText.visibility = View.GONE
<<<<<<< HEAD
=======
                commit_item.text = valueList[2]
                commit_item.setTextColor(resources.getColor(R.color.colorTextDark))
>>>>>>> 50b55522df534ebcb77f28fbcac7f1a468459220
            }
            Log.d("onCreateView", "onCreateView: ")
            calendarView?.clearSelection()
        }


        calendarView.setOnMonthChangedListener { widget, date ->
<<<<<<< HEAD
            widget.invalidateDecorators()
=======
>>>>>>> 50b55522df534ebcb77f28fbcac7f1a468459220
            val mYear = date.year
            val mMonth = date.month+1
            val mDay = date.day


            getEvents(mMonth,mYear,calendarView)
            Log.i("Move date", date.toString() + "")
            Log.i("Move date", mYear.toString() + "")
            Log.i("Move date", mMonth.toString() + "")
            Log.i("Move date", mDay.toString() + "")

        }
        mBinding = binding
        return mBinding?.root
    }
<<<<<<< HEAD
    fun convert(date: Date?): Date? { //시차 변환
        val calendar = Calendar.getInstance()
        calendar.time = date
//        calendar.add(Calendar.HOUR,9)
        return calendar.time
    }

=======
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



>>>>>>> 50b55522df534ebcb77f28fbcac7f1a468459220
    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }

    fun getEvents(month:Int,year:Int,calendarView:MaterialCalendarView){

        monthCount.clear()

        var startDate:String=""
        var endDate:String=""

        if(month in arrayListOf<Int>(1,3,5,7,8,10,12)){ //31일까지
            startDate=year.toString()+"-"+String.format("%02d",month)+"-01T00:00:00GMT+09:00"
            endDate=year.toString()+"-"+String.format("%02d",month)+"-31T23:59:59GMT+09:00"

            var start=df2.parse(startDate)
            var end=df2.parse(endDate)

            var kor_start=convert(start)
            var kor_end=convert(end)

            startDate=df2.format(kor_start)
            endDate=df2.format(kor_end)
        }
        else{ //30일까지
            startDate=year.toString()+"-"+String.format("%02d",month)+"-01T00:00:00GMT+09:00"
            endDate=year.toString()+"-"+String.format("%02d",month)+"-30T23:59:59GMT+09:00"

            var start=df2.parse(startDate)
            var end=df2.parse(endDate)

            var kor_start=convert(start)
            var kor_end=convert(end)

            startDate=df2.format(kor_start)
            endDate=df2.format(kor_end)
        }



        Log.d("start",startDate)
        Log.d("end",endDate)


        if(prefs.getString("auth","")=="public"){ //public


            val client:ApolloClient= apolloClient(requireContext())
            client.query(ResultQuery(prefs.getString("username",""),startDate,endDate,RepositoryPrivacy.PUBLIC))
                .enqueue(object :ApolloCall.Callback<ResultQuery.Data>(){
                    @RequiresApi(Build.VERSION_CODES.N)
                    override fun onResponse(response: com.apollographql.apollo.api.Response<ResultQuery.Data>) {
                        var data = response.data!!
                        Log.d("graphql", data.toString())
                        var repositories=data.user!!.repositories
                        for(i in 0..repositories.nodes!!.size-1){
                            var repository= repositories.nodes!![i]
                            if(repository!!.ref!=null){
                                var asCommit= repository!!.ref!!.target!!.asCommit
                                var history=asCommit!!.history
                                for(i in 0 until history.nodes!!.size-1){
                                    var commit=history!!.nodes!![i]
                                    var committedDate=commit!!.committedDate.toString()

                                    var dateString: String = committedDate.replace("Z", "GMT+00:00")
                                    Log.d("dateString", dateString)
                                    var dateFormat: Date = df1.parse(dateString)
                                    var kor_dateFormat: Date = convert(dateFormat)!!
                                    var str_date: String = df1.format(kor_dateFormat)
                                    Log.d("committedDate",str_date)

                                    var day:Int=str_date.substring(8,10).toInt()


                                    var count:Int=monthCount.getOrDefault(day,0)+1
                                    monthCount.set(day,count)
                                    Log.d("monthCount",""+monthCount.toString())


                                }
                                Log.d("repository",repository!!.name)
                            }


                        }
                        for ((key, value) in monthCount){
                            Log.d("value","${key} : ${value}")
                        }
                        Log.d("value","-----------------------")
                        val level1Commit : ArrayList<CalendarDay> = ArrayList()
                        val level2Commit : ArrayList<CalendarDay> = ArrayList()
                        val level3Commit : ArrayList<CalendarDay> = ArrayList()
                        for (entry in monthCount.keys) {
                            if(monthCount.get(entry) in 1..5){
                                level1Commit.add(CalendarDay.from(year,month-1,entry))
                            }else if(monthCount.get(entry) in 6..10){
                                level2Commit.add(CalendarDay.from(year,month-1,entry))
                            }else if(monthCount.get(entry) in 11..1000){
                                level3Commit.add(CalendarDay.from(year,month-1,entry))
                            }
                        }
                        Log.d("level1Commit", "level1Commit: "+level1Commit.toString())
                        mBinding!!.root.post {
                            calendarView.addDecorator(EventDecorator(level1Commit,requireActivity(),"level_1"))
                            calendarView.addDecorator(EventDecorator(level2Commit,requireActivity(),"level_2"))
                            calendarView.addDecorator(EventDecorator(level3Commit,requireActivity(),"level_3"))
                        }
                    }
                    override fun onFailure(e: ApolloException) {
                        TODO("Not yet implemented")
                    }
                })
        }
        else{ //private

            val client:ApolloClient= apolloClient(requireContext())

            client.query(ResultQuery(prefs.getString("username",""),startDate,endDate,RepositoryPrivacy.PRIVATE))
                .enqueue(object :ApolloCall.Callback<ResultQuery.Data>(){
                    @RequiresApi(Build.VERSION_CODES.N)
                    override fun onResponse(response: com.apollographql.apollo.api.Response<ResultQuery.Data>) {
                        var data = response.data!!
                        Log.d("graphql", data.toString())
                        var repositories=data.user!!.repositories
                        for(i in 0..repositories.nodes!!.size-1){
                            var repository= repositories.nodes!![i]
                            if(repository!!.ref!=null){
                                var asCommit= repository!!.ref!!.target!!.asCommit
                                var history=asCommit!!.history
                                for(i in 0 until history.nodes!!.size-1){

                                    var commit= history.nodes!![i]

                                    var committedDate=commit!!.committedDate.toString()

                                    var dateString: String = committedDate.replace("Z", "GMT+00:00")
                                    var dateFormat: Date = df1.parse(dateString)
                                    var kor_dateFormat: Date = convert(dateFormat)!!
                                    var str_date: String = df1.format(kor_dateFormat)

                                    Log.d("committedDate",str_date)

                                    var day:Int=str_date.substring(8,10).toInt()

                                    var count:Int=monthCount.getOrDefault(day,0)+1
                                    monthCount.set(day,count)

                                }
                                Log.d("repository",repository!!.name)
                            }


                        }
                        for ((key, value) in monthCount){
                            Log.d("value","${key} : ${value}")
                        }

                        Log.d("value","-----------------------")
                        val level1Commit : ArrayList<CalendarDay> = ArrayList()
                        val level2Commit : ArrayList<CalendarDay> = ArrayList()
                        val level3Commit : ArrayList<CalendarDay> = ArrayList()
                        for (entry in monthCount.keys) {
                            if(monthCount.get(entry) in 1..5){
                                level1Commit.add(CalendarDay.from(year,month-1,entry))
                            }else if(monthCount.get(entry) in 6..10){
                                level2Commit.add(CalendarDay.from(year,month-1,entry))
                            }else if(monthCount.get(entry) in 11..1000){
                                level3Commit.add(CalendarDay.from(year,month-1,entry))
                            }
                        }
                        Log.d("level1Commit", "level1Commit: "+level1Commit.toString())
                        mBinding!!.root.post {
                            calendarView.addDecorator(EventDecorator(level1Commit,requireActivity(),"level_1"))
                            calendarView.addDecorator(EventDecorator(level2Commit,requireActivity(),"level_2"))
                            calendarView.addDecorator(EventDecorator(level3Commit,requireActivity(),"level_3"))
                        }


                    }
                    override fun onFailure(e: ApolloException) {
                        TODO("Not yet implemented")
                    }
                })

        }

    }
}