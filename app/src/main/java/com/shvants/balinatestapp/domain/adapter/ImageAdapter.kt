package com.shvants.balinatestapp.domain.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.shvants.balinatestapp.data.repository.Image
import com.shvants.balinatestapp.databinding.ViewImageItemBinding

class ImageAdapter(
    private val list: List<Image>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ImageHolder(
            ViewImageItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        with(holder as ImageHolder) {
            val item = list[position]
            bind(item)
        }
    }

    inner class ImageHolder(
        private val binding: ViewImageItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Image) {
            with(binding) {
                imagePreview.load(item.url) {
                    crossfade(true)
                }
                imageDate.text = item.date
            }
        }
    }
}