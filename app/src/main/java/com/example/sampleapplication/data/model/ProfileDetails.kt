package com.example.sampleapplication.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.sampleapplication.data.model.*
import com.google.gson.annotations.SerializedName

@Entity(tableName = "ProfileDetail")
data class ProfileDetails(
    @PrimaryKey(autoGenerate = true)
    val  key : Int,
    val acceptStatus:Boolean=false,
    val showStatus:Int=0,
    @field:SerializedName("gender")
    val gender: String = "",
    @field:SerializedName("nat")
    val nat: String = "",
    @field:SerializedName("picture")
    val picture: Picture? = null,
    @field:SerializedName("dob")
    val dob: Dob? = null,
    @field:SerializedName("name")
    val name: NameObj? = null,
    @field:SerializedName("location")
    val location: LocationObj? = null,
    @field:SerializedName("id")
    val id: Id? = null
)
