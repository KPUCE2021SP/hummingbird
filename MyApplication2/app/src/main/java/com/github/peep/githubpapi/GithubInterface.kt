package com.peep.githubapitest.githubpapi

import com.github.peep.model.CommitRoot
import com.github.peep.model.EventResponse
import com.github.peep.model.RepoCommitsResponse
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
    fun getRepoCommit(@Path("username")username:String,@Path("reponame")reponame:String):Call<List<CommitRoot>>

    // Activity data의 events api
    // push, Issue PullRequest 등등 조회 가능!
    //-> pushPull & PullRequestEvent 활용
    // Only events created within the past 90 days will be included in timelines.
    // Events older than 90 days will not be included (even if the total number of events in the timeline is less than 300).
    @GET("users/{username}/events")
    fun getUserEvents(@Path("username") username:String):Call<EventResponse>
}
