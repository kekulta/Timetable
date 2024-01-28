package com.kekulta.timetable.domain.repositories.api

import com.kekulta.timetable.domain.models.GroupDm
import io.reactivex.Completable
import io.reactivex.Observable

interface GroupsRepository {
    fun getGroup(groupNum: Int): Observable<GroupDm>
    fun requestUpdate(): Completable
}