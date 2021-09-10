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
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.ApolloCallback
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.toJson
import com.apollographql.apollo.exception.ApolloException
import com.catlove.gitcat.CalendarSelectedDecorator
import com.catlove.gitcat.CalendarTodayDecorator
import com.catlove.gitcat.CalendarUnselectedDecorator
import com.github.peep.App
import com.github.peep.App.Companion.prefs
import com.github.peep.R
import com.github.peep.ResultQuery
import com.github.peep.databinding.FragmentCalendarBinding
import com.github.peep.fragments.HomeFragment.Companion.df1
import com.github.peep.fragments.HomeFragment.Companion.df2
import com.github.peep.graphql.apolloClient
import com.github.peep.model.CommitRoot
import com.github.peep.model.EventResponse
import com.github.peep.type.RepositoryPrivacy
import com.peep.githubapitest.model.Repo
import com.prolificinteractive.materialcalendarview.CalendarDay
import kotlinx.android.synthetic.main.fragment_calendar.*
import org.json.JSONObject
import java.time.LocalDate
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class CalendarFragment : Fragment() {

    private var mBinding : FragmentCalendarBinding?=null
    var detailCommits = JSONObject()

    companion object{
        var id  : String = ""
        var todayDate: Date =Date()
        var commitCount: Int = 0

        var monthCount=HashMap<String,Int>()

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

        getEvents(month,year)

        calendarView.setOnDateChangedListener { widget, date, selected ->
            loading_img.visibility = View.VISIBLE//로딩화면 나타나기
            val year = date.year
            val month=date.month





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
            val mMonth = date.month+1
            val mDay = date.day

            monthCount.clear()

            getEvents(mMonth,mYear)

            Log.i("Move date", mYear.toString() + "")
            Log.i("Move date", mMonth.toString() + "")
            Log.i("Move date", mDay.toString() + "")

            //아마 초기화
            detailCommits = JSONObject()

        }
        mBinding = binding
        return mBinding?.root
    }
    fun convert(date: Date?): Date? { //시차 변환
        val calendar = Calendar.getInstance()
        calendar.time = date
//        calendar.add(Calendar.HOUR,9)
        return calendar.time
    }

    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }

    fun getEvents(month:Int,year:Int){

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
                                    var dateFormat: Date = df1.parse(dateString)
                                    var kor_dateFormat: Date = convert(dateFormat)!!
                                    var str_date: String = df1.format(kor_dateFormat)
                                    Log.d("committedDate",str_date)

                                    var day:String=str_date.substring(8,10)
                                    Log.d("day",day)

                                    var count:Int=monthCount.getOrDefault(day,0)+1
                                    monthCount.remove(day)
                                    monthCount.set(day,count)


                                }
                                Log.d("repository",repository!!.name)
                            }


                        }
                        for ((key, value) in monthCount){
                            Log.d("value","${key} : ${value}")
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

                                    var day:String=str_date.substring(8,10)
                                    Log.d("day",day)

                                    var count:Int=monthCount.getOrDefault(day,0)+1
                                    monthCount.remove(day)
                                    monthCount.set(day,count)


                                }
                                Log.d("repository",repository!!.name)
                            }


                        }
                        for ((key, value) in monthCount){
                            Log.d("value","${key} : ${value}")
                        }
                    }
                    override fun onFailure(e: ApolloException) {
                        TODO("Not yet implemented")
                    }
                })

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
                                var commit= repository!!.ref!!.target!!.asCommit
                                var history=commit!!.history
                                for(i in history.nodes!!.indices){
                                    var commitItem= history.nodes!!.get(i)
                                    var committedDate=commitItem!!.committedDate.toString()

                                    var dateString: String = committedDate.replace("Z", "GMT+00:00")
                                    var dateFormat: Date = df1.parse(dateString)
                                    var kor_dateFormat: Date = convert(dateFormat)!!
                                    var str_date: String = df1.format(kor_dateFormat)

                                    var day:String=str_date.substring(8,10)
                                    Log.d("day",day)

                                    var count:Int=monthCount.getOrDefault(day,0)+1
                                    monthCount.remove(day)
                                    monthCount.set(day,count)


                                }
                                Log.d("repository",repository!!.name)
                            }


                        }
                        for ((key, value) in monthCount){
                            Log.d("value","${key} : ${value}")
                        }
                    }
                    override fun onFailure(e: ApolloException) {
                        TODO("Not yet implemented")
                    }
                })


        }




    }
}