package com.kekulta.timetable.domain.models

data class TimetableDm(
    val monday: TimetableDayDm,
    val tuesday: TimetableDayDm,
    val wednesday: TimetableDayDm,
    val thursday: TimetableDayDm,
    val friday: TimetableDayDm,
    val saturday: TimetableDayDm,
)