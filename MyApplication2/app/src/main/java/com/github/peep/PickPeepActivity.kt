package com.github.peep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.peep.databinding.ActivityPickPeepBinding

class PickPeepActivity : AppCompatActivity() {
    private lateinit var mBinding : ActivityPickPeepBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityPickPeepBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

    }
}