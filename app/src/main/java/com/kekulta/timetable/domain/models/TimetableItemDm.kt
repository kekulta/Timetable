package com.kekulta.timetable.domain.models

sealed class TimetableItemDm {
    data class Multiple(val subjects: List<SubjectDm>): TimetableItemDm()
    data class Double(val firstSubject: SubjectDm, val secondSubject: SubjectDm): TimetableItemDm()
    data class Singular(val subject: SubjectDm): TimetableItemDm()
}