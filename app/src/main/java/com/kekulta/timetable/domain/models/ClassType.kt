package com.kekulta.timetable.domain.models

sealed class ClassType {
    data object Lecture : ClassType()
    data object Practical : ClassType()
    data object Laboratory : ClassType()
    data class Unknown(val type: String) : ClassType()
}