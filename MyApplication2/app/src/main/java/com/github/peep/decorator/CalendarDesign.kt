package com.github.peep.decorator

import android.app.Activity
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.text.style.ForegroundColorSpan
import com.github.peep.R
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.DayViewDecorator
import com.prolificinteractive.materialcalendarview.DayViewFacade


class CalendarDesign: DayViewDecorator {
    // material-calendarview sample
    // https://github.com/prolificinteractive/material-calendarview

    private lateinit var drawable: Drawable

    private var date: CalendarDay? = null

    constructor(context : Activity) {
        date = CalendarDay.today()
        drawable = context.getDrawable(R.drawable.cal_today)!!
    }

    override fun shouldDecorate(day: CalendarDay?): Boolean {
        return date != null && day!!.equals(day)

    }

    override fun decorate(view: DayViewFacade?) {
        view!!.setSelectionDrawable(drawable)
        //view!!.setBackgroundDrawable(drawable)
        view.addSpan(ForegroundColorSpan(Color.parseColor("#38AAF0")))
    }

}