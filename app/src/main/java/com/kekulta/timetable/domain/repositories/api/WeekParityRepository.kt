package com.kekulta.timetable.domain.repositories.api

import com.kekulta.timetable.domain.models.WeekParity
import io.reactivex.Observable

interface WeekParityRepository {
    fun observeWeekParity(): Observable<WeekParity>
    fun getWeekParitySync(): WeekParity
    fun setWeekParity(parity: WeekParity)
}