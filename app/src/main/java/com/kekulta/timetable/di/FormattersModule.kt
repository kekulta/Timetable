package com.kekulta.timetable.di

import com.kekulta.timetable.domain.formatters.ClassTypeFormatter
import com.kekulta.timetable.domain.formatters.DayOfTheWeekFormatter
import com.kekulta.timetable.domain.formatters.SubjectDmToSubjectVoFormatter
import com.kekulta.timetable.domain.formatters.SubjectTypeFormatter
import com.kekulta.timetable.domain.formatters.TimeDmFormatter
import com.kekulta.timetable.domain.formatters.TimetableDayDmToTimetableDayVoFormatter
import com.kekulta.timetable.domain.formatters.TimetableDmToTimetableVoFormatter
import com.kekulta.timetable.domain.formatters.TimetableItemDmToTimetableItemVoFormatter
import dagger.Module
import dagger.Provides

@Module
class FormattersModule {
    @Provides
    fun provideClassTypeFormatter(): ClassTypeFormatter {
        return ClassTypeFormatter()
    }

    @Provides
    fun provideDayOfTheWeekFormatter(): DayOfTheWeekFormatter {
        return DayOfTheWeekFormatter()
    }

    @Provides
    fun provideSubjectDmToSubjectVoFormatter(
        timeDmFormatter: TimeDmFormatter,
        subjectTypeFormatter: SubjectTypeFormatter,
        classTypeFormatter: ClassTypeFormatter,
    ): SubjectDmToSubjectVoFormatter {
        return SubjectDmToSubjectVoFormatter(
            timeFormatter = timeDmFormatter,
            subjectTypeFormatter = subjectTypeFormatter,
            classTypeFormatter = classTypeFormatter,
        )
    }

    @Provides
    fun provideSubjectTypeFormatter(): SubjectTypeFormatter {
        return SubjectTypeFormatter()
    }

    @Provides
    fun provideTimeDmFormatter(): TimeDmFormatter {
        return TimeDmFormatter()
    }

    @Provides
    fun provideTimetableDayDmToTimetableDayVoFormatter(
        dayOfTheWeekFormatter: DayOfTheWeekFormatter,
        timetableItemDmToTimetableItemVoFormatter: TimetableItemDmToTimetableItemVoFormatter
    ): TimetableDayDmToTimetableDayVoFormatter {
        return TimetableDayDmToTimetableDayVoFormatter(
            dayOfTheWeekFormatter = dayOfTheWeekFormatter,
            timetableItemDmToTimetableItemVoFormatter = timetableItemDmToTimetableItemVoFormatter
        )
    }

    @Provides
    fun provideTimetableDmToTimetableVoFormatter(timetableDayDmToTimetableDayVoFormatter: TimetableDayDmToTimetableDayVoFormatter): TimetableDmToTimetableVoFormatter {
        return TimetableDmToTimetableVoFormatter(timetableDayDmToTimetableDayVoFormatter = timetableDayDmToTimetableDayVoFormatter)
    }

    @Provides
    fun provideTimetableItemDmToTimetableItemVoFormatter(subjectDmToSubjectVoFormatter: SubjectDmToSubjectVoFormatter): TimetableItemDmToTimetableItemVoFormatter {
        return TimetableItemDmToTimetableItemVoFormatter(subjectDmToSubjectVoFormatter = subjectDmToSubjectVoFormatter)
    }
}