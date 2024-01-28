package com.kekulta.timetable.domain.formatters

import com.kekulta.timetable.domain.models.DateDm
import com.kekulta.timetable.domain.models.DayOfTheWeekDm
import com.kekulta.timetable.domain.models.TimetableDm
import com.kekulta.timetable.domain.models.WeekParity
import com.kekulta.timetable.ui.viewobjects.TimetableVo
import javax.inject.Inject

class TimetableDmToTimetableVoFormatter @Inject constructor(
    private val timetableDayDmToTimetableDayVoFormatter: TimetableDayDmToTimetableDayVoFormatter,
) {
    fun format(dm: TimetableDm, weekParity: WeekParity): TimetableVo {
        return TimetableVo(
            listOf(
                timetableDayDmToTimetableDayVoFormatter.format(
                    dm.monday,
                    DateDm(DayOfTheWeekDm.MONDAY, weekParity)
                ),
                timetableDayDmToTimetableDayVoFormatter.format(
                    dm.tuesday,
                    DateDm(DayOfTheWeekDm.TUESDAY, weekParity)
                ),
                timetableDayDmToTimetableDayVoFormatter.format(
                    dm.wednesday,
                    DateDm(DayOfTheWeekDm.WEDNESDAY, weekParity)
                ),
                timetableDayDmToTimetableDayVoFormatter.format(
                    dm.thursday,
                    DateDm(DayOfTheWeekDm.THURSDAY, weekParity)
                ),
                timetableDayDmToTimetableDayVoFormatter.format(
                    dm.friday,
                    DateDm(DayOfTheWeekDm.FRIDAY, weekParity)
                ),
                timetableDayDmToTimetableDayVoFormatter.format(
                    dm.saturday,
                    DateDm(DayOfTheWeekDm.SATURDAY, weekParity)
                ),
            )
        )
    }
}