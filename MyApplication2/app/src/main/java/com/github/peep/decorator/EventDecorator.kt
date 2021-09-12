package com.github.peep.decorator

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.drawable.Drawable
import com.github.peep.R
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.DayViewDecorator
import com.prolificinteractive.materialcalendarview.DayViewFacade

class EventDecorator : DayViewDecorator {

    private lateinit var drawable: Drawable
    private var dates: HashSet<CalendarDay>? = null
    private var level: String = ""

    @SuppressLint("UseCompatLoadingForDrawables")
    constructor(dates: ArrayList<CalendarDay>, context: Activity, level: String){

        this.dates = HashSet(dates)
        if(level.equals("level_1")){
            drawable = context.getResources().getDrawable(R.drawable.cal_sq_1)
        }
        else if(level.equals("level_2")){
            drawable = context.getResources().getDrawable(R.drawable.cal_sq_2)
        }
        else if(level.equals("level_3")){
            drawable = context.getResources().getDrawable(R.drawable.cal_sq_3)
        }
    }

    override fun shouldDecorate(day: CalendarDay?): Boolean {
        return dates!!.contains(day)
    }

    override fun decorate(view: DayViewFacade?) {
        view!!.setSelectionDrawable(drawable)
        //view!!.addSpan(ForegroundColorSpan(Color.BLACK))
        //view!!.addSpan(DotSpan(5f, color))
    }
}