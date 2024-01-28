package com.kekulta.timetable.data.mappers

import com.kekulta.timetable.data.bd.entities.GroupEntity
import com.kekulta.timetable.domain.models.GroupDm

class GroupEntityToGroupDmMapper {
    fun map(entities: List<GroupEntity>): List<GroupDm> {
        return entities.map { entity ->
            GroupDm.Group(
                number = entity.group,
                groupId = entity.id,
            )
        }
    }
}