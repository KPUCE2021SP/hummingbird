package com.peep.githubapitest.githubpapi

import com.peep.githubapitest.model.Code
import com.peep.githubapitest.model.Repo
import com.peep.githubapitest.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubInterface {
    @GET("user")
    fun getUser(@Header("Authorization")accesstoken: String): Call<User>


    @GET("user/repos")
    fun getUserRepos(@Header("Authorization")accesstoken: String): Call<List<Repo>>

}
