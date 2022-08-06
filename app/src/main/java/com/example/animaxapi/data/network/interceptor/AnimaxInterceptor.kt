package com.example.animaxapi.data.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class AnimaxInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val theBuilders = request.newBuilder()
            .header("X-RapidAPI-Key", "d26db9251dmsh537964c235d771ep193165jsnc68953bf554a")
        val build = theBuilders.build()
        return chain.proceed(build)
    }
}