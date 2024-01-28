package com.kekulta.timetable.domain.viewmodel

import com.kekulta.timetable.domain.extensions.observeIo
import com.kekulta.timetable.domain.usecases.InverseWeekParityUsecase
import com.kekulta.timetable.domain.usecases.ObserveFormattedTimetableUsecase
import com.kekulta.timetable.domain.usecases.UpdateGroupsRepositoryUsecase
import com.kekulta.timetable.ui.viewobjects.TimetableVo
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

const val GROUPS_UPDATING = "GroupsUpdatingDisposableKey"

class MainViewModel @Inject constructor(
    private val updateGroupsRepositoryUsecase: UpdateGroupsRepositoryUsecase,
    private val observeFormattedTimetableUsecase: ObserveFormattedTimetableUsecase,
    private val inverseWeekParityUsecase: InverseWeekParityUsecase,
) : DisposableViewModel() {
    private val state = BehaviorSubject.create<TimetableVo>()
    val distinctState: Observable<TimetableVo> get() = state.distinctUntilChanged()

    init {
        setIfDisposed(GROUPS_UPDATING) {
            updateGroupsRepositoryUsecase
                .execute()
                .observeIo()
                .subscribe()
        }

        setDisposable("timetableSubscription") {
            observeFormattedTimetableUsecase
                .execute(4206)
                .observeIo()
                .subscribe { vo ->
                    state.onNext(vo)
                }
        }
    }

    fun onParityClick() {
        inverseWeekParityUsecase.execute()
    }
}