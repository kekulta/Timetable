package com.kekulta.timetable.data.network.dtos

data class TimeDm(val hours: Int, val minutes: Int) {
    override fun toString(): String {
        return "$hours:$minutes"
    }
}