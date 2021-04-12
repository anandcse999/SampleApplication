package com.example.sampleapplication.helpers

import com.example.sampleapplication.data.model.ProfileDetails


interface ItemClickListenr {
    fun onItemClick(country: ProfileDetails, acceptStatus:Boolean)
}