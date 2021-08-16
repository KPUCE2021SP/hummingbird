package com.catlove.gitcat

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.text.style.ForegroundColorSpan
import com.github.peep.R
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.DayViewDecorator
import com.prolificinteractive.materialcalendarview.DayViewFacade

@SuppressLint("UseCompatLoadingForDrawables")
class CalendarTodayDecorator(context: Activity) : DayViewDecorator {
    private lateinit var drawable: Drawable
    private var date: CalendarDay? = null

    init {
        date = CalendarDay.today()
        drawable = context.getDrawable(R.drawable.cal_today)!!
    }

    override fun shouldDecorate(day: CalendarDay?): Boolean {
        return date != null && day!!.equals(date)
    }

    override fun decorate(view: DayViewFacade?) {
        view!!.setSelectionDrawable(drawable)
        //view!!.setBackgroundDrawable(drawable)
        view.addSpan(ForegroundColorSpan(Color.parseColor("#38AAF0")))
    }




}