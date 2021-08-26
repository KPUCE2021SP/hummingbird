package com.github.peep

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.peep.DB.User
import com.github.peep.DB.UserDB
import com.github.peep.view.CollectionAdapter
import com.github.peep.view.CollectionData
import com.github.peep.view.HorizontalItemDecorator
import com.github.peep.view.VerticalItemDecorator

import kotlinx.android.synthetic.main.activity_collection.*
import java.lang.Exception

//메인 쓰레드에서 Romm DB에 접근하려고 하면 에러가 발생
//Cannot access database on the main thread since it may potentially lock the UI for a long period of time.
//따라서 Room과 관련된 액션은 Thread, AsyncTask 등을 이용해 백그라운드에서 작업해야 한다.

//큰그림은 CatDataBase의 Room.databaseBuilder를 호출해 새로운 db 객체를 만들고. 데이터를 읽기/쓰기는 서브 쓰레드에서 작업
class CollectionActicity : AppCompatActivity() {
    lateinit var collectionAdapter: CollectionAdapter

    val datas = mutableListOf<CollectionData>()
    //private var currentPeep: String? = intent.getStringExtra("currentPeep")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collection)

        collectionAdapter = CollectionAdapter(this)
        rv_profile.adapter = collectionAdapter

        renew_btn.setOnClickListener {
//            if(currentPeep != null){
//                if(datas.isEmpty() == true){
//                    Toast.makeText(this,"${currentPeep}",Toast.LENGTH_SHORT).show()
//                }
//            }
        }
    }

    private fun initRecycler() {
        //firebase 에 연동되어 있지 않기 때문에 임의의 더미 데이터 삽입
        datas.apply {
            add(CollectionData(img = R.drawable.peep_illust, name = "일러삡", count = 0))

            collectionAdapter.datas = datas

            rv_profile.addItemDecoration(VerticalItemDecorator(20))
            rv_profile.addItemDecoration(HorizontalItemDecorator(10))
            collectionAdapter.notifyDataSetChanged()
        }
    }

}