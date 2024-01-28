package com.kekulta.timetable.ui.recycler.week

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.kekulta.timetable.ui.viewobjects.TimetableDayVo

class WeekRecyclerAdapter :
    ListAdapter<TimetableDayVo, TimetableDayHolder>(DiffCallback()) {

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is TimetableDayVo.Correct -> 0
            is TimetableDayVo.Broken -> 1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimetableDayHolder {
        with(parent) {
            return when (viewType) {
                0 -> TimetableDayHolder.Correct(context)
                1 -> TimetableDayHolder.Broken(context)
                else -> TimetableDayHolder.Broken(context)
            }
        }
    }

    override fun onBindViewHolder(holder: TimetableDayHolder, position: Int) {
        when (val vo = getItem(position)) {
            is TimetableDayVo.Broken -> {
                /* NO-OP */
            }

            is TimetableDayVo.Correct -> {
                if (holder is TimetableDayHolder.Correct) {
                    holder.bind(vo)
                }
            }
        }
    }

    private class DiffCallback : DiffUtil.ItemCallback<TimetableDayVo>() {

        override fun areItemsTheSame(oldItem: TimetableDayVo, newItem: TimetableDayVo): Boolean {
            val oldDate = when (oldItem) {
                is TimetableDayVo.Correct -> oldItem.date
                is TimetableDayVo.Broken -> oldItem.date
            }

            val newDate = when (newItem) {
                is TimetableDayVo.Correct -> newItem.date
                is TimetableDayVo.Broken -> newItem.date
            }

            return oldDate == newDate
        }

        override fun areContentsTheSame(oldItem: TimetableDayVo, newItem: TimetableDayVo): Boolean {
            return oldItem == newItem
        }
    }
}