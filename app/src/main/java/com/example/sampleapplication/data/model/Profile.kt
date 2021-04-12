package com.example.sampleapplication.data.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
@Entity(tableName = "ProfileDetail")

data class Profile (
    @field:SerializedName("results")
    val profileDetails: List<ProfileDetails>?=null
        )