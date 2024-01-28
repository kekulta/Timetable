package com.kekulta.timetable.di

import android.content.Context
import androidx.room.Room
import com.kekulta.timetable.data.bd.AppDb
import com.kekulta.timetable.data.bd.PersistentService
import com.kekulta.timetable.data.bd.daos.GroupDao
import com.kekulta.timetable.data.bd.room.RoomPersistentService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PersistentModule {
    @Provides
    @Singleton
    fun provideDatabase(context: Context): AppDb {
        return Room.databaseBuilder(
            context = context,
            klass = AppDb::class.java,
            name = "app-db"
        ).build()
    }

    @Provides
    fun provideGroupDao(db: AppDb): GroupDao {
        return db.getGroupDao()
    }

    @Provides
    fun provideRoomPersistentService(groupDao: GroupDao): PersistentService {
        return RoomPersistentService(groupDao)
    }
}