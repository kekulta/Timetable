package com.kekulta.timetable.data.network.retrofit

import com.kekulta.timetable.data.network.Api
import com.kekulta.timetable.data.network.dtos.GroupDto
import com.kekulta.timetable.data.network.dtos.TimetableDto
import io.reactivex.Single
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface RetrofitKaiApi {
    @GET(Api.Common.ENDPOINT)
    fun getGroups(
        @Query("p_p_id") id: String = Api.Common.p_p_id,
        @Query("p_p_lifecycle") lifecycle: String = Api.Common.p_p_lifecycle,
        @Query("p_p_state") state: String = Api.Groups.p_p_state,
        @Query("p_p_mode") mode: String = Api.Common.p_p_mode,
        @Query("p_p_resource_id") resourceId: String = Api.Groups.p_p_resource_id,
        @Query("p_p_cacheability") cacheability: String = Api.Common.p_p_cacheability,
        @Query("p_p_col_id") colId: String = Api.Common.p_p_col_id,
        @Query("p_p_col_count") colCount: String = Api.Common.p_p_col_count,
    ): Single<Response<List<GroupDto>>>

    @Headers(Api.Timetable.CONTENT_TYPE_HEADER)
    @POST(Api.Common.ENDPOINT)
    fun getTimetable(
        @Body body: RequestBody,
        @Query("p_p_id") id: String = Api.Common.p_p_id,
        @Query("p_p_lifecycle") lifecycle: String = Api.Common.p_p_lifecycle,
        @Query("p_p_state") state: String = Api.Timetable.p_p_state,
        @Query("p_p_mode") mode: String = Api.Common.p_p_mode,
        @Query("p_p_resource_id") resourceId: String = Api.Timetable.p_p_resource_id,
        @Query("p_p_cacheability") cacheability: String = Api.Common.p_p_cacheability,
        @Query("p_p_col_id") colId: String = Api.Common.p_p_col_id,
        @Query("p_p_col_count") colCount: String = Api.Common.p_p_col_count,
    ): Single<Response<TimetableDto>>
}