package com.kekulta.timetable.ui.viewobjects

sealed class TimetableItemVo {
    data object Broken : TimetableItemVo()
    data class Singular(val subject: SubjectVo) : TimetableItemVo()
    data class Separate(val firstSubject: SubjectVo, val secondSubject: SubjectVo) : TimetableItemVo()
    data class Multiple(val subjects: List<SubjectVo>) : TimetableItemVo()
}

