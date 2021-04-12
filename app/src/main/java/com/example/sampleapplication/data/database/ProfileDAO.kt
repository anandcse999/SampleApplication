package com.example.sampleapplication.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.sampleapplication.data.model.ProfileDetails

@Dao
interface ProfileDAO {

    @Insert(onConflict = REPLACE)
    suspend fun insertAll(list: List<ProfileDetails>)


    @Query("SELECT * FROM ProfileDetail ORDER BY :key")
    suspend fun getAllData(key:String): List<ProfileDetails>

    @Query(
        "UPDATE ProfileDetail SET acceptStatus = :acceptStatus, showStatus = :showStatus " +
                "WHERE key = :mKey")
    suspend fun updateDownloadStatus(acceptStatus: Boolean, showStatus: Int,mKey:Int)


}