package codevinci.com.kotlinretrofitrestexample.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import codevinci.com.kotlinretrofitrestexample.R
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.OAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_access_token.*
import kotlinx.android.synthetic.main.content_access_token.*
import java.util.*


class AccessTokenActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val provider = OAuthProvider.newBuilder("github.com")
        val scopes: ArrayList<String?> = object : ArrayList<String?>() {
            init {
                add("repo")
            }
        }
        provider.setScopes(scopes)

        val pendingResultTask: Task<AuthResult> = Firebase.auth.pendingAuthResult!!
        if (pendingResultTask != null) {
            // There's something already here! Finish the sign-in for your user.
            pendingResultTask
                .addOnSuccessListener {
                    // User is signed in.
                    // IdP data available in
                    // authResult.getAdditionalUserInfo().getProfile().
                    // The OAuth access token can also be retrieved:
                    // authResult.getCredential().getAccessToken().
                }
                .addOnFailureListener {
                    // Handle failure.
                }
        } else {
            // There's no pending result so you need to start the sign-in flow.
            // See below.
            Firebase.auth.startActivityForSignInWithProvider()
        }

        setContentView(R.layout.activity_access_token)
        setSupportActionBar(toolbar)
        btnStart.setOnClickListener { view ->




//            val accessToken:String = etId?.text.toString()
//            if (accessToken.isNotEmpty()) {
//                if (NetworkConection.isNetworkConnected(applicationContext)) {
//                    val intent = Intent(this@AccessTokenActivity, UserDetailsActivity::class.java)
//
//                    intent.putExtra("access_token", accessToken)//pass access token to next activity
//                    startActivity(intent)
//                } else {
//                    snackbar(view, getString(R.string.error_internet))
//                }
//            }else{
//                snackbar(view, getString(R.string.enter_access_token))
//            }
        }
    }

}
