package com.github.peep.model

class EventResponse : ArrayList<EventResponseItem>()

data class EventResponseItem(
    val actor: Actor,
    val created_at: String,
    val id: String,
    val org: Org,
    val payload: Payload,
    val `public`: Boolean,
    val repo: Repo,
    val type: String
)

data class Actor(
    val avatar_url: String,
    val display_login: String,
    val gravatar_id: String,
    val id: Int,
    val login: String,
    val url: String
)

data class Org(
    val avatar_url: String,
    val gravatar_id: String,
    val id: Int,
    val login: String,
    val url: String
)

data class Payload(
    val description: Any,
    val master_branch: String,
    val pusher_type: String,
    val ref: Any,
    val ref_type: String
)

data class Repo(
    val id: Int,
    val name: String,
    val url: String
)