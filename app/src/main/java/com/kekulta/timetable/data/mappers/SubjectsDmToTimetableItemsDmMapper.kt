package com.kekulta.timetable.data.mappers

import com.kekulta.timetable.domain.models.SubjectDm
import com.kekulta.timetable.domain.models.TimetableItemDm

class SubjectsDmToTimetableItemsDmMapper {
    fun map(subjects: List<SubjectDm>): List<TimetableItemDm> {
        val grouped = subjects.groupBy { it.time }

        return grouped.map { (time, list) ->
            when(list.size) {
                1 -> TimetableItemDm.Singular(list.first())
                2 -> TimetableItemDm.Double(list.first(), list[1])
                else -> TimetableItemDm.Multiple(list)
            }
        }
    }
}