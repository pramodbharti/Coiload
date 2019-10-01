package com.db.coiload.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.db.coiload.R
import com.db.coiload.databinding.PhotoItemViewBinding
import com.db.coiload.models.Photo

class PhotoAdapter(private val context: Context, private val photos: List<Photo>) :
    RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(PhotoItemViewBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int = photos.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(photos[position])
    inner class ViewHolder(private val binding: PhotoItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(photo: Photo) {
            binding.photo = photo
            binding.ivPhoto.load(photo.download_url) {
                placeholder(context.getDrawable(R.drawable.loading))
            }
            binding.executePendingBindings()
        }
    }
}