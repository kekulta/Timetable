package com.kekulta.timetable.ui.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.kekulta.timetable.R
import com.kekulta.timetable.databinding.TimetableItemSingularBinding
import com.kekulta.timetable.ui.extensions.dp
import com.kekulta.timetable.ui.extensions.setOrGone
import com.kekulta.timetable.ui.viewobjects.TimetableItemVo

class SingularTimetableItem : ConstraintLayout {
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

    private val binding: TimetableItemSingularBinding = TimetableItemSingularBinding.bind(
        LayoutInflater.from(this.context).inflate(R.layout.timetable_item_singular, this, true)
    )

    init {
        setBackgroundResource(R.drawable.card_background_full)
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
    }

    fun bind(vo: TimetableItemVo.Singular) {
        with(vo.subject) {
            with(binding) {
                professorNameTv.text = professor
                subjectNameTv.text = name
                timeTv.text = time
                classroomTv.setOrGone(classroom)
                scheduleTypeTv.setOrGone(scheduleType)
                classTypeTv.setOrGone(classType)
                buildingTv.setOrGone(building)
            }
        }
    }
}

