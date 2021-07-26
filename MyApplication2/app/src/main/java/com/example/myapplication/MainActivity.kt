package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.OAuthProvider


class MainActivity : AppCompatActivity(){

    //나중에 값이 설정될거라고 lateinit으로 설정
    lateinit var myNumberViewModel: MyNumberViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val provider = OAuthProvider.newBuilder("github.com")

    }

}