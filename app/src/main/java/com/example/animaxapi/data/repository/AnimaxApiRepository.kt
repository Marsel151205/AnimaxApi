package com.example.animaxapi.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.animaxapi.data.network.api.AnimaxApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AnimaxApiRepository(private val apiService: AnimaxApiService) {

    fun getAnimeWallpaperList(): MutableLiveData<List<String>> {
        val data = MutableLiveData<List<String>>()

        apiService.getAnimeWallpapersList().enqueue(object
            : Callback<List<String>> {
            override fun onResponse(
                call: Call<List<String>>,
                response: Response<List<String>>
            ) {
                response.body()?.let {
                    data.value = it
                }
            }

            override fun onFailure(call: Call<List<String>>, t: Throwable) {
                t.message?.let { Log.e("error", it) }
            }
        })
        return data
    }
}