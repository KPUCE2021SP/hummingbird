package com.github.peep

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.peep.App.Companion.prefs
import com.github.peep.fragments.HomeFragment
import kotlinx.android.synthetic.main.activity_peep_select.*

class PeepSelectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peep_select)

        var currentPeep : String? = prefs.getString("currentPeep","")

        peep_yellow_btn.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            prefs.setString("currentPeep","yellow")
            startActivity(intent)
            finish()
        }
        peep_red_btn.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            prefs.setString("currentPeep","red")
            startActivity(intent)
            finish()
        }
        peep_green_btn.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            prefs.setString("currentPeep","green")
            startActivity(intent)
            finish()
        }
        peep_blue_btn.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            prefs.setString("currentPeep","blue")
            startActivity(intent)
            finish()
        }
        peep_pigeon_btn.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            prefs.setString("currentPeep","pigeon")
            startActivity(intent)
            finish()
        }

        peep_white_btn.setOnClickListener {
            var intent=Intent(this,MainActivity::class.java)
            prefs.setString("currentPeep","white")
            startActivity(intent)
            finish()
        }
    }
}