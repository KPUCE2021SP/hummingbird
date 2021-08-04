package com.peep.githubapitest.githubpapi

import com.github.peep.model.CommitRoot
import com.github.peep.model.EventResponse
import com.peep.githubapitest.model.RepoRoot
import com.peep.githubapitest.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubInterface {
    @GET("user")
    fun getUser(): Call<User>


    @GET("user/repos")
    fun getUserRepos(): Call<List<RepoRoot>>

    // user에서 repo들을 검색한 후 repo들의 커밋 기록 조회
    // 내 repo가 아닌 다른 레포일 경우 또는 repo가 많은 사용자의 경우 repo 만큼 call이 발생해 성능 저하
    @GET("repos/{username}/{reponame}/commits")
    fun getRepoCommit(username:String,reponame:String):Call<List<CommitRoot>>?

    // Activity data의 events api
    // push, Issue PullRequest 등등 조회 가능!
    //-> pushPull & PullRequestEvent 활용
    // Only events created within the past 90 days will be included in timelines.
    // Events older than 90 days will not be included (even if the total number of events in the timeline is less than 300).
    @GET("users/{username}/events")
    fun getUserEvents(@Path("username") username:String):Call<EventResponse>

}