package com.example.sampleapplication.data.database

import android.content.Context
import androidx.room.*
import com.example.sampleapplication.data.model.ProfileDetails

@Database(entities = [ProfileDetails::class], version = 1,exportSchema = false)
@TypeConverters(Converters::class)
abstract class ProfileDB : RoomDatabase() {
    abstract fun repDao(): ProfileDAO

    companion object {
        var INSTANCE: ProfileDB? = null

        fun getInstance(context: Context): ProfileDB? {

            if (INSTANCE == null) {
                INSTANCE =
                        Room.databaseBuilder(
                                context.applicationContext,
                                ProfileDB::class.java,
                                "ProfileDB"
                        )
                                .build()

            } else {
                INSTANCE
            }
            return INSTANCE
        }
    }
}