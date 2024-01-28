package com.kekulta.timetable.data.bd.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kekulta.timetable.data.bd.entities.GroupEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class GroupEntity(
    @PrimaryKey
    @ColumnInfo(name = GROUP)
    val group: Int,
    @ColumnInfo(name = ID)
    val id: Int,
) {
    companion object {
        const val TABLE_NAME = "GroupEntity_Table"
        const val ID = "Id_GroupEntity"
        const val GROUP = "Group_GroupEntity"
    }
}