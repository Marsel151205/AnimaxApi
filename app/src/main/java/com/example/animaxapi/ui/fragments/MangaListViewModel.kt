package com.example.animaxapi.ui.fragments

import androidx.lifecycle.ViewModel
import com.example.animaxapi.data.repository.AnimaxApiRepository

class MangaListViewModel(private val repository: AnimaxApiRepository): ViewModel() {

    fun getAnimeWallpaperList() = repository.getAnimeWallpaperList()
}