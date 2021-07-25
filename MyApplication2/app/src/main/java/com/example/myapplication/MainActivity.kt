package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*


class MainActivity : AppCompatActivity() {
    private var textView: TextView? = null
    private var editText: EditText? = null
    private var button: Button? = null
    var mRootRef = FirebaseDatabase.getInstance().reference
    var conditionRef = mRootRef.child("text")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById<View>(R.id.textview) as TextView
        editText = findViewById<View>(R.id.edittext) as EditText
        button = findViewById<View>(R.id.button) as Button
    }

    override fun onStart() {
        super.onStart()
        conditionRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val text = dataSnapshot.getValue(String::class.java)
                textView!!.text = text
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })
        button!!.setOnClickListener { conditionRef.setValue(editText!!.text.toString()) }
    }
}