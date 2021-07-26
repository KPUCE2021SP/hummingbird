package codevinci.com.kotlinretrofitrestexample.githubpapi

import codevinci.com.kotlinretrofitrestexample.model.Repo
import codevinci.com.kotlinretrofitrestexample.model.User
import codevinci.com.kotlinretrofitrestexample.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface GithubInterface {
    @GET("users/{username}")
    fun getUserDetails(@Header("Authorization") accesstoken: String, @Path("username") username: String): Call<User>


    @GET("users/{username}/repos")
    fun getUserRepos(@Header("Repository") accesstoken: String, @Path("username") username:String): Call<List<Repo>>
}