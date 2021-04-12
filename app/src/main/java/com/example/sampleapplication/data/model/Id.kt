package com.example.sampleapplication.data.model

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Id (
    @field:SerializedName("name")
    val name:String,
    @field:SerializedName("value")
    val value: String
        )