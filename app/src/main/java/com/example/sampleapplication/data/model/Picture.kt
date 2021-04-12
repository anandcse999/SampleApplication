package com.example.sampleapplication.data.model

import com.google.gson.annotations.SerializedName

data class Picture(
    @field:SerializedName("large")
    val large: String = "",
    @field:SerializedName("medium")
    val medium: String = ""
)