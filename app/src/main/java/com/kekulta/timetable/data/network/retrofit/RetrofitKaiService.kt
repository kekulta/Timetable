package com.kekulta.timetable.data.network.retrofit

import android.util.Log
import com.kekulta.timetable.data.network.KaiService
import com.kekulta.timetable.data.network.dtos.GroupDto
import com.kekulta.timetable.data.network.dtos.TimetableDto
import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.MediaType
import okhttp3.RequestBody
import retrofit2.Response
import javax.inject.Inject

class RetrofitKaiService @Inject constructor(private val api: RetrofitKaiApi) : KaiService {
    override fun getGroups(): Single<Response<List<GroupDto>>> {
        return api.getGroups()
    }

    override fun getTimetable(groupId: String): Single<Response<TimetableDto>> {
        val body = RequestBody.create(MediaType.parse("text/plain"), "groupId=$groupId")
        return api.getTimetable(body)
    }
}