package com.kekulta.timetable.ui.recycler.week

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.kekulta.timetable.ui.viewobjects.TimetableDayVo
import com.kekulta.timetable.ui.views.BrokenDayTimetableItem
import com.kekulta.timetable.ui.views.CorrectDayTimetableItem

sealed class TimetableDayHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
    class Correct(
        context: Context, val view: CorrectDayTimetableItem = CorrectDayTimetableItem(context)
    ) : TimetableDayHolder(view) {
        fun bind(vo: TimetableDayVo.Correct) {
            view.bind(vo)
        }
    }

    class Broken(
        context: Context, val view: BrokenDayTimetableItem = BrokenDayTimetableItem(context)
    ) : TimetableDayHolder(view) {
        fun bind(vo: TimetableDayVo.Broken) {
            view.bind(vo)
        }
    }
}