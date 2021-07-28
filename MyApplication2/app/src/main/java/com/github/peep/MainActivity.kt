package com.github.peep

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.github.peep.databinding.ActivityMainBinding
import com.google.firebase.auth.GithubAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


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
    private fun authWithGithub() {

        // [START auth_with_github]
        val token = "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"
        val credential = GithubAuthProvider.getCredential(token)
        Firebase.auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                Log.d(TAG, "signInWithCredential:onComplete:" + task.isSuccessful)

                // If sign in fails, display a message to the user. If sign in succeeds
                // the auth state listener will be notified and logic to handle the
                // signed in user can be handled in the listener.
                if (!task.isSuccessful) {
                    Log.w(TAG, "signInWithCredential", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }

                // ...
            }
        // [END auth_with_github]
    }
}