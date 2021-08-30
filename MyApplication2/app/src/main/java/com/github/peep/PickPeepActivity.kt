package com.github.peep

import android.app.Activity
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
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
                1 ->{
                    intent.putExtra("picked", "red")
                    setResult(Activity.RESULT_OK, intent)
                    finish()
                }
                2 ->{
                    intent.putExtra("picked", "yellow")
                    setResult(Activity.RESULT_OK, intent)
                    finish()
                }
                3 ->{
                    intent.putExtra("picked", "blue")
                    setResult(Activity.RESULT_OK, intent)
                    finish()
                }
                4 ->{
                    intent.putExtra("picked", "green")
                    setResult(Activity.RESULT_OK, intent)
                    finish()
                }
                5 ->{
                    intent.putExtra("picked", "pigeon")
                    setResult(Activity.RESULT_OK, intent)
                    finish()
                }
                    6 ->{
                    intent.putExtra("picked", "baepsae")
                    setResult(Activity.RESULT_OK, intent)
                    finish()
                    }
            }
        }
    }
}