package com.example.animaxapi.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.animaxapi.data.network.RetrofitClient
import com.example.animaxapi.data.repository.AnimaxApiRepository
import com.example.animaxapi.databinding.FragmentMangaListBinding
import com.example.animaxapi.ui.adapters.AnimaxAdapters

class MangaListFragment : Fragment() {

    private lateinit var binding: FragmentMangaListBinding
    private lateinit var viewModel: MangaListViewModel
    private val mangaList = arrayListOf<String>()
    private val adapter = AnimaxAdapters(mangaList)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMangaListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialization()

        viewModel.getAnimeWallpaperList().observe(viewLifecycleOwner) {
            mangaList.addAll(it)
            binding.recyclerAnimaxList.adapter = adapter
        }
    }

    private fun initialization() {
        viewModel = ViewModelProvider(
            this, MangaListViewModelFactory(AnimaxApiRepository(RetrofitClient.animaxApiService))
        )[MangaListViewModel::class.java]
    }
}