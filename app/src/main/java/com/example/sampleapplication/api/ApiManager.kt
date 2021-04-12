package com.example.sampleapplication.api

import com.example.sampleapplication.BuildConfig
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiManager {
    private var httpClient: OkHttpClient? = null
    fun getClient(): ApiInterface {
        val retroFit =
            Retrofit.Builder().client(getRequestHeader())
                .baseUrl(BuildConfig.API_END_POINT)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build()
        return retroFit.create(ApiInterface::class.java)

    }

    private fun getRequestHeader(): OkHttpClient? {
        if (httpClient == null) {
            httpClient = OkHttpClient.Builder()
                .readTimeout(120, TimeUnit.SECONDS)
                .connectTimeout(120, TimeUnit.SECONDS)
                .callTimeout(120, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .addInterceptor(CustomInterceptor())
                .build()
        }
        return httpClient
    }
}