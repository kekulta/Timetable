package com.kekulta.timetable.ui.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.updateMarginsRelative
import com.kekulta.timetable.R
import com.kekulta.timetable.databinding.TimetableItemMultipleMiddleBinding
import com.kekulta.timetable.ui.extensions.getDimen
import com.kekulta.timetable.ui.extensions.setBubbleStyle
import com.kekulta.timetable.ui.extensions.setOrGone
import com.kekulta.timetable.ui.viewobjects.SubjectVo

class MultipleTimetableItemMiddle : ConstraintLayout {
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
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT).apply {
            updateMarginsRelative(
                start = 0,
                top = getDimen(R.dimen.margin_between_card_components),
                bottom = 0,
                end = 0
            )
        }
    }

    private val binding: TimetableItemMultipleMiddleBinding =
        TimetableItemMultipleMiddleBinding.bind(
            LayoutInflater.from(this.context)
                .inflate(R.layout.timetable_item_multiple_middle, this, true)
        )

    fun bind(vo: SubjectVo, isVariant: Boolean = false) {
        with(vo) {
            with(binding) {
                professorNameTv.text = professor
                subjectNameTv.text = name
                timeTv.text = time
                classroomTv.setOrGone(classroom)
                scheduleTypeTv.setOrGone(scheduleType)
                classTypeTv.setOrGone(classType)
                buildingTv.setOrGone(building)

                if (isVariant) {
                    setBackgroundResource(R.drawable.card_background_middle_variant)
                    classTypeTv.setBubbleStyle(R.style.Bubble_ClassType_Variant)
                    scheduleTypeTv.setBubbleStyle(R.style.Bubble_ScheduleType_Variant)
                    classroomTv.setBubbleStyle(R.style.Bubble_Classroom_Variant)
                    buildingTv.setBubbleStyle(R.style.Bubble_Building_Variant)
                } else {
                    setBackgroundResource(R.drawable.card_background_middle)
                    classTypeTv.setBubbleStyle(R.style.Bubble_ClassType)
                    scheduleTypeTv.setBubbleStyle(R.style.Bubble_ScheduleType)
                    classroomTv.setBubbleStyle(R.style.Bubble_Classroom)
                    buildingTv.setBubbleStyle(R.style.Bubble_Building)
                }
            }
        }
    }
}

