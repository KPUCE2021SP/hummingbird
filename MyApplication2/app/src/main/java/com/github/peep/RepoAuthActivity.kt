package com.github.peep

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_repo_auth.*
import org.jetbrains.anko.toast

class RepoAuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo_auth)

        startButton.setOnClickListener {
            if(radioGroup.checkedRadioButtonId==null){
                toast("버튼을 선택해주세요")
            }
            else{
                val intent = Intent()
                if(publicRadio.isChecked){
                    intent.putExtra("auth", "public")
                }
                else if(privateRadio.isChecked){
                    intent.putExtra("auth","private")
                }

                setResult(Activity.RESULT_OK, intent)
                finish()
            }

        }
    }
}