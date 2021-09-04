package com.github.peep

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.peep.fragments.HomeFragment
import kotlinx.android.synthetic.main.activity_peep_select.*

class PeepSelectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peep_select)

        var currentPeep : String? = intent.getStringExtra("currentPeep")

        peep_yellow_btn.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            intent.putExtra("nextPeep","yellow")
            startActivity(intent)
            finish()
        }
        peep_red_btn.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            intent.putExtra("nextPeep","red")
            startActivity(intent)
            finish()
        }
        peep_green_btn.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            intent.putExtra("nextPeep","green")
            startActivity(intent)
            finish()
        }
        peep_blue_btn.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            intent.putExtra("nextPeep","blue")
            startActivity(intent)
            finish()
        }
        peep_pigeon_btn.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            intent.putExtra("nextPeep","pigeon")
            startActivity(intent)
            finish()
        }
    }
//    fun nextPeep(value : String){
//        var intent = Intent(this, HomeFragment::class.java)
//        intent.putExtra("nextPeep",value)
//        setResult(Activity.RESULT_OK, intent)
//        finish()
//    }
}