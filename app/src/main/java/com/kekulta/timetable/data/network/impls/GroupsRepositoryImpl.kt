package com.kekulta.timetable.data.network.impls

import com.kekulta.timetable.data.bd.PersistentService
import com.kekulta.timetable.data.mappers.GroupDtoToGroupEntityMapper
import com.kekulta.timetable.data.mappers.GroupEntityToGroupDmMapper
import com.kekulta.timetable.data.network.KaiService
import com.kekulta.timetable.domain.models.GroupDm
import com.kekulta.timetable.domain.repositories.api.GroupsRepository
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject
import kotlin.jvm.optionals.getOrNull

class GroupsRepositoryImpl @Inject constructor(
    private val groupDtoToGroupEntityMapper: GroupDtoToGroupEntityMapper,
    private val groupEntityToGroupDmMapper: GroupEntityToGroupDmMapper,
    private val persistentService: PersistentService,
    private val kaiService: KaiService,
) : GroupsRepository {
    override fun getGroup(groupNum: Int): Observable<GroupDm> {
        return persistentService.observeByGroup(groupNum).map { groupEntityOptional ->
            groupEntityOptional.getOrNull()?.let { groupEntity ->
                groupEntityToGroupDmMapper.map(listOf(groupEntity))
            }?.first() ?: GroupDm.NoGroup(groupNum)
        }
    }

    override fun requestUpdate(): Completable {
        return kaiService.getGroups().flatMapCompletable { response ->
            val body = response.body()
            if (response.isSuccessful && body != null) {
                persistentService.insertAll(groupDtoToGroupEntityMapper.map(body))
            }
            Completable.complete()
        }
    }
}