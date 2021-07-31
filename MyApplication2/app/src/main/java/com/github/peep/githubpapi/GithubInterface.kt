package com.peep.githubapitest.githubpapi

import com.peep.githubapitest.model.RepoRoot
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
    fun getUserRepos(): Call<List<RepoRoot>>

    @GET("repos/{username}/{reponame}/commits")
    fun getRepoCommit(username:String,reponame:String):Call<List<RepoRoot>>?

}
