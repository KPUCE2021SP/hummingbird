package com.github.peep.githubpapi
import com.github.peep.model.Repo
import com.github.peep.model.User
import retrofit2.Call
import retrofit2.http.GET

interface GithubInterface {
    @GET("user")
    fun getUser(): Call<User>


    @GET("user/repos")
    fun getUserRepos(): Call<List<Repo>>
//
//    @GET("repos/{username}/{reponame}/commits")
//    fun getRepoCommit(username:String,reponame:String):Call<List<Repo>>?

}
