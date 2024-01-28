package com.kekulta.timetable.ui.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.kekulta.timetable.R
import com.kekulta.timetable.databinding.TimetableItemSeparateBinding
import com.kekulta.timetable.ui.extensions.setOrGone
import com.kekulta.timetable.ui.viewobjects.TimetableItemVo

class SeparateTimetableItem : ConstraintLayout {
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
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
    }

    private val binding: TimetableItemSeparateBinding = TimetableItemSeparateBinding.bind(
        LayoutInflater.from(this.context).inflate(R.layout.timetable_item_separate, this, true)
    )

    fun bind(vo: TimetableItemVo.Separate) {
        with(binding) {
            with(vo.firstSubject) {
                timeTv.text = time
                professorNameTvTop.text = professor
                subjectNameTvTop.text = name
                classroomTvTop.setOrGone(classroom)
                scheduleTypeTvTop.setOrGone(scheduleType)
                classTypeTvTop.setOrGone(classType)
                buildingTvTop.setOrGone(building)
            }
            with(vo.secondSubject) {
                classroomTvBottom.text = classroom
                professorNameTvBottom.text = professor
                subjectNameTvBottom.text = name
                classroomTvBottom.setOrGone(classroom)
                scheduleTypeTvBottom.setOrGone(scheduleType)
                classTypeTvBottom.setOrGone(classType)
                buildingTvBottom.setOrGone(building)
            }
        }
    }
}

