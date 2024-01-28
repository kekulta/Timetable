package com.kekulta.timetable.domain.formatters

import com.kekulta.timetable.domain.models.ScheduleType

class SubjectTypeFormatter {
    fun format(type: ScheduleType): String {
        return when (type) {
            is ScheduleType.Everyday -> ""
            is ScheduleType.Odd -> "н"
            is ScheduleType.Even -> "ч"
            is ScheduleType.EvenOdd -> "ч/н"
            is ScheduleType.OodEven -> "н/ч"
            is ScheduleType.Unknown -> type.type
        }
    }
}