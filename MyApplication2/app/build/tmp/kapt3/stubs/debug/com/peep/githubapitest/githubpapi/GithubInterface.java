package com.peep.githubapitest.githubpapi;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\'J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003H\'J\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'\u00a8\u0006\f"}, d2 = {"Lcom/peep/githubapitest/githubpapi/GithubInterface;", "", "getRepoCommit", "Lretrofit2/Call;", "", "Lcom/peep/githubapitest/model/RepoRoot;", "username", "", "reponame", "getUser", "Lcom/peep/githubapitest/model/User;", "getUserRepos", "app_debug"})
public abstract interface GithubInterface {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "user")
    public abstract retrofit2.Call<com.peep.githubapitest.model.User> getUser();
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "user/repos")
    public abstract retrofit2.Call<java.util.List<com.peep.githubapitest.model.RepoRoot>> getUserRepos();
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "repos/{username}/{reponame}/commits")
    public abstract retrofit2.Call<java.util.List<com.peep.githubapitest.model.RepoRoot>> getRepoCommit(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String reponame);
}