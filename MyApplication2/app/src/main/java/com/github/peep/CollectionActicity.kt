package com.github.peep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.peep.App.Companion.prefs
import com.github.peep.DB.User
import com.github.peep.DB.UserDB
import com.github.peep.view.HorizontalItemDecorator
import com.github.peep.view.CollectionAdapter
import com.github.peep.view.CollectionData

import com.github.peep.view.VerticalItemDecorator
import com.peep.githubapitest.githubpapi.ApiClient
import com.peep.githubapitest.githubpapi.GithubInterface
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_collection.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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

        //DB에 데이터 주입
        val addRunnable = Runnable {
            var GithubService= ApiClient.client.create(GithubInterface::class.java)
            val call=GithubService.getUser()

            //Rest API를 통해 유저 정보를 받아오는게 안됨
            call.enqueue(object: Callback<com.peep.githubapitest.model.User> {
                override fun onResponse(call: Call<com.peep.githubapitest.model.User>, response: Response<com.peep.githubapitest.model.User>) {
                    Log.d("fullresponse", response.toString())
                    if (response.code() == 200) {
                        val user=response.body()
                        if (user != null) {
                            Log.d("test","test success")
                            newUser.git_Name = user.name
                        }
                    } else {
                        Log.e("err",response.code().toString())
                    }
                }

                override fun onFailure(call: Call<com.peep.githubapitest.model.User>, t: Throwable) {
                    Log.d("error","error")
                }
            })

            newUser.git_Token = prefs.getString("token","")
            newUser.happy_Peep = 10
            newUser.sad_Peep = 5
            userDb?.userDao()?.insert(newUser)
        }

        //리사이클 뷰에 주입된 데이터를 뿌려줌
        val r = Runnable {
            try{
                userList = userDb?.userDao()?.getAll()!!
                mAdapter = CollectionAdapter(this, userList)
                mAdapter.notifyDataSetChanged()

                mRecyclerView.adapter = mAdapter
                mRecyclerView.layoutManager = LinearLayoutManager(this)
                mRecyclerView.setHasFixedSize(true)
            } catch( e : Exception) {
                Log.d("tag", "Error - $e")
            }
        }
        val addThread = Thread(addRunnable)
        addThread.start()

        val thread = Thread(r)
        thread.start()
    }

    override fun onDestroy(){
        UserDB.destroyInstance()
        userDb = null
        super.onDestroy()
    }

}