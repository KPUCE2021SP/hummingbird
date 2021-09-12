package com.github.peep.decorator

import android.app.AlertDialog
import android.content.Context
import android.os.Handler
import android.view.MotionEvent
import android.view.View
import androidx.annotation.StringRes
import com.github.peep.R
import kotlinx.android.synthetic.main.alert_popup.view.*

class AlertDesign(private val context: Context)  {

    private val builder: AlertDialog.Builder by lazy {
        AlertDialog.Builder(context).setView(view)
    }

    private val view: View by lazy {
        View.inflate(context, R.layout.alert_popup, null)
    }

    private var dialog: AlertDialog? = null

    fun setTitle(title: CharSequence): AlertDesign {
        view.text_title.text = title
        return this
    }

    fun setMessage(message: CharSequence): AlertDesign {
        view.alert_textview.text = message
        return this
    }


    fun setPositiveButton(text: CharSequence, listener: (view: View) -> (Unit)): AlertDesign {
        view.btn_positive.apply {
            this.text = text
            setOnClickListener(listener)
        }
        return this
    }
    fun setNegativeButton(text: CharSequence, listener: (view: View) -> (Unit)): AlertDesign  {
        view.btn_negative.apply {
            this.text = text
            setOnClickListener(listener)
        }
        view.btn_negative.setOnClickListener{
            this.dismiss()
        }
        return this
    }

    fun create() {
        dialog = builder.create()
    }


    fun show() {
        dialog = builder.create()
        dialog?.show()
    }

    fun dismiss() {
        dialog?.dismiss()
    }
}