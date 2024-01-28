package com.kekulta.timetable.data.network.dtos

import com.google.gson.annotations.SerializedName

data class GroupDto(
    @SerializedName("id") val id: Int?,
    @SerializedName("group") val group: String?,
)