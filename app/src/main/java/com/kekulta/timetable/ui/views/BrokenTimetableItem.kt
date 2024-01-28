package com.kekulta.timetable.ui.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.kekulta.timetable.R
import com.kekulta.timetable.databinding.TimetableItemBrokenBinding
import com.kekulta.timetable.ui.viewobjects.TimetableItemVo

class BrokenTimetableItem : ConstraintLayout {
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
        setBackgroundResource(R.drawable.card_background_full)
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
    }

    private val binding: TimetableItemBrokenBinding = TimetableItemBrokenBinding.bind(
        LayoutInflater.from(this.context).inflate(R.layout.timetable_item_broken, this, true)
    )

    fun bind(vo: TimetableItemVo.Broken) {}
}

