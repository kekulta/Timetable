package com.kekulta.timetable.domain.usecases

import com.kekulta.timetable.domain.models.WeekParity
import com.kekulta.timetable.domain.repositories.api.WeekParityRepository

class InverseWeekParityUsecase(
    private val weekParityRepository: WeekParityRepository
) {
    fun execute() {
        when (weekParityRepository.getWeekParitySync()) {
            WeekParity.Odd -> {
                weekParityRepository.setWeekParity(WeekParity.Even)
            }

            WeekParity.Even -> {
                weekParityRepository.setWeekParity(WeekParity.Odd)
            }
        }
    }
}