package com.peep.githubapitest.model

data class Code(
    val code:String
)

data class CodeResponse(val message:String?,val documentation_url:String?,var code: Code)