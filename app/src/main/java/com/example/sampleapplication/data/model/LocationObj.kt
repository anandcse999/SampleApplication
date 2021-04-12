package com.example.sampleapplication.data.model

import com.google.gson.annotations.SerializedName

data class LocationObj(
    @field:SerializedName("city")
    val city: String = "",
    @field:SerializedName("state")
    val state: String = "",
    @field:SerializedName("country")
    val country: String = "",

    )