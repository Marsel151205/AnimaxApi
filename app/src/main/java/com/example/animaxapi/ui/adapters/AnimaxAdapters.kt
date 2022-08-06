package com.example.animaxapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.animaxapi.databinding.ItemAnimeListBinding

class AnimaxAdapters(private val list: List<String>):
    RecyclerView.Adapter<AnimaxAdapters.AnimaxViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimaxViewHolder {
        return AnimaxViewHolder(ItemAnimeListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: AnimaxViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount() = list.size

    class AnimaxViewHolder(private val binding: ItemAnimeListBinding): RecyclerView.ViewHolder(binding.root) {
        fun onBind(list: String) {
            Glide.with(binding.ivAnimax).load(list).into(binding.ivAnimax)

        }

    }
}