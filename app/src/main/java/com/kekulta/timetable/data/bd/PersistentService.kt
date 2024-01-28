package com.kekulta.timetable.data.bd

import com.kekulta.timetable.data.bd.entities.GroupEntity
import io.reactivex.Observable
import java.util.Optional

interface PersistentService {
    fun observeByGroup(group: Int): Observable<Optional<GroupEntity>>
    fun insertAll(groups: List<GroupEntity>)
    fun delete(group: GroupEntity)
}