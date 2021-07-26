package codevinci.com.kotlinretrofitrestexample.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import codevinci.com.kotlinretrofitrestexample.R
import codevinci.com.kotlinretrofitrestexample.adapter.RecyclerViewAdapter
import codevinci.com.kotlinretrofitrestexample.githubpapi.ApiClient
import codevinci.com.kotlinretrofitrestexample.githubpapi.GithubInterface
import codevinci.com.kotlinretrofitrestexample.model.RecyclerViewItems
import codevinci.com.kotlinretrofitrestexample.model.Repo
import codevinci.com.kotlinretrofitrestexample.model.User
import codevinci.com.kotlinretrofitrestexample.util.NetworkConection
import codevinci.com.kotlinretrofitrestexample.util.picasso
import kotlinx.android.synthetic.main.activity_user_details.*
import kotlinx.android.synthetic.main.content_user_details.*
import kotlinx.android.synthetic.main.profile_view.*
import kotlinx.android.synthetic.main.profile_view.ivAvatar
import kotlinx.android.synthetic.main.profile_view.rvMoreDetails
import kotlinx.android.synthetic.main.profile_view.tvFollowers
import kotlinx.android.synthetic.main.profile_view.tvFollowing
import kotlinx.android.synthetic.main.profile_view.tvFullName
import kotlinx.android.synthetic.main.profile_view.tvLocation
import kotlinx.android.synthetic.main.profile_view.tvRepos
import kotlinx.android.synthetic.main.profile_view.tvUsername
import kotlinx.android.synthetic.main.repo_view.*
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.indeterminateProgressDialog
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserDetailsActivity : AppCompatActivity() {
    lateinit var mAdapter: RecyclerViewAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val accessToken: String = intent.getStringExtra("access_token")
                ?: ""//get access token from previous activity
        Log.d("accesstoken_test", accessToken)
        initViews()
        fabSearch.setOnClickListener { view->initViews() }
        btnProfile.setOnClickListener { view ->
            val username: String = etUsername.text.toString()
            if (username.isNotEmpty()) {
                if (NetworkConection.isNetworkConnected(applicationContext)) {
                    getUserDetails(accessToken, username)
                } else {
                    snackbar(view, getString(R.string.error_internet))
                }
            } else {
                etUsername?.error = getString(R.string.error_enter_username)
            }
        }
        btnRepo.setOnClickListener { view->
            val username:String=etUsername.text.toString()
            if (username.isNotEmpty()) {
                if (NetworkConection.isNetworkConnected(applicationContext)) {
                    getUserRepos(accessToken,username)
                } else {
                    snackbar(view, getString(R.string.error_internet))
                }
            } else {
                etUsername?.error = getString(R.string.error_enter_username)
            }
        }

    }



    @SuppressLint("RestrictedApi")
//hide profile view features and only show search bar
    fun initViews() {
        llSearchView.visibility = View.VISIBLE
        llProfileView.visibility = View.GONE
        llRepoView.visibility = View.GONE
        fabSearch.visibility = View.GONE
        rvMoreDetails.layoutManager = LinearLayoutManager(this)
        rvMoreDetails.setHasFixedSize(true)
    }

    @SuppressLint("RestrictedApi")
    fun showUserView() {
        llSearchView.visibility = View.GONE
        llProfileView.visibility = View.VISIBLE
        fabSearch.visibility = View.VISIBLE
        llRepoView.visibility=View.GONE
    }

    @SuppressLint("RestrictedApi")
    fun showRepoView() {
        llSearchView.visibility = View.GONE
        llProfileView.visibility = View.GONE
        fabSearch.visibility = View.VISIBLE
        llRepoView.visibility=View.VISIBLE
    }

    fun getUserDetails(accessToken: String, username: String) {
        val dialog = indeterminateProgressDialog(message = "Please wait a bit…", title = "Fetching data")
        val accessTokenWithBearer = "Bearer $accessToken"
        val GithubService = ApiClient.client.create(GithubInterface::class.java)
        val call = GithubService.getUserDetails(accessTokenWithBearer, username)

        call.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                dialog.dismiss()
                Log.d("fullresponse", response.toString())
                if (response.code() == 200) {
                    val user = response.body()
                    userViews(user!!)
                } else {
                    Log.e("err",response.code().toString())
                    toast(response.message())
                }

            }

            override fun onFailure(call: Call<User>?, t: Throwable?) {
                dialog.dismiss()
                toast(getString(R.string.error_server))
            }
        })
    }

    fun getUserRepos(accessToken: String, username: String) {
        val dialog = indeterminateProgressDialog(message = "Please wait a bit…", title = "Fetching data")

        val accessTokenWithBearer = "Bearer $accessToken"
        val GithubService = ApiClient.client.create(GithubInterface::class.java)
        val call = GithubService.getUserRepos(accessTokenWithBearer,username)
        call.enqueue(object:Callback<List<Repo>>{
            override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {
                dialog.dismiss()
                Log.d("fullresponse",response.toString())
                if(response.code()==200){
                    var repos:List<Repo> = response.body()!!
                    repoViews(repos)
                }
                else{
                    toast(response.message())
                }
            }

            override fun onFailure(call: Call<List<Repo>>, response: Throwable) {
                dialog.dismiss()
                toast(getString(R.string.error_server))
            }
        }


        )
    }

    fun userViews(user: User?) {
        showUserView()
        picasso.load(user?.avatar_url).into(ivAvatar)
        tvFullName.text = user?.name
        tvUsername.text = user?.login
        tvLocation.text = user?.location?:"NA"
        tvFollowers.text = user?.followers.toString()
        tvRepos.text = user?.public_repos.toString()
        tvFollowing.text = user?.following.toString()

        //build a list of items to be showcased in the recycler view
        var email = user?.email?:"Unknown"
        var moreItemsList: ArrayList<RecyclerViewItems> = ArrayList()
        moreItemsList.add(RecyclerViewItems("Email: $email",null))
        moreItemsList.add(RecyclerViewItems("Subscriptions",user?.subscriptions_url))
        moreItemsList.add(RecyclerViewItems("Organizations",user?.organizations_url))
        moreItemsList.add(RecyclerViewItems("Received Events",user?.received_events_url))
        moreItemsList.add(RecyclerViewItems("Full Profile",user?.html_url))

        mAdapter = RecyclerViewAdapter(this,moreItemsList)
        rvMoreDetails.adapter = mAdapter

    }

    fun repoViews(repos: List<Repo>) { //여기서 Repo 리스트를 Repo 하나 하나로 분리해서 view에 띄워줘야 함
        showRepoView()
        var count:Int=0
        for (i:Int in 0..repos.size){
            count++
        }
        repoData.setText(count.toString()) //repository에 접근할 수 있는지 테스트 하기 위해 repository의 개수로 확인


    }

}
