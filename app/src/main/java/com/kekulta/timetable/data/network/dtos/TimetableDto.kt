package com.kekulta.timetable.data.network.dtos

import com.google.gson.annotations.SerializedName

data class TimetableDto(
    @SerializedName("1") val monday: List<TimetableItemDto?>?,
    @SerializedName("2") val tuesday: List<TimetableItemDto?>?,
    @SerializedName("3") val wednesday: List<TimetableItemDto?>?,
    @SerializedName("4") val thursday: List<TimetableItemDto?>?,
    @SerializedName("5") val friday: List<TimetableItemDto?>?,
    @SerializedName("6") val saturday: List<TimetableItemDto?>?,
)