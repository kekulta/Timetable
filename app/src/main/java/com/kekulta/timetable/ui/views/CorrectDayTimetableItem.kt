package com.kekulta.timetable.ui.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.kekulta.timetable.R
import com.kekulta.timetable.databinding.TimetableItemDayCorrectBinding
import com.kekulta.timetable.ui.recycler.day.DayRecyclerDelegate
import com.kekulta.timetable.ui.viewobjects.TimetableDayVo

class CorrectDayTimetableItem : FrameLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes)

    private val binding: TimetableItemDayCorrectBinding = TimetableItemDayCorrectBinding.bind(
        LayoutInflater.from(this.context).inflate(R.layout.timetable_item_day_correct, this, true)
    )

    private val recyclerDelegate by lazy { DayRecyclerDelegate(binding.recyclerContainer) }

    init {
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
    }

    fun bind(vo: TimetableDayVo.Correct) {
        with(vo) {
            recyclerDelegate.submitList(items)
        }
    }
}