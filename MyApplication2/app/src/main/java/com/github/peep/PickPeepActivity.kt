package com.github.peep

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.peep.App.Companion.prefs
import com.github.peep.databinding.ActivityPickPeepBinding
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.toast


class PickPeepActivity : AppCompatActivity() {
    private lateinit var mBinding : ActivityPickPeepBinding
    private lateinit var anim_out : AnimationDrawable
    private lateinit var anim_in : AnimationDrawable

//    picked값 0: 선택 안함
//    1:red peep    2:yellow    3: blue
//    4: green      5:pigeon    6: w(뱁새)

    private var picked = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityPickPeepBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        mBinding.redPeepLayout.setOnClickListener {
            picked =1
            val anim_out = AnimationUtils.loadAnimation(applicationContext, com.github.peep.R.anim.alpha_anim_fade_out)
            val anim_in = AnimationUtils.loadAnimation(applicationContext, com.github.peep.R.anim.alpha_anim_fade_in)
            mBinding.redPeepLayout.startAnimation(anim_in)
            mBinding.yellowPeepLayout.startAnimation(anim_out)
            mBinding.bluePeepLayout.startAnimation(anim_out)
            mBinding.greenPeepLayout.startAnimation(anim_out)
            mBinding.wPeepLayout.startAnimation(anim_out)
            mBinding.pigeonLayout.startAnimation(anim_out)
        }

        mBinding.yellowPeepLayout.setOnClickListener {
            picked =2
            val anim_out = AnimationUtils.loadAnimation(applicationContext, com.github.peep.R.anim.alpha_anim_fade_out)
            val anim_in = AnimationUtils.loadAnimation(applicationContext, com.github.peep.R.anim.alpha_anim_fade_in)
            mBinding.redPeepLayout.startAnimation(anim_out)
            mBinding.yellowPeepLayout.startAnimation(anim_in)
            mBinding.bluePeepLayout.startAnimation(anim_out)
            mBinding.greenPeepLayout.startAnimation(anim_out)
            mBinding.wPeepLayout.startAnimation(anim_out)
            mBinding.pigeonLayout.startAnimation(anim_out)
        }

        mBinding.bluePeepLayout.setOnClickListener {
            picked =3
            val anim_out = AnimationUtils.loadAnimation(applicationContext, com.github.peep.R.anim.alpha_anim_fade_out)
            val anim_in = AnimationUtils.loadAnimation(applicationContext, com.github.peep.R.anim.alpha_anim_fade_in)
            mBinding.redPeepLayout.startAnimation(anim_out)
            mBinding.yellowPeepLayout.startAnimation(anim_out)
            mBinding.bluePeepLayout.startAnimation(anim_in)
            mBinding.greenPeepLayout.startAnimation(anim_out)
            mBinding.wPeepLayout.startAnimation(anim_out)
            mBinding.pigeonLayout.startAnimation(anim_out)
        }

        mBinding.greenPeepLayout.setOnClickListener {
            picked =4
            val anim_out = AnimationUtils.loadAnimation(applicationContext, com.github.peep.R.anim.alpha_anim_fade_out)
            val anim_in = AnimationUtils.loadAnimation(applicationContext, com.github.peep.R.anim.alpha_anim_fade_in)
            mBinding.redPeepLayout.startAnimation(anim_out)
            mBinding.yellowPeepLayout.startAnimation(anim_out)
            mBinding.bluePeepLayout.startAnimation(anim_out)
            mBinding.greenPeepLayout.startAnimation(anim_in)
            mBinding.wPeepLayout.startAnimation(anim_out)
            mBinding.pigeonLayout.startAnimation(anim_out)
        }

        mBinding.pigeonLayout.setOnClickListener {
            picked =5
            val anim_out = AnimationUtils.loadAnimation(applicationContext, com.github.peep.R.anim.alpha_anim_fade_out)
            val anim_in = AnimationUtils.loadAnimation(applicationContext, com.github.peep.R.anim.alpha_anim_fade_in)
            mBinding.redPeepLayout.startAnimation(anim_out)
            mBinding.yellowPeepLayout.startAnimation(anim_out)
            mBinding.bluePeepLayout.startAnimation(anim_out)
            mBinding.greenPeepLayout.startAnimation(anim_out)
            mBinding.wPeepLayout.startAnimation(anim_out)
            mBinding.pigeonLayout.startAnimation(anim_in)
        }

        mBinding.wPeepLayout.setOnClickListener {
            picked =6
            val anim_out = AnimationUtils.loadAnimation(applicationContext, com.github.peep.R.anim.alpha_anim_fade_out)
            val anim_in = AnimationUtils.loadAnimation(applicationContext, com.github.peep.R.anim.alpha_anim_fade_in)
            mBinding.redPeepLayout.startAnimation(anim_out)
            mBinding.yellowPeepLayout.startAnimation(anim_out)
            mBinding.bluePeepLayout.startAnimation(anim_out)
            mBinding.greenPeepLayout.startAnimation(anim_out)
            mBinding.wPeepLayout.startAnimation(anim_in)
            mBinding.pigeonLayout.startAnimation(anim_out)
        }

        mBinding.nextBtn.setOnClickListener {
            when(picked){
                //red
                1 ->{
                    var intent = Intent(this, MainActivity::class.java)
                    prefs.setString("currentPeep","red")
                    startActivity(intent)
                    finish()
                }
                //yellow
                2 ->{
                    var intent = Intent(this, MainActivity::class.java)
                    prefs.setString("currentPeep","yellow")
                    startActivity(intent)
                    finish()
                }
                //blue
                3 ->{
                    var intent = Intent(this, MainActivity::class.java)
                    prefs.setString("currentPeep","blue")
                    startActivity(intent)
                    finish()
                }
                //green
                4 ->{
                    var intent = Intent(this, MainActivity::class.java)
                    prefs.setString("currentPeep","green")
                    startActivity(intent)
                    finish()
                }
                //pigeon
                5 ->{
                    var intent = Intent(this, MainActivity::class.java)
                    prefs.setString("currentPeep","pigeon")
                    startActivity(intent)
                    finish()
                }
                //뱁새
                6 ->{
                    var intent = Intent(this, MainActivity::class.java)
                    prefs.setString("currentPeep","white")
                    startActivity(intent)
                    finish()
                }
            }
        }
    }
}