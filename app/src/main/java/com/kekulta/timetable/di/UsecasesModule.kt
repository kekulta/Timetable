package com.kekulta.timetable.di

import com.kekulta.timetable.domain.formatters.TimetableDmToTimetableVoFormatter
import com.kekulta.timetable.domain.repositories.api.GroupsRepository
import com.kekulta.timetable.domain.repositories.api.TimetableRepository
import com.kekulta.timetable.domain.repositories.api.WeekParityRepository
import com.kekulta.timetable.domain.usecases.InverseWeekParityUsecase
import com.kekulta.timetable.domain.usecases.ObserveFormattedTimetableUsecase
import com.kekulta.timetable.domain.usecases.ObserveTimetableUsecase
import com.kekulta.timetable.domain.usecases.UpdateGroupsRepositoryUsecase
import dagger.Module
import dagger.Provides

@Module
class UsecasesModule {
    @Provides
    fun provideObserveTimetableUsecase(
        timetableRepository: TimetableRepository,
        groupsRepository: GroupsRepository,
    ): ObserveTimetableUsecase {
        return ObserveTimetableUsecase(
            timetableRepository = timetableRepository,
            groupsRepository = groupsRepository,
        )
    }

    @Provides
    fun provideInverseWeekParityUsecase(weekParityRepository: WeekParityRepository): InverseWeekParityUsecase {
        return InverseWeekParityUsecase(
            weekParityRepository = weekParityRepository,
        )
    }

    @Provides
    fun provideObserveFormattedTimetableUsecase(
        weekParityRepository: WeekParityRepository,
        observeTimetableUsecase: ObserveTimetableUsecase,
        timetableDmToTimetableVoFormatter: TimetableDmToTimetableVoFormatter,
    ): ObserveFormattedTimetableUsecase {
        return ObserveFormattedTimetableUsecase(
            weekParityRepository = weekParityRepository,
            observeTimetableUsecase = observeTimetableUsecase,
            timetableDmToTimetableVoFormatter = timetableDmToTimetableVoFormatter,
        )
    }

    @Provides
    fun provideUpdateGroupsRepositoryUsecase(
        groupsRepository: GroupsRepository
    ): UpdateGroupsRepositoryUsecase {
        return UpdateGroupsRepositoryUsecase(
            groupsRepository = groupsRepository
        )
    }
}