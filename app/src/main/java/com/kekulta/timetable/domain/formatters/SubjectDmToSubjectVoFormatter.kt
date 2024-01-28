package com.kekulta.timetable.domain.formatters

import com.kekulta.timetable.domain.models.SubjectDm
import com.kekulta.timetable.ui.viewobjects.SubjectVo
import javax.inject.Inject

class SubjectDmToSubjectVoFormatter @Inject constructor(
    private val timeFormatter: TimeDmFormatter,
    private val subjectTypeFormatter: SubjectTypeFormatter,
    private val classTypeFormatter: ClassTypeFormatter,
) {
    fun format(dm: SubjectDm): SubjectVo {
        val classroom = dm.classroom ?: UNKNOWN
        val building = (dm.building ?: UNKNOWN).let { b ->
            if (b == classroom) {
                UNKNOWN
            } else {
                b
            }
        }

        return SubjectVo(
            name = dm.name ?: UNKNOWN,
            professor = (dm.professor)?.let { formatProfessorName(it) } ?: UNKNOWN,
            classroom = classroom,
            building = building,
            time = dm.time?.let { timeFormatter.format(it) } ?: UNKNOWN,
            scheduleType = subjectTypeFormatter.format(dm.scheduleType),
            classType = classTypeFormatter.format(dm.classType)
        )
    }

    private fun formatProfessorName(name: String): String {
        return name.split("\\s+".toRegex()).joinToString(" ") { word ->
            word.map { char -> char.lowercase() }.joinToString("")
                .replaceFirstChar { char -> char.uppercaseChar() }
        }
    }

    private companion object {
        const val UNKNOWN = ""
    }
}