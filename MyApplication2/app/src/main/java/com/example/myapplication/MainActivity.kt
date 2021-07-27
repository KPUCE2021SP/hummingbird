package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.firebase.auth.OAuthProvider


class MainActivity : AppCompatActivity(){

    private lateinit var mBinding : ActivityMainBinding

    //나중에 값이 설정될거라고 lateinit으로 설정
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        //네비게이션을 담는 호스트
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.my_nav_host) as NavHostFragment

        // 네비게이션 컨트롤러
        val navController = navHostFragment.navController

        //바텀 네비게이션뷰와 네비게이션 뷰를 묶어준다.
        NavigationUI.setupWithNavController(mBinding.myBottomNav, navController)
    }
}