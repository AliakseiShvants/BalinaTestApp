package com.shvants.balinatestapp.view

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shvants.balinatestapp.databinding.AdapterImageItemBinding
import com.shvants.balinatestapp.databinding.FragmentMainBinding
import com.shvants.network.entity.ImageDtoOut

class ImageAdapter(
    private val list: List<ImageDtoOut>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    inner class ImageHolder(
        private val binding: AdapterImageItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ImageDtoOut) {
            with(binding) {
                imagePreview.setImageBitmap()
            }
        }
    }
}