package com.example.animaxapi.data.network.api

import retrofit2.Call
import retrofit2.http.GET

interface AnimaxApiService {

    @GET("cartoon-wallpaper")
    fun getAnimeWallpapersList(
    ): Call<List<String>>
}