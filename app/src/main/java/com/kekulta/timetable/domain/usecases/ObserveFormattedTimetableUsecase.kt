package com.kekulta.timetable.domain.usecases

import android.util.Log
import com.kekulta.timetable.domain.formatters.TimetableDmToTimetableVoFormatter
import com.kekulta.timetable.domain.repositories.api.WeekParityRepository
import com.kekulta.timetable.ui.viewobjects.TimetableVo
import io.reactivex.Observable
import io.reactivex.rxkotlin.Observables.combineLatest

class ObserveFormattedTimetableUsecase(
    private val weekParityRepository: WeekParityRepository,
    private val observeTimetableUsecase: ObserveTimetableUsecase,
    private val timetableDmToTimetableVoFormatter: TimetableDmToTimetableVoFormatter,
) {
    fun execute(group: Int): Observable<TimetableVo> {
        return combineLatest(
            observeTimetableUsecase.execute(group),
            weekParityRepository.observeWeekParity(),
        ).map { (dm, parity) ->
            timetableDmToTimetableVoFormatter.format(dm, parity)
        }
    }
}