package com.github.peep.decorator

import android.app.AlertDialog
import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.peep.R
import kotlinx.android.synthetic.main.alert_popup.view.*
import java.util.logging.Handler

class AlertDesignOneBtn(private val context: Context){
    private val builder: AlertDialog.Builder by lazy {
        AlertDialog
            .Builder(context)
            .setCancelable(false)
            .setView(view)
    }

    private val view: View by lazy {
        View.inflate(context, R.layout.alert_popup_one_button, null)
    }

    private var dialog: AlertDialog? = null

    fun setTitle(title: CharSequence): AlertDesignOneBtn {
        view.text_title.text = title
        return this
    }

    fun setMessage(message: CharSequence): AlertDesignOneBtn {
        view.alert_textview.text = message
        return this
    }


    fun setPositiveButton(text: CharSequence, listener: (view: View) -> (Unit)): AlertDesignOneBtn {
        view.btn_positive.apply {
            this.text = text
            setOnClickListener(listener)
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