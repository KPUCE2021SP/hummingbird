package com.github.peep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.peep.DB.User
import com.github.peep.DB.UserDB
import com.github.peep.view.CollectionAdapter

import kotlinx.android.synthetic.main.activity_collection.*
import java.lang.Exception

//메인 쓰레드에서 Romm DB에 접근하려고 하면 에러가 발생
//Cannot access database on the main thread since it may potentially lock the UI for a long period of time.
//따라서 Room과 관련된 액션은 Thread, AsyncTask 등을 이용해 백그라운드에서 작업해야 한다.

//큰그림은 CatDataBase의 Room.databaseBuilder를 호출해 새로운 db 객체를 만들고. 데이터를 읽기/쓰기는 서브 쓰레드에서 작업
class CollectionActicity : AppCompatActivity() {
    private var userDb: UserDB? = null
    private var userList = listOf<User>()
    lateinit var mAdapter: CollectionAdapter

    val newUser = User() //새로운 객체를 생성, id 이외의 값을 지정 후 DB에 추가

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collection)
        userDb = UserDB.getInstance(this)
        mAdapter = CollectionAdapter(this, userList)

        //리사이클 뷰에 주입된 데이터를 뿌려줌
        val r = Runnable {
            try {
                userList = userDb?.userDao()?.getAll()!!
                mAdapter = CollectionAdapter(this, userList)
                mAdapter.notifyDataSetChanged()

                mRecyclerView.adapter = mAdapter
                mRecyclerView.layoutManager = LinearLayoutManager(this)
                mRecyclerView.setHasFixedSize(true)
            } catch (e: Exception) {
                Log.d("tag", "Error - $e")
            }
        }

        val rthread = Thread(r)
        rthread.start()
    }

<<<<<<< HEAD
    override fun onDestroy(){
        UserDB.destroyInstance()
        userDb = null
        super.onDestroy()
=======
    private fun initRecycler() {
        collectionAdapter = CollectionAdapter(this)
        rv_profile.adapter = collectionAdapter

        //firebase 에 연동되어 있지 않기 때문에 임의의 더미 데이터 삽입
        datas.apply {
            add(CollectionData(img = R.drawable.peep_illust, name = "일러삡", count = 0))

            collectionAdapter.datas = datas

            rv_profile.addItemDecoration(VerticalItemDecorator(20))
            rv_profile.addItemDecoration(HorizontalItemDecorator(10))
            collectionAdapter.notifyDataSetChanged()
        }
>>>>>>> origin/ah-2
    }
}