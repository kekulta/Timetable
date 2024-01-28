package com.kekulta.timetable.di

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.kekulta.timetable.domain.usecases.InverseWeekParityUsecase
import com.kekulta.timetable.domain.usecases.ObserveFormattedTimetableUsecase
import com.kekulta.timetable.domain.usecases.UpdateGroupsRepositoryUsecase
import com.kekulta.timetable.domain.viewmodel.MainViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @Provides
    fun provideViewModelFactory(
        updateGroupsRepositoryUsecase: UpdateGroupsRepositoryUsecase,
        observeFormattedTimetableUsecase: ObserveFormattedTimetableUsecase,
        inverseWeekParityUsecase: InverseWeekParityUsecase,
    ): ViewModelProvider.Factory {
        return viewModelFactory {
            initializer {
                MainViewModel(
                    updateGroupsRepositoryUsecase = updateGroupsRepositoryUsecase,
                    observeFormattedTimetableUsecase = observeFormattedTimetableUsecase,
                    inverseWeekParityUsecase = inverseWeekParityUsecase,
                )
            }
        }
    }
}