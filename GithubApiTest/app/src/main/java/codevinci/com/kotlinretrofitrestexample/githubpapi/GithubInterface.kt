package codevinci.com.kotlinretrofitrestexample.githubpapi

import codevinci.com.kotlinretrofitrestexample.model.Repo
import codevinci.com.kotlinretrofitrestexample.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface GithubInterface {
    @GET("users/{username}")
    fun getUserDetails(@Header("auth")accesstoken: String, @Path("username") username: String): Call<User>


    @GET("users/{username}/repos")
    fun getUserRepos(@Header("auth")accesstoken: String, @Path("username") username:String): Call<List<Repo>>
}