package com.kekulta.timetable.data.mappers


import com.kekulta.timetable.data.network.dtos.TimeDm
import com.kekulta.timetable.data.network.dtos.TimetableItemDto
import com.kekulta.timetable.domain.models.ClassType
import com.kekulta.timetable.domain.models.ScheduleType
import com.kekulta.timetable.domain.models.SubjectDm


class TimetableItemDtoSubjectDmMapper {
    fun map(dtos: List<TimetableItemDto>): List<SubjectDm> {
        return dtos.map { dto ->
            val time = dto.time?.let { time ->
                val (hours, minutes) = time.trim().split(":").map { it.toIntOrNull() }
                if (hours == null || minutes == null) {
                    null
                } else {
                    TimeDm(hours, minutes)
                }
            }
            val scheduleType = dto.scheduleType.let { type ->
                when (type?.trim()) {
                    "" -> ScheduleType.Everyday
                    "чет" -> ScheduleType.Even
                    "неч" -> ScheduleType.Odd
                    "чет/неч" -> ScheduleType.EvenOdd
                    "неч/чет" -> ScheduleType.OodEven
                    else -> ScheduleType.Unknown(type?.trim() ?: "")
                }
            }

            val classType = dto.classType.let { type ->
                when (type?.trim()) {
                    "лек" -> ClassType.Lecture
                    "пр" -> ClassType.Practical
                    "л.р." -> ClassType.Laboratory
                    else -> ClassType.Unknown(type = type?.trim() ?: "")
                }
            }

            SubjectDm(
                name = dto.subject?.trim(),
                professor = dto.professor?.trim(),
                classroom = dto.classroom?.trim(),
                building = dto.building?.trim(),
                scheduleType = scheduleType,
                classType = classType,
                time = time,
            )
        }
    }

    companion object {
        private const val UNKNOWN = "Unknown"
    }
}