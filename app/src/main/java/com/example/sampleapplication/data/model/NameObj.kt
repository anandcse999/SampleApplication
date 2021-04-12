package com.example.sampleapplication.data.model

import com.google.gson.annotations.SerializedName

data class NameObj(
    @field:SerializedName("title")
    val title: String = "",
    @field:SerializedName("first")
    val firstName: String = "",
    @field:SerializedName("last")
    val lastName: String = ""
)