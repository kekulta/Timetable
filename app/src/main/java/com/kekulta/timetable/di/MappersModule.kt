package com.kekulta.timetable.di

import com.kekulta.timetable.data.mappers.GroupDtoToGroupDmMapper
import com.kekulta.timetable.data.mappers.GroupDtoToGroupEntityMapper
import com.kekulta.timetable.data.mappers.GroupEntityToGroupDmMapper
import com.kekulta.timetable.data.mappers.SubjectsDmToTimetableItemsDmMapper
import com.kekulta.timetable.data.mappers.TimetableDtoToTimetableDmMapper
import com.kekulta.timetable.data.mappers.TimetableItemDtoSubjectDmMapper
import dagger.Module
import dagger.Provides

@Module
class MappersModule {
    @Provides
    fun provideGroupDtoToGroupDmMapper(): GroupDtoToGroupDmMapper {
        return GroupDtoToGroupDmMapper()
    }

    @Provides
    fun provideSubjectsDmToTimetableItemsDmMapper(): SubjectsDmToTimetableItemsDmMapper {
        return SubjectsDmToTimetableItemsDmMapper()
    }

    @Provides
    fun provideTimetableItemToSubjectDmMapper(): TimetableItemDtoSubjectDmMapper {
        return TimetableItemDtoSubjectDmMapper()
    }

    @Provides
    fun provideTimetableDtoToTimetableDmMapper(
        timetableItemDtoSubjectDmMapper: TimetableItemDtoSubjectDmMapper,
        subjectsDmToTimetableItemsDmMapper: SubjectsDmToTimetableItemsDmMapper,
    ): TimetableDtoToTimetableDmMapper {
        return TimetableDtoToTimetableDmMapper(
            timetableItemDtoSubjectDmMapper = timetableItemDtoSubjectDmMapper,
            subjectsDmToTimetableItemsDmMapper = subjectsDmToTimetableItemsDmMapper,
        )
    }

    @Provides
    fun provideGroupEntityToGroupDmMapper(): GroupEntityToGroupDmMapper {
        return GroupEntityToGroupDmMapper()
    }

    @Provides
    fun provideGroupDtoToGroupEntityMapper(): GroupDtoToGroupEntityMapper {
        return GroupDtoToGroupEntityMapper()
    }
}