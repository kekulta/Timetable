package com.kekulta.timetable.data.mappers

import com.kekulta.timetable.data.network.dtos.TimetableDto
import com.kekulta.timetable.data.network.dtos.TimetableItemDto
import com.kekulta.timetable.domain.models.TimetableDayDm
import com.kekulta.timetable.domain.models.TimetableDm
import javax.inject.Inject

class TimetableDtoToTimetableDmMapper @Inject constructor(
    private val subjectsDmToTimetableItemsDmMapper: SubjectsDmToTimetableItemsDmMapper,
    private val timetableItemDtoSubjectDmMapper: TimetableItemDtoSubjectDmMapper,
) {
    fun map(dto: TimetableDto): TimetableDm {
        return TimetableDm(
            monday = dto.monday.map(),
            tuesday = dto.tuesday.map(),
            wednesday = dto.wednesday.map(),
            thursday = dto.thursday.map(),
            friday = dto.friday.map(),
            saturday = dto.saturday.map(),
        )
    }

    private fun List<TimetableItemDto?>?.map(): TimetableDayDm {
        val dtosList =
            this?.mapNotNull { dto -> dto } ?: return TimetableDayDm(null)

        val subjectsList = timetableItemDtoSubjectDmMapper.map(dtosList)
        val items = subjectsDmToTimetableItemsDmMapper.map(subjectsList)
        return TimetableDayDm(items)
    }
}