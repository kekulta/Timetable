package com.kekulta.timetable.data.network

import com.kekulta.timetable.data.network.dtos.GroupDto
import com.kekulta.timetable.data.network.dtos.TimetableDto
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Response

interface KaiService {
    fun getGroups(): Single<Response<List<GroupDto>>>

    fun getTimetable(
        groupId: String
    ): Single<Response<TimetableDto>>
}