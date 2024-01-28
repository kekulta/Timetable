package com.kekulta.timetable.data.mappers

import com.kekulta.timetable.data.network.dtos.GroupDto
import com.kekulta.timetable.domain.models.GroupDm

class GroupDtoToGroupDmMapper {
    fun map(dtos: List<GroupDto>): List<GroupDm.Group> {
        return dtos.mapNotNull { dto ->
            if (dto.id == null || dto.group?.toIntOrNull() == null) {
                null
            } else {
                GroupDm.Group(
                    number = dto.group.toIntOrNull()!!,
                    groupId = dto.id,
                )
            }
        }
    }
}