package com.kekulta.timetable.data.mappers

import com.kekulta.timetable.data.bd.entities.GroupEntity
import com.kekulta.timetable.data.network.dtos.GroupDto

class GroupDtoToGroupEntityMapper {
    fun map(dtos: List<GroupDto>): List<GroupEntity> {
        return dtos.mapNotNull { dto ->
            if (dto.group?.toIntOrNull() == null || dto.id == null) {
                null
            } else {
                GroupEntity(
                    group = dto.group?.toIntOrNull()!!,
                    id = dto.id,
                )
            }
        }
    }
}