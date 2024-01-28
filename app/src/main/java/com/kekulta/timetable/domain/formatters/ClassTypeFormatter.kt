package com.kekulta.timetable.domain.formatters

import com.kekulta.timetable.domain.models.ClassType

class ClassTypeFormatter {
    fun format(dm: ClassType): String {
        return when (dm) {
            is ClassType.Lecture -> "Лек."
            is ClassType.Practical -> "Пр."
            is ClassType.Laboratory -> "Лаб."
            is ClassType.Unknown -> dm.type
        }
    }
}