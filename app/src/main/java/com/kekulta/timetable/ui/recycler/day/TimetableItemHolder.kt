package com.kekulta.timetable.ui.recycler.day

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.kekulta.timetable.ui.viewobjects.TimetableItemVo
import com.kekulta.timetable.ui.views.BrokenTimetableItem
import com.kekulta.timetable.ui.views.MultipleTimetableItem
import com.kekulta.timetable.ui.views.SeparateTimetableItem
import com.kekulta.timetable.ui.views.SingularTimetableItem

sealed class TimetableItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    class Singular(
        context: Context,
        val view: SingularTimetableItem = SingularTimetableItem(context)
    ) : TimetableItemHolder(view) {
        fun bind(vo: TimetableItemVo.Singular) {
            view.bind(vo)
        }
    }

    class Separate(
        context: Context,
        val view: SeparateTimetableItem = SeparateTimetableItem(context)
    ) : TimetableItemHolder(view) {
        fun bind(vo: TimetableItemVo.Separate) {
            view.bind(vo)
        }
    }

    class Multiple(
        context: Context,
        val view: MultipleTimetableItem = MultipleTimetableItem(context)
    ) : TimetableItemHolder(view) {
        fun bind(vo: TimetableItemVo.Multiple) {
            view.bind(vo)
        }
    }

    class Broken(
        context: Context,
        val view: BrokenTimetableItem = BrokenTimetableItem(context)
    ) : TimetableItemHolder(view) {
        fun bind(vo: TimetableItemVo.Broken) {
            view.bind(vo)
        }
    }
}