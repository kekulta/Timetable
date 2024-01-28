package com.kekulta.timetable.data.network.impls

import com.kekulta.timetable.data.mappers.TimetableDtoToTimetableDmMapper
import com.kekulta.timetable.data.network.KaiService
import com.kekulta.timetable.domain.models.GroupDm
import com.kekulta.timetable.domain.models.TimetableDayDm
import com.kekulta.timetable.domain.models.TimetableDm
import com.kekulta.timetable.domain.repositories.api.TimetableRepository
import io.reactivex.Observable
import javax.inject.Inject

class TimetableRepositoryImpl @Inject constructor(
    private val kaiService: KaiService,
    private val timetableDtoToTimetableDmMapper: TimetableDtoToTimetableDmMapper,
) : TimetableRepository {

    override fun observeTimetable(group: GroupDm): Observable<TimetableDm> {
        return if (group is GroupDm.Group) {
            kaiService
                .getTimetable(groupId = group.groupId.toString())
                .toObservable()
                .map { response ->
                    val body = response.body()
                    if (response.isSuccessful && body != null) {
                        timetableDtoToTimetableDmMapper.map(body)
                    } else {
                        EMPTY
                    }
                }
        } else {
            Observable.just(EMPTY)
        }
    }

    companion object {
        private val EMPTY = TimetableDm(
            monday = TimetableDayDm(null),
            tuesday = TimetableDayDm(null),
            wednesday = TimetableDayDm(null),
            thursday = TimetableDayDm(null),
            friday = TimetableDayDm(null),
            saturday = TimetableDayDm(null),
        )
    }
}