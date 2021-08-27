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

    var datas = mutableListOf<CollectionData>()
    //yellow,red,green,blue,peigeon 순서대로 가지고 병아리의 숫자.
    //이후엔 map으로 수정할 예정
    val peepCount = arrayOf(0,0,0,0,0)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collection)
        var currentPeep: String? = intent.getStringExtra("currentPeep")
        collectionAdapter = CollectionAdapter(this)
        rv_profile.adapter = collectionAdapter

        if (currentPeep != null) {
            if (datas.isEmpty() == true) {
                when (currentPeep) {
                    "yellow" -> {
                        peepCount[0]++
                        Toast.makeText(this, "${currentPeep}", Toast.LENGTH_SHORT).show()
                        datas.add(CollectionData(img = R.drawable.basic_neutral, name = currentPeep, count = peepCount[0]))
                    }
                    "red" -> {
                        peepCount[1]++
                        Toast.makeText(this, "${currentPeep}", Toast.LENGTH_SHORT).show()
                        datas.add(CollectionData(img = R.drawable.basic_neutral, name = currentPeep, count = peepCount[1]))

                    }
                    "green" -> {
                        peepCount[2]++
                        Toast.makeText(this, "${currentPeep}", Toast.LENGTH_SHORT).show()
                        datas.add(CollectionData(img = R.drawable.basic_neutral, name = currentPeep, count = peepCount[2]))

                    }
                    "blue" -> {
                        peepCount[3]++
                        Toast.makeText(this, "${currentPeep}", Toast.LENGTH_SHORT).show()
                        datas.add(CollectionData(img = R.drawable.basic_neutral, name = currentPeep, count = peepCount[3]))

                    }
                    "peigeon" -> {
                        peepCount[4]++
                        Toast.makeText(this, "${currentPeep}", Toast.LENGTH_SHORT).show()
                        datas.add(CollectionData(img = R.drawable.basic_neutral, name = currentPeep, count = peepCount[4]))
                    }
                }
            }
        }
        else{
            collectionAdapter.datas = datas
            collectionAdapter.notifyDataSetChanged()
        }
    }

    //졸업한 병아리가 없을때 최초 수행
    private fun initRecycler(name : String, count : Int, img : Int) {
        //firebase 에 연동되어 있지 않기 때문에 임의의 더미 데이터 삽입
        datas.add(CollectionData(img = img, name = name, count = count))

        collectionAdapter.datas = datas

        rv_profile.addItemDecoration(VerticalItemDecorator(20))
        rv_profile.addItemDecoration(HorizontalItemDecorator(10))
        collectionAdapter.notifyDataSetChanged()
        }
    }