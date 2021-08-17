package com.github.peep.model;

class RepoCommitsResponse: ArrayList<RepoCommitsResponseItem>()

data class RepoCommitsResponseItem(
    val author: Any,
    val comments_url: String,
    val commit: Commit,
    val committer: Any,
    val html_url: String,
    val node_id: String,
    val parents: List<Any>,
    val sha: String,
    val url: String
)