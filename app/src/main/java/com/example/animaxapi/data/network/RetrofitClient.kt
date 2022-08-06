package com.example.animaxapi.data.network

import com.example.animaxapi.data.network.api.AnimaxApiService
import com.example.animaxapi.data.network.interceptor.AnimaxInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private val okHttp: OkHttpClient = OkHttpClient().newBuilder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .addInterceptor(AnimaxInterceptor())
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS).build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://best-manga-anime-wallpapers.p.rapidapi.com/wallpapers/")
        .addConverterFactory(GsonConverterFactory.create())

        .client(okHttp)
        .build()

    val animaxApiService: AnimaxApiService = retrofit.create(AnimaxApiService::class.java)
}