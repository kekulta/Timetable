package com.kekulta.timetable.domain.repositories.api

import com.kekulta.timetable.domain.models.GroupDm
import com.kekulta.timetable.domain.models.TimetableDm
import io.reactivex.Observable

interface TimetableRepository {
    fun observeTimetable(group: GroupDm): Observable<TimetableDm>
}