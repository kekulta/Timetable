package com.kekulta.timetable.di

import com.kekulta.timetable.data.bd.PersistentService
import com.kekulta.timetable.data.network.KaiService
import com.kekulta.timetable.data.network.impls.GroupsRepositoryImpl
import com.kekulta.timetable.data.network.impls.TimetableRepositoryImpl
import com.kekulta.timetable.data.mappers.GroupDtoToGroupDmMapper
import com.kekulta.timetable.data.mappers.GroupDtoToGroupEntityMapper
import com.kekulta.timetable.data.mappers.GroupEntityToGroupDmMapper
import com.kekulta.timetable.data.mappers.TimetableDtoToTimetableDmMapper
import com.kekulta.timetable.domain.repositories.api.GroupsRepository
import com.kekulta.timetable.domain.repositories.api.TimetableRepository
import com.kekulta.timetable.domain.repositories.api.WeekParityRepository
import com.kekulta.timetable.domain.repositories.impls.WeekParityRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    fun provideTimetableRepositoryImpl(
        kaiService: KaiService,
        timetableDtoToTimetableDmMapper: TimetableDtoToTimetableDmMapper,
    ): TimetableRepository {
        return TimetableRepositoryImpl(
            kaiService = kaiService,
            timetableDtoToTimetableDmMapper = timetableDtoToTimetableDmMapper,
        )
    }

    @Provides
    fun provideGroupsRepositoryImpl(
        kaiService: KaiService,
        persistentService: PersistentService,
        groupDtoToGroupEntityMapper: GroupDtoToGroupEntityMapper,
        groupEntityToGroupDmMapper: GroupEntityToGroupDmMapper,
    ): GroupsRepository {
        return GroupsRepositoryImpl(
            kaiService = kaiService,
            persistentService = persistentService,
            groupDtoToGroupEntityMapper = groupDtoToGroupEntityMapper,
            groupEntityToGroupDmMapper = groupEntityToGroupDmMapper,
        )
    }


    @Provides
    @Singleton
    fun provideWeekParityRepositoryImpl(): WeekParityRepository {
        return WeekParityRepositoryImpl()
    }
}