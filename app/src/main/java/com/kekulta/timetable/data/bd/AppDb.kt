package com.kekulta.timetable.data.bd

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kekulta.timetable.data.bd.daos.GroupDao
import com.kekulta.timetable.data.bd.entities.GroupEntity

@Database(
    entities = [GroupEntity::class], version = 1
)
abstract class AppDb : RoomDatabase() {
    abstract fun getGroupDao(): GroupDao
}