package com.kekulta.timetable.data.bd.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kekulta.timetable.data.bd.entities.GroupEntity
import io.reactivex.Observable
import java.util.Optional

@Dao
interface GroupDao {
    @Query(
        """
        SELECT * FROM ${GroupEntity.TABLE_NAME} WHERE ${GroupEntity.GROUP} LIKE :group
    """
    )
    fun observeByGroup(group: Int): Observable<Optional<GroupEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(groups: List<GroupEntity>)

    @Delete
    fun delete(group: GroupEntity)

}