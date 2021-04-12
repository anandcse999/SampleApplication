package com.example.sampleapplication.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sampleapplication.helpers.Result
import com.example.sampleapplication.api.ApiManager
import com.example.sampleapplication.data.database.ProfileDB
import com.example.sampleapplication.data.model.ProfileDetails
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class ProfilesRepo {
    private val profileList: MutableLiveData<Result<List<ProfileDetails>>> = MutableLiveData()
    fun getProfileList(): LiveData<Result<List<ProfileDetails>>> = profileList
    fun requestProfileList(
        viewModelScope: CoroutineScope,
        mContext: Context

    ) {
        viewModelScope.launch {
            profileList.postValue(Result.loading(null))
            try {
                var result: List<ProfileDetails>? = null
                result = ProfileDB.getInstance(mContext)?.repDao()?.getAllData("key")
                if (result?.size == 0) {
                    val response = ApiManager.getClient().getProfile()
                    if (response != null) {
                        ProfileDB.getInstance(mContext)?.repDao()
                            ?.insertAll(response.profileDetails!!)
                    }
                    result= ProfileDB.getInstance(mContext)?.repDao()?.getAllData("key")
                }

                profileList.postValue(Result.success(result))

            } catch (e: Exception) {
                profileList.postValue(Result.error(e.toString(), null))
            }
        }
    }

    fun update(
        viewModelScope: CoroutineScope,
        mContext: Context,
        key: Int,
        acceptStatus: Boolean
    ) {
        viewModelScope.launch {
            try {
                ProfileDB.getInstance(mContext)?.repDao()
                    ?.updateDownloadStatus(acceptStatus, 1, key)

            } catch (e: Exception) {
                profileList.postValue(Result.error(e.toString(), null))
            }
        }
    }
}