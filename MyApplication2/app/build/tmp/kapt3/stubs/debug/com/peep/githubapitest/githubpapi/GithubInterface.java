package com.peep.githubapitest.githubpapi;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J\u001e\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'\u00a8\u0006\n"}, d2 = {"Lcom/peep/githubapitest/githubpapi/GithubInterface;", "", "getUser", "Lretrofit2/Call;", "Lcom/peep/githubapitest/model/User;", "accesstoken", "", "getUserRepos", "", "Lcom/peep/githubapitest/model/Repo;", "app_debug"})
public abstract interface GithubInterface {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "user")
    public abstract retrofit2.Call<com.peep.githubapitest.model.User> getUser(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String accesstoken);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "user/repos")
    public abstract retrofit2.Call<java.util.List<com.peep.githubapitest.model.Repo>> getUserRepos(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String accesstoken);
}