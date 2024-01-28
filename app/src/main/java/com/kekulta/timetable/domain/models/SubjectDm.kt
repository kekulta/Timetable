package com.kekulta.timetable.domain.models

import com.kekulta.timetable.data.network.dtos.TimeDm

data class SubjectDm(
    val name: String?,
    val professor: String?,
    val classroom: String?,
    val building: String?,
    val scheduleType: ScheduleType,
    val classType: ClassType,
    val time: TimeDm?,
)

