package com.kekulta.timetable.ui.viewobjects

sealed class TimetableDayVo {
    data class Correct(val items: List<TimetableItemVo>, val date: String) : TimetableDayVo()
    data class Broken(val date: String) : TimetableDayVo()
}