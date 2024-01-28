package com.kekulta.timetable.domain.models

sealed class ScheduleType {
    data class Unknown(val type: String) : ScheduleType()
    data object Everyday : ScheduleType()
    data object Odd : ScheduleType()
    data object Even : ScheduleType()
    data object OodEven : ScheduleType()
    data object EvenOdd : ScheduleType()
}