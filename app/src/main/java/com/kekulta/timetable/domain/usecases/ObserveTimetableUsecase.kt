package com.kekulta.timetable.domain.usecases

import androidx.annotation.CheckResult
import com.kekulta.timetable.domain.models.TimetableDm
import com.kekulta.timetable.domain.repositories.api.GroupsRepository
import com.kekulta.timetable.domain.repositories.api.TimetableRepository
import com.kekulta.timetable.domain.repositories.api.WeekParityRepository
import io.reactivex.Observable
import io.reactivex.rxkotlin.Observables.combineLatest
import javax.inject.Inject

class ObserveTimetableUsecase @Inject constructor(
    private val timetableRepository: TimetableRepository,
    private val groupsRepository: GroupsRepository,
) {

    @CheckResult
    fun execute(groupNum: Int): Observable<TimetableDm> {
        return groupsRepository.getGroup(groupNum)
            .flatMap { group -> timetableRepository.observeTimetable(group) }
    }
}