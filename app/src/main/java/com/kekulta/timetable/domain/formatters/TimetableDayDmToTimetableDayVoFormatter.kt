package com.kekulta.timetable.domain.formatters

import com.kekulta.timetable.domain.models.DateDm
import com.kekulta.timetable.domain.models.TimetableDayDm
import com.kekulta.timetable.ui.viewobjects.TimetableDayVo
import javax.inject.Inject

class TimetableDayDmToTimetableDayVoFormatter @Inject constructor(
    private val timetableItemDmToTimetableItemVoFormatter: TimetableItemDmToTimetableItemVoFormatter,
    private val dayOfTheWeekFormatter: DayOfTheWeekFormatter,
) {
    fun format(dm: TimetableDayDm, dateDm: DateDm): TimetableDayVo {
        return if (dm.items == null) {
            TimetableDayVo.Broken(dayOfTheWeekFormatter.format(dateDm.dayOfTheWeek))
        } else {
            val items = dm.items.map { item ->
                timetableItemDmToTimetableItemVoFormatter.format(item, dateDm)
            }

            TimetableDayVo.Correct(items, dayOfTheWeekFormatter.format(dateDm.dayOfTheWeek))
        }
    }
}