package codevinci.com.kotlinretrofitrestexample.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import codevinci.com.kotlinretrofitrestexample.R
import codevinci.com.kotlinretrofitrestexample.util.NetworkConection

import kotlinx.android.synthetic.main.activity_access_token.*
import kotlinx.android.synthetic.main.content_access_token.*
import org.jetbrains.anko.design.snackbar

class AccessTokenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_access_token)
        setSupportActionBar(toolbar)
        btNext.setOnClickListener { view ->
            val accessToken:String = etAccessToken?.text.toString()
            if (accessToken.isNotEmpty()) {
                if (NetworkConection.isNetworkConnected(applicationContext)) {
                    val intent = Intent(this@AccessTokenActivity, UserDetailsActivity::class.java)

                    intent.putExtra("access_token", accessToken)//pass access token to next activity
                    startActivity(intent)
                } else {
                    snackbar(view, getString(R.string.error_internet))
                }
            }else{
                snackbar(view, getString(R.string.enter_access_token))
            }
        }
    }

}
