package com.peep.githubapitest.githubpapi

import com.github.peep.model.Events
import com.peep.githubapitest.model.Repo
import com.peep.githubapitest.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubInterface {
    @GET("user")
    fun getUser(): Call<User>


    @GET("user/repos")
    fun getUserRepos(): Call<List<Repo>>

    @GET("repos/{username}/{reponame}/commits")
    fun getRepoCommit(username:String,reponame:String):Call<List<Repo>>?

    @GET("users/{username}/events")
    fun getEvents(@Path("username")username:String):Call<Events>?

}
