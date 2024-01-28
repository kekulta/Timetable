package com.kekulta.timetable.ui.viewobjects

data class SubjectVo(
    val name: String,
    val professor: String,
    val time: String,
    val classroom: String,
    val building: String,
    val scheduleType: String,
    val classType: String,
)