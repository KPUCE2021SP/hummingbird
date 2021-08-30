package com.github.peep

import android.app.Activity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.github.peep.databinding.ActivityPickPeepBinding
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.toast


class PickPeepActivity : AppCompatActivity() {
    private lateinit var mBinding : ActivityPickPeepBinding
    private lateinit var anim_out : Animation
    private lateinit var anim_in : Animation

//    picked값 0: 선택 안함
//    1:red peep    2:yellow    3: blue
//    4: green      5:pigeon    6: w(뱁새)
    private var picked = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityPickPeepBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

//        mBinding?.yellowPeepLayout?.apply {
//            anim_out = background as Animation
//            anim_out.start()
//            anim_in = background as Animation
//            anim_in.start()
//        }
//
//        val anim_out = AnimationUtils.loadAnimation(applicationContext, com.github.peep.R.anim.alpha_anim_fade_out)
//        val anim_in = AnimationUtils.loadAnimation(applicationContext, com.github.peep.R.anim.alpha_anim_fade_in)

        mBinding.redPeepLayout.setOnClickListener {
            picked =1
//            mBinding.yellowPeepLayout.startAnimation(anim_out)
//            mBinding.redPeepLayout.startAnimation(anim_in)
        }

        mBinding.yellowPeepLayout.setOnClickListener {
            picked =2
        }

        mBinding.bluePeepLayout.setOnClickListener {
            picked =3
        }

        mBinding.greenPeepLayout.setOnClickListener {
            picked =4
        }

        mBinding.pigeonLayout.setOnClickListener {
            picked =5
        }

        mBinding.wPeepLayout.setOnClickListener {
            picked =6
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
//                    intent.putExtra("picked", "green")
//                    setResult(Activity.RESULT_OK, intent)
//                    finish()
                    toast("green peep")
                }
                5 ->{
//                    intent.putExtra("picked", "pigeon")
//                    setResult(Activity.RESULT_OK, intent)
//                    finish()
                    toast("pigeon peep")
                }
                    6 ->{
//                    intent.putExtra("picked", "baepsae")
//                    setResult(Activity.RESULT_OK, intent)
//                    finish()
                        toast("baepsae")

                    }
            }
        }
    }
}