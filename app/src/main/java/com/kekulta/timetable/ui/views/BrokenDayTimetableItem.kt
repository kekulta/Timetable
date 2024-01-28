package com.kekulta.timetable.ui.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.kekulta.timetable.R
import com.kekulta.timetable.databinding.TimetableItemDayBrokenBinding
import com.kekulta.timetable.ui.viewobjects.TimetableDayVo

class BrokenDayTimetableItem : FrameLayout {
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

    init {
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
    }

    private val binding: TimetableItemDayBrokenBinding = TimetableItemDayBrokenBinding.bind(
        LayoutInflater.from(this.context).inflate(R.layout.timetable_item_day_broken, this, true)
    )

    fun bind(vo: TimetableDayVo.Broken) {}
}

