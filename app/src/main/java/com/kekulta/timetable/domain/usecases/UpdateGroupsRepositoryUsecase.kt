package com.kekulta.timetable.domain.usecases

import com.kekulta.timetable.domain.repositories.api.GroupsRepository
import io.reactivex.Completable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class UpdateGroupsRepositoryUsecase @Inject constructor(
    private val groupsRepository: GroupsRepository
) {
    fun execute(): Completable {
        return groupsRepository.requestUpdate()
    }
}