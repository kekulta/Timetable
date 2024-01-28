package com.kekulta.timetable.domain.formatters

import com.kekulta.timetable.domain.models.DateDm
import com.kekulta.timetable.domain.models.ScheduleType
import com.kekulta.timetable.domain.models.TimetableItemDm
import com.kekulta.timetable.domain.models.WeekParity
import com.kekulta.timetable.ui.viewobjects.TimetableItemVo
import javax.inject.Inject

class TimetableItemDmToTimetableItemVoFormatter @Inject constructor(
    private val subjectDmToSubjectVoFormatter: SubjectDmToSubjectVoFormatter,
) {
    fun format(dm: TimetableItemDm?, dateDm: DateDm): TimetableItemVo {
        val res: TimetableItemVo = if (dm == null) {
            TimetableItemVo.Broken
        } else {
            when (dm) {
                is TimetableItemDm.Singular -> {
                    dm.subject.let { subject ->
                        TimetableItemVo.Singular(
                            subject = subjectDmToSubjectVoFormatter.format(subject)
                        )
                    }
                }

                is TimetableItemDm.Double -> {
                    val types = setOf(dm.secondSubject.scheduleType, dm.firstSubject.scheduleType)
                    val subjects = listOf(dm.firstSubject, dm.secondSubject)
                    when (types) {
                        alternateTypes -> {
                            when (dateDm.weekParity) {
                                is WeekParity.Odd -> {
                                    TimetableItemVo.Singular(
                                        subject = subjectDmToSubjectVoFormatter.format(subjects.first { it.scheduleType == ScheduleType.Odd }),
                                    )
                                }

                                is WeekParity.Even -> {
                                    TimetableItemVo.Singular(
                                        subject = subjectDmToSubjectVoFormatter.format(subjects.first { it.scheduleType == ScheduleType.Even }),
                                    )
                                }
                            }

                        }

                        separateTypes -> {
                            when (dateDm.weekParity) {
                                is WeekParity.Odd -> {
                                    TimetableItemVo.Separate(
                                        firstSubject = subjectDmToSubjectVoFormatter.format(subjects.first { it.scheduleType == ScheduleType.OodEven }),
                                        secondSubject = subjectDmToSubjectVoFormatter.format(
                                            subjects.first { it.scheduleType == ScheduleType.EvenOdd }),
                                    )
                                }

                                is WeekParity.Even -> {
                                    TimetableItemVo.Separate(
                                        firstSubject = subjectDmToSubjectVoFormatter.format(subjects.first { it.scheduleType == ScheduleType.EvenOdd }),
                                        secondSubject = subjectDmToSubjectVoFormatter.format(
                                            subjects.first { it.scheduleType == ScheduleType.OodEven }),
                                    )
                                }
                            }
                        }

                        else -> {
                            TimetableItemVo.Multiple(
                                subjects = subjects.map { subjectDmToSubjectVoFormatter.format(it) }
                            )
                        }
                    }
                }

                is TimetableItemDm.Multiple -> {
                    TimetableItemVo.Multiple(
                        subjects = dm.subjects.map { subjectDmToSubjectVoFormatter.format(it) }
                    )
                }
            }
        }

        return res
    }

    companion object {
        private val alternateTypes = setOf(ScheduleType.Odd, ScheduleType.Even)
        private val separateTypes = setOf(ScheduleType.OodEven, ScheduleType.EvenOdd)
    }
}