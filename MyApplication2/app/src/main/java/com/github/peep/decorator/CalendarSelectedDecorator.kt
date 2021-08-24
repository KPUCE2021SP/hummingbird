package com.catlove.gitcat

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Build
import android.text.style.ForegroundColorSpan
import android.util.Log
import androidx.annotation.RequiresApi
import com.github.peep.R
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.DayViewDecorator
import com.prolificinteractive.materialcalendarview.DayViewFacade

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class CalendarSelectedDecorator @SuppressLint("UseCompatLoadingForDrawables") constructor(
    dates: CalendarDay,
    context: Activity
) : DayViewDecorator {
    private var drawable: Drawable
    private var dates: CalendarDay? = dates

    init {
        drawable = context.getDrawable(R.drawable.calendar_select)!!
    }

    override fun shouldDecorate(day: CalendarDay?): Boolean {
        return dates != null && day!!.equals(dates)
    }

    override fun decorate(view: DayViewFacade?) {
        //view!!.setSelectionDrawable(drawable)
        Log.d("decorate", "decorate:  ")
        view!!.setBackgroundDrawable(drawable)
        view.addSpan(ForegroundColorSpan(Color.BLACK))
        //view!!.addSpan(DotSpan(5f, color))
    }




}