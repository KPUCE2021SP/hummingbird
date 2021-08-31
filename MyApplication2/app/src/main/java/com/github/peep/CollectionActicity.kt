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
import com.github.peep.decorator.AlertDesign
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
    companion object {
        val peepName = arrayOf("yellow", "red", "green", "blue", "pigeon")
        var peepCount = arrayOf(0, 0, 0, 0, 0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collection)
        var currentPeep: String? = intent.getStringExtra("currentPeep")
        collectionAdapter = CollectionAdapter(this)
        rv_profile.adapter = collectionAdapter

        //졸업 기능이 이루어질 때
        if (currentPeep != null) {
            for (i in peepName.indices) {
                if (peepName[i] == currentPeep) {
                    peepCount[i]++
                }
            }
            gradPeepCount()

            //리사이클러 뷰 데이터 적용
            collectionAdapter.datas = datas
            rv_profile.addItemDecoration(VerticalItemDecorator(20))
            rv_profile.addItemDecoration(HorizontalItemDecorator(10))
            collectionAdapter.notifyDataSetChanged()

            //커밍 기능을 위한 팝업
            //예를 누르면 새로운 병아리가 오고, 취소 혹은 뒤로가기를 누르면 현재 병아리를 다시 한번 키운다.
            showSettingPopup("새로운 병아리")
        }
        //졸업 기능이 이뤄지지 않고 그냥 컬렉션 볼때
        //hard coding으로 구현
        else {
            Toast.makeText(this, "null? : ${currentPeep}", Toast.LENGTH_SHORT).show()
            gradPeepCount()

            //리사이클러 뷰에 데이터 적용
            collectionAdapter.datas = datas
            rv_profile.addItemDecoration(VerticalItemDecorator(20))
            rv_profile.addItemDecoration(HorizontalItemDecorator(10))
            collectionAdapter.notifyDataSetChanged()
        }
    }

    //졸업한 병아리의 수를 카운팅하는 함수
    //만약 졸업한 병아리가 있다면 해당 병아리를 리사이클러뷰에 추가해준다.
    fun gradPeepCount() {
        for (i in peepCount.indices) {
            if (peepCount[i] != 0) {
                when (i) {
                    //yellow
                    0 -> {
                        datas.add(
                            CollectionData(
                                img = R.drawable.peep_illust,
                                name = "yellow",
                                count = peepCount[0]
                            )
                        )
                    }
                    //red
                    1 -> {
                        datas.add(
                            CollectionData(
                                img = R.drawable.red_peep_illust,
                                name = "red",
                                count = peepCount[1]
                            )
                        )
                    }
                    //green
                    2 -> {
                        datas.add(
                            CollectionData(
                                img = R.drawable.green_peep_illust,
                                name = "green",
                                count = peepCount[2]
                            )
                        )
                    }
                    //blue
                    3 -> {
                        datas.add(
                            CollectionData(
                                img = R.drawable.blue_peep_illust,
                                name = "blue",
                                count = peepCount[3]
                            )
                        )
                    }
                    //pigeon
                    4 -> {
                        datas.add(
                            CollectionData(
                                img = R.drawable.pigeon_illu,
                                name = "pigeon",
                                count = peepCount[4]
                            )
                        )
                    }
                }
            }
        }
    }

    //커밍 기능을 위한 팝업 함수.
    fun showSettingPopup(string: String) {
        AlertDesign(this)
            .setTitle("새로운 병아리")
            .setMessage(string)
            .setPositiveButton("예") {
                var intent = Intent(this, PeepSelectActivity::class.java)
                finish()
                startActivity(intent)
            }
            .setNegativeButton("취소") {
                finish()
            }
            .show()

    }

    private fun initRecycler(name: String, count: Int, img: Int) {
        datas.add(CollectionData(img = img, name = name, count = count))

        collectionAdapter.datas = datas

        rv_profile.addItemDecoration(VerticalItemDecorator(20))
        rv_profile.addItemDecoration(HorizontalItemDecorator(10))
        collectionAdapter.notifyDataSetChanged()
    }
}