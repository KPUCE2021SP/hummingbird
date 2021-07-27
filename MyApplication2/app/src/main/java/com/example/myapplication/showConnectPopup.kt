package com.example.myapplication

import android.app.AlertDialog
import android.content.Context
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.content.Intent
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

fun showConnectPopup(context: Context){
    val inflater = context.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
    val view = inflater.inflate(R.layout.error_popup,null)
    val textView: TextView = view.findViewById(R.id.error_text)
    textView.text = "네트워크 연결상태를 확인해주세요"

    val alertDialog = AlertDialog.Builder(context)
        .create()

    val errorOk = view.findViewById<Button>(R.id.error_ok)
    errorOk.setOnClickListener {
        alertDialog.dismiss()
        android.os.Process.killProcess(android.os.Process.myPid())
    }

    alertDialog.setView(view)
    alertDialog.show()
}