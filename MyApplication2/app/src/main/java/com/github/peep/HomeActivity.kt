package com.github.peep

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.peep.App.Companion.prefs
import com.github.peep.databinding.ActivityHomeBinding
import com.github.peep.databinding.ActivityMainBinding
import com.github.rahul.githuboauth.ErrorCallback
import com.github.rahul.githuboauth.GithubAuthenticator
import com.github.rahul.githuboauth.SuccessCallback


class HomeActivity : AppCompatActivity() {
    private val mContext: Context?=null



    private lateinit var hBinding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        hBinding= ActivityHomeBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        val githubAuthenticatorBuilder = GithubAuthenticator.builder(this)
            .clientId(BuildConfig.CLIENT_ID)
            .clientSecret(BuildConfig.CLIENT_SECRET)
            .onSuccess(object : SuccessCallback {
                override fun onSuccess(result: String) {
                    runOnUiThread {
                        val intent= Intent(this@HomeActivity,MainActivity::class.java)
                        App.prefs.setString("token",result)
                        finish()
                        startActivity(intent)

                    }
                }
            })
            .onError(object : ErrorCallback {
                override fun onError(error: Exception) {
                    runOnUiThread {
                        Toast.makeText(this@HomeActivity,error.message, Toast.LENGTH_SHORT).show()
                    }
                }
            })

        val githubAuthenticator = githubAuthenticatorBuilder.build()

        if(prefs.getString("token","").equals("")){
            githubAuthenticatorBuilder.debug(true)
            setContentView(hBinding.root)


            // Target specific email with login hint.
            hBinding.loginBtn.setOnClickListener {
                githubAuthenticator.authenticate()
            }
            var intent=Intent(this,MainActivity::class.java)
            finish()
            startActivity(intent)
        }

        else{
            var intent=Intent(this,MainActivity::class.java)
            finish()
            startActivity(intent)
        }
    }

}