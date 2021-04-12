package com.example.sampleapplication.data.database

import androidx.room.TypeConverter
import com.example.sampleapplication.data.model.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*


object Converters {

    @TypeConverter
    @JvmStatic
    fun listToString(list: ArrayList<ProfileDetails?>?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    @JvmStatic
    fun fromStringToList(value: String?): ArrayList<ProfileDetails?>? {
        val listType = object : TypeToken<ArrayList<ProfileDetails?>?>() {}.type
        return Gson().fromJson(value, listType)
    }
    @TypeConverter
    @JvmStatic
    fun pictureToString(list: Picture?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }
    @TypeConverter
    @JvmStatic
    fun fromStringToPicture(value: String?): Picture? {
        val listType = object : TypeToken<Picture>() {}.type
        return Gson().fromJson(value, listType)
    }
    @TypeConverter
    @JvmStatic
    fun dobToString(list: Dob?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }
    @TypeConverter
    @JvmStatic
    fun fromStringToDob(value: String?): Dob? {
        val listType = object : TypeToken<Dob>() {}.type
        return Gson().fromJson(value, listType)
    }
    @TypeConverter
    @JvmStatic
    fun nameToString(list: NameObj?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }
    @TypeConverter
    @JvmStatic
    fun fromStringToNameObj(value: String?): NameObj? {
        val listType = object : TypeToken<NameObj>() {}.type
        return Gson().fromJson(value, listType)
    }
    @TypeConverter
    @JvmStatic
    fun locationToString(list: LocationObj?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }
    @TypeConverter
    @JvmStatic
    fun fromStringToLocationObj(value: String?): LocationObj? {
        val listType = object : TypeToken<LocationObj>() {}.type
        return Gson().fromJson(value, listType)
    }
    @TypeConverter
    @JvmStatic
    fun idToString(list: Id?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }
    @TypeConverter
    @JvmStatic
    fun fromStringToId(value: String?): Id? {
        val listType = object : TypeToken<Id>() {}.type
        return Gson().fromJson(value, listType)
    }
}