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
            nextPeep("yellow")
        }
        peep_red_btn.setOnClickListener {
            nextPeep("red")
        }
        peep_green_btn.setOnClickListener {
            nextPeep("green")
        }
        peep_blue_btn.setOnClickListener {
            nextPeep("blue")
        }
        peep_peigeon_btn.setOnClickListener {
            nextPeep("peigeon")
        }
    }
    fun nextPeep(value : String){
        var intent = Intent(this, HomeFragment::class.java)
        intent.putExtra("nextPeep",value)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}