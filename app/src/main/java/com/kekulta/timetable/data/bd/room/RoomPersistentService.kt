package com.kekulta.timetable.data.bd.room

import com.kekulta.timetable.data.bd.PersistentService
import com.kekulta.timetable.data.bd.daos.GroupDao
import com.kekulta.timetable.data.bd.entities.GroupEntity
import io.reactivex.Observable
import java.util.Optional
import javax.inject.Inject

class RoomPersistentService @Inject constructor(
    private val groupDao: GroupDao
) : PersistentService {
    override fun observeByGroup(group: Int): Observable<Optional<GroupEntity>> {
        return groupDao.observeByGroup(group).distinctUntilChanged()
    }

    override fun insertAll(groups: List<GroupEntity>) {
        groupDao.insertAll(groups)
    }

    override fun delete(group: GroupEntity) {
        groupDao.delete(group)
    }
}