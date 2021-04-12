package com.example.sampleapplication.viewmodel

import android.content.Context
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sampleapplication.data.ProfilesRepo

class ProfileViewModel:ViewModel(),LifecycleObserver {
    private val profileRepo = ProfilesRepo()
    fun getProfiles() =
        profileRepo.getProfileList()
    fun requestData(mContext: Context) {
        profileRepo.requestProfileList(viewModelScope, mContext)
    }
    fun updateData(key: Int, acceptStatus: Boolean,mContext: Context)
    {
        profileRepo.update(viewModelScope, mContext,key,acceptStatus)

    }
}