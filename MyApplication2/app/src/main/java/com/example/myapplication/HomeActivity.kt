package com.example.myapplication

import android.R
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import com.example.myapplication.databinding.ActivityHomeBinding
import com.google.firebase.auth.GithubAuthProvider
import com.google.firebase.auth.OAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class HomeActivity : AppCompatActivity() {
    var provider = OAuthProvider.newBuilder("github.com")
    var scopes = arrayListOf<String>()

    private lateinit var mBinding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        // Target specific email with login hint.

        mBinding.loginBtn.setOnClickListener {
            provider.addCustomParameter("login", "test@gmail.com");
            scopes.add("user:email")
            provider.setScopes(scopes)
            val token = "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"

            val credential = GithubAuthProvider.getCredential(token)

            val uri: Uri = Uri.parse("https://github.com/login?return_to=%2Fsignup%3Fref_cta%3DSign%2Bup%26ref_loc%3Dheader%2Blogged%2Bout%26ref_page%3D%252F%26source%3Dheader-home")

            // create an intent builder
            val intentBuilder = CustomTabsIntent.Builder()

            // set start and exit intent
            val customTabsIntent = intentBuilder.build()

            // launch the url
            // customTabsIntent.launchUrl(MainActivity, uri);
            customTabsIntent.launchUrl(this, uri)

            Firebase.auth
                .signInWithCredential(credential)
                .addOnSuccessListener {
                    Log.d("login", "success")
                    val intent = Intent(this, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                    startActivity(intent)
                    finish()
                }
                .addOnFailureListener {
                    // Handle failure.
                    Log.d("login", "fail")
                    Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
                }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

}