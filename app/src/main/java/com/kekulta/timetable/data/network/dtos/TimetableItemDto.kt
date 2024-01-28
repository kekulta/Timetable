package com.kekulta.timetable.data.network.dtos

import com.google.gson.annotations.SerializedName

data class TimetableItemDto(
    @SerializedName("disciplName") val subject: String?,
    @SerializedName("prepodName") val professor: String?,
    @SerializedName("audNum") val classroom: String?,
    @SerializedName("buildNum") val building: String?,
    @SerializedName("dayDate") val scheduleType: String?,
    @SerializedName("dayTime") val time: String?,
    @SerializedName("disciplType") val classType: String?
)