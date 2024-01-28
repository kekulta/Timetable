package com.kekulta.timetable.domain.models

data class DayOfTheWeekDm(val num: Int) {
    companion object {
        val MONDAY = DayOfTheWeekDm(0)
        val TUESDAY = DayOfTheWeekDm(1)
        val WEDNESDAY = DayOfTheWeekDm(2)
        val THURSDAY = DayOfTheWeekDm(3)
        val FRIDAY = DayOfTheWeekDm(4)
        val SATURDAY = DayOfTheWeekDm(5)
    }
}