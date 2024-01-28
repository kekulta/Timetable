package com.kekulta.timetable.domain.models

sealed class GroupDm {
    data class Group(
        val number: Int,
        val groupId: Int,
    ) : GroupDm()

    data class NoGroup(val number: Int) : GroupDm()
}

