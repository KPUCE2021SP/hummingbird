package com.github.peep.model

data class Payload(
    val description: String,
    val master_branch: String,
    val pusher_type: String,
    val ref: String,
    val ref_type: String
)