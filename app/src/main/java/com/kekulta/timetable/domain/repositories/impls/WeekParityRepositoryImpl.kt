package com.kekulta.timetable.domain.repositories.impls

import android.util.Log
import com.kekulta.timetable.domain.models.WeekParity
import com.kekulta.timetable.domain.repositories.api.WeekParityRepository
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject

class WeekParityRepositoryImpl : WeekParityRepository {
    private val paritySubject = BehaviorSubject.createDefault<WeekParity>(WeekParity.Odd)

    override fun observeWeekParity(): Observable<WeekParity> {
        return paritySubject
    }

    override fun getWeekParitySync(): WeekParity {
        return requireNotNull(paritySubject.value) { "WeekParity can not be null!" }
    }

    override fun setWeekParity(parity: WeekParity) {
        Log.d("tag", "WEekPArity set to: $parity")
        paritySubject.onNext(parity)
    }
}