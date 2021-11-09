package com.shvants.balinatestapp.domain.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.shvants.balinatestapp.R
import com.shvants.balinatestapp.data.repository.PhotoImage
import com.shvants.balinatestapp.databinding.ViewImageItemBinding
import com.shvants.balinatestapp.util.stringToBitmap

class ImageAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var photos = mutableListOf<PhotoImage>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ImageHolder(
            ViewImageItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = photos.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        with(holder as ImageHolder) {
            val item = photos[position]
            bind(item)
        }
    }

    fun setPhotos(list: List<PhotoImage>) {
        photos.clear()
        photos.addAll(list)

        notifyDataSetChanged()
    }

    fun addImage(image: PhotoImage) {
        photos.add(image)
        val position = photos.indexOf(image)

        notifyItemInserted(position)
    }

    inner class ImageHolder(
        private val binding: ViewImageItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PhotoImage) {
            with(binding) {
                val img = item.url.stringToBitmap()

                when {
                    img != null -> imagePreview.setImageBitmap(img)
                    else -> imagePreview.setImageResource(R.drawable.icon)
                }


//                imagePreview.load(item.url) {
//                    crossfade(true)
//                    placeholder(R.drawable.splash_logo)
//                    error(R.drawable.icon)
//                }
                imageDate.text = item.date
            }
        }
    }
}