package com.kekulta.timetable.domain.formatters

import com.kekulta.timetable.domain.models.DayOfTheWeekDm

class DayOfTheWeekFormatter {
    fun format(dm: DayOfTheWeekDm): String {
        return when (dm.num % 6) {
            DayOfTheWeekDm.MONDAY.num -> "Пн."
            DayOfTheWeekDm.TUESDAY.num -> "Вт."
            DayOfTheWeekDm.WEDNESDAY.num -> "Ср."
            DayOfTheWeekDm.THURSDAY.num -> "Чт."
            DayOfTheWeekDm.FRIDAY.num -> "Пт."
            DayOfTheWeekDm.SATURDAY.num -> "Сб."
            else -> throw IllegalArgumentException()
        }
    }
}