package com.example.sampleapplication.api

import com.example.sampleapplication.data.model.Profile
import retrofit2.http.GET

interface ApiInterface {
    @GET(ApiConstants.API_LIST)
    suspend fun getProfile(): Profile

}