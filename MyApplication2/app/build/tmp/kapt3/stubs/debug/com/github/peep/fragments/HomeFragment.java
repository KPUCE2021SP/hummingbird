package com.github.peep.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J&\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/github/peep/fragments/HomeFragment;", "Landroidx/fragment/app/Fragment;", "()V", "mBinding", "Lcom/github/peep/databinding/FragmentHomeBinding;", "getUser", "", "getUserRepos", "logout", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "refreshFragment", "fragment", "framentManager", "Landroidx/fragment/app/FragmentManager;", "Companion", "app_debug"})
public final class HomeFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    public static final com.github.peep.fragments.HomeFragment.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String reponame = "";
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String username = "";
    @org.jetbrains.annotations.Nullable()
    private static java.util.List<com.peep.githubapitest.model.RepoRoot> repos;
    private com.github.peep.databinding.FragmentHomeBinding mBinding;
    private java.util.HashMap _$_findViewCache;
    
    public HomeFragment() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    public final void getUser() {
    }
    
    public final void getUserRepos() {
    }
    
    public final void logout() {
    }
    
    public final void refreshFragment(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment fragment, @org.jetbrains.annotations.Nullable()
    androidx.fragment.app.FragmentManager framentManager) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b\u00a8\u0006\u0013"}, d2 = {"Lcom/github/peep/fragments/HomeFragment$Companion;", "", "()V", "reponame", "", "getReponame", "()Ljava/lang/String;", "setReponame", "(Ljava/lang/String;)V", "repos", "", "Lcom/peep/githubapitest/model/RepoRoot;", "getRepos", "()Ljava/util/List;", "setRepos", "(Ljava/util/List;)V", "username", "getUsername", "setUsername", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getReponame() {
            return null;
        }
        
        public final void setReponame(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getUsername() {
            return null;
        }
        
        public final void setUsername(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.util.List<com.peep.githubapitest.model.RepoRoot> getRepos() {
            return null;
        }
        
        public final void setRepos(@org.jetbrains.annotations.Nullable()
        java.util.List<com.peep.githubapitest.model.RepoRoot> p0) {
        }
    }
}