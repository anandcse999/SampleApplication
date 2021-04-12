package com.example.sampleapplication.api

import okhttp3.Interceptor
import okhttp3.Response

class CustomInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val builder = request.url.newBuilder()
        val url = builder.build()

        request = request.newBuilder()
            .url(url)
            .build()

        return chain.proceed(request)
    }
}