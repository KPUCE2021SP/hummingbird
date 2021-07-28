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
    fun getUserDetails(@Header("Authentication")accesstoken: String): Call<User>


    @GET("user/repos")
    fun getUserRepos(@Header("Authentication")accesstoken: String): Call<List<Repo>>

    @GET("login/oauth/authorize?client_id={client_id}")
    fun getPrivateCode(@Query("client_id")client_id:String) : Call<Code>

}