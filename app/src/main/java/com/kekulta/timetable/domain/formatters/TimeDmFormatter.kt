package com.kekulta.timetable.domain.formatters

import com.kekulta.timetable.data.network.dtos.TimeDm

class TimeDmFormatter {
    fun format(dm: TimeDm): String {
        val hours = if (dm.hours < 10) {
            "0${dm.hours}"
        } else {
            dm.hours.toString()
        }
        val minutes = if (dm.minutes < 10) {
            "0${dm.minutes}"
        } else {
            dm.minutes.toString()
        }

        return "$hours:$minutes"
    }
}