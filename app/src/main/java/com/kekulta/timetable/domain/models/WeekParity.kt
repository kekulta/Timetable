package com.kekulta.timetable.domain.models

sealed class WeekParity {
    data object Odd: WeekParity()
    data object Even: WeekParity()
}