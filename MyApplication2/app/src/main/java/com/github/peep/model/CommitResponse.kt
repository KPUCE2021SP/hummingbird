package com.github.peep.model

import java.util.*

data class Author (
    var name: String,
    var email:String ,
    var date: Date,
    var login:String,
    var id:Int,
    var node_id:String ,
    var avatar_url:String ,
    var gravatar_id:String ,
    var url:String ,
    var html_url:String ,
    var followers_url:String ,
    var following_url:String ,
    var gists_url:String ,
    var starred_url:String ,
    var subscriptions_url:String ,
    var organizations_url: String,
    var repos_url:String ,
    var events_url:String ,
    var received_events_url:String ,
    var type:String ,
    var site_admin :Boolean
)

data class Committer (
    var name:String ,
    var email: String,
    var date: Date,
    var login: String,
    var id:Int,
    var node_id: String,
    var avatar_url:String ,
    var gravatar_id:String ,
    var url:String ,
    var html_url: String,
    var followers_url:String ,
    var following_url:String ,
    var gists_url: String,
    var starred_url: String,
    var subscriptions_url:String ,
    var organizations_url:String ,
    var repos_url:String ,
    var events_url: String,
    var received_events_url: String,
    var type:String ,
    var site_admin:Boolean
)

data class Tree (
    var sha: String,
    var url: String,
)

data class Verification (
    var verified :Boolean,
    var reason:String ,
    var signature: String,
    var payload: String,
)

data class Commit (
    var author: Author,
    var committer: Committer,
    var message: String,
    var tree: Tree,
    var url: String,
    var comment_count :Int,
    var verification: Verification
)

data class Parent (
    var sha:String ,
    var url: String,
    var html_url:String ,
)

data class CommitRoot (
    var sha: String,
    var node_id: String,
    var commit: Commit,
    var url: String,
    var html_url:String ,
    var comments_url:String ,
    var author: Author,
    var committer: Committer,
    var parents: List<Parent>
)