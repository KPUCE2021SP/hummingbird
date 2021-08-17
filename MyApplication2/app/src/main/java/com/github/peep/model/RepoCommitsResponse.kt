package com.github.peep.model;

class RepoCommitsResponse: ArrayList<RepoCommitsResponseItem>()

data class RepoCommitsResponseItem(
    val author: Author,
    val comments_url: String,
    val commit: Commit,
    val committer: Committer,
    val html_url: String,
    val node_id: String,
    val message: String,
    val parents: List<Parent>,
    val sha: String,
    val url: String
)