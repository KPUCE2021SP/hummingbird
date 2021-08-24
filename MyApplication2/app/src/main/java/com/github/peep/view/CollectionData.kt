package com.github.peep.view

//병아리 콜렉션 데이터 -> 현재 db 패키지내 UserDB를 사용
data class CollectionData (
    val name : String,
    val count : Int,
    val img : Int
    )