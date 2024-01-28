package com.kekulta.timetable.ui.recycler.day

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.kekulta.timetable.ui.viewobjects.TimetableItemVo

class DayRecyclerAdapter : ListAdapter<TimetableItemVo, TimetableItemHolder>(DiffCallback()) {
    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is TimetableItemVo.Singular -> 0
            is TimetableItemVo.Separate -> 1
            is TimetableItemVo.Multiple -> 2
            is TimetableItemVo.Broken -> 3
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimetableItemHolder {
        with(parent) {
            return when (viewType) {
                0 -> TimetableItemHolder.Singular(context)
                1 -> TimetableItemHolder.Separate(context)
                2 -> TimetableItemHolder.Multiple(context)
                3 -> TimetableItemHolder.Broken(context)
                else -> TimetableItemHolder.Broken(context)
            }
        }
    }

    override fun onBindViewHolder(holder: TimetableItemHolder, position: Int) {
        when (val vo = getItem(position)) {
            is TimetableItemVo.Broken -> { /* NO-OP */
            }

            is TimetableItemVo.Singular -> {
                if (holder is TimetableItemHolder.Singular) {
                    holder.bind(vo)
                }
            }

            is TimetableItemVo.Separate -> {
                if (holder is TimetableItemHolder.Separate) {
                    holder.bind(vo)
                }
            }

            is TimetableItemVo.Multiple -> {
                if (holder is TimetableItemHolder.Multiple) {
                    holder.bind(vo)
                }
            }
        }
    }

    private class DiffCallback : DiffUtil.ItemCallback<TimetableItemVo>() {

        override fun areItemsTheSame(oldItem: TimetableItemVo, newItem: TimetableItemVo): Boolean {
            if (oldItem is TimetableItemVo.Broken || newItem is TimetableItemVo.Broken) {
                return false
            }

            val oldTime = when (oldItem) {
                is TimetableItemVo.Singular -> {
                    oldItem.subject.time
                }

                is TimetableItemVo.Separate -> {
                    oldItem.firstSubject.time
                }

                is TimetableItemVo.Multiple -> {
                    oldItem.subjects.first().time
                }

                is TimetableItemVo.Broken -> throw IllegalStateException("WTF? I just checked!")
            }

            val newTime = when (newItem) {
                is TimetableItemVo.Singular -> {
                    newItem.subject.time
                }

                is TimetableItemVo.Separate -> {
                    newItem.firstSubject.time
                }

                is TimetableItemVo.Multiple -> {
                    newItem.subjects.first().time
                }

                is TimetableItemVo.Broken -> throw IllegalStateException("WTF? I just checked!")
            }
//            Log.d(
//                "tag", """
//                oldTime: $oldTime, newTime: $newTime
//                oldItem: $oldItem
//                newItem: $newItem
//            """.trimIndent()
//            )
            return oldTime == newTime
        }

        override fun areContentsTheSame(
            oldItem: TimetableItemVo,
            newItem: TimetableItemVo
        ): Boolean {
            return oldItem == newItem
        }
    }
}