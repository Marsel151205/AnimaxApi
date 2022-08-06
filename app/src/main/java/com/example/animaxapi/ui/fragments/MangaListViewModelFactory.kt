package com.example.animaxapi.ui.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.animaxapi.data.repository.AnimaxApiRepository

class MangaListViewModelFactory constructor(private val repository: AnimaxApiRepository): ViewModelProvider.Factory {

    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MangaListViewModel::class.java)) {
            MangaListViewModel(this.repository) as T
        }else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}