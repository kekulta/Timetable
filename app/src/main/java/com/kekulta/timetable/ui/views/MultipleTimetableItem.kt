package com.kekulta.timetable.ui.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.kekulta.timetable.R
import com.kekulta.timetable.databinding.TimetableItemMultipleBinding
import com.kekulta.timetable.ui.extensions.setBubbleStyle
import com.kekulta.timetable.ui.extensions.setOrGone
import com.kekulta.timetable.ui.viewobjects.TimetableItemVo

class MultipleTimetableItem : ConstraintLayout {
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

    private val binding: TimetableItemMultipleBinding = TimetableItemMultipleBinding.bind(
        LayoutInflater.from(this.context).inflate(R.layout.timetable_item_multiple, this, true)
    )

    fun bind(vo: TimetableItemVo.Multiple) {
        with(binding) {
            with(vo.subjects.first()) {
                timeTv.text = time
                professorNameTvTop.text = professor
                subjectNameTvTop.text = name
                classroomTvTop.setOrGone(classroom)
                scheduleTypeTvTop.setOrGone(scheduleType)
                classTypeTvTop.setOrGone(classType)
                buildingTvTop.setOrGone(building)
            }

            vo.subjects.drop(1).dropLast(1).forEachIndexed() { index, middle ->
                val isVariant = index % 2 == 0
                middleContainer.addView(
                    MultipleTimetableItemMiddle(context).apply { bind(middle, isVariant) }
                )
            }

            with(vo.subjects.last()) {
                classroomTvBottom.text = classroom
                professorNameTvBottom.text = professor
                subjectNameTvBottom.text = name

                classroomTvBottom.setOrGone(classroom)
                scheduleTypeTvBottom.setOrGone(scheduleType)
                classTypeTvBottom.setOrGone(classType)
                buildingTvBottom.setOrGone(building)

                if (vo.subjects.size % 2 == 0) {
                    bottomBackground.setBackgroundResource(R.drawable.card_background_bottom_variant)

                    classroomTvBottom.setBubbleStyle(R.style.Bubble_Classroom_Variant)
                    scheduleTypeTvBottom.setBubbleStyle(R.style.Bubble_ScheduleType_Variant)
                    classTypeTvBottom.setBubbleStyle(R.style.Bubble_ClassType_Variant)
                    buildingTvBottom.setBubbleStyle(R.style.Bubble_Building_Variant)
                } else {
                    bottomBackground.setBackgroundResource(R.drawable.card_background_bottom)

                    classroomTvBottom.setBubbleStyle(R.style.Bubble_Classroom)
                    scheduleTypeTvBottom.setBubbleStyle(R.style.Bubble_ScheduleType)
                    classTypeTvBottom.setBubbleStyle(R.style.Bubble_ClassType)
                    buildingTvBottom.setBubbleStyle(R.style.Bubble_Building)
                }
            }
        }
    }
}

