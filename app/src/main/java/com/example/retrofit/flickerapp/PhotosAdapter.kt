package com.example.retrofit.flickerapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.flickerapp.model.Image
import com.squareup.picasso.Picasso


class PhotosAdapter(val images: MutableList<Image> = mutableListOf()) :
    RecyclerView.Adapter <PhotosAdapter.PhotosViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        val vh = PhotosViewHolder(LayoutInflater
            .from(parent.context)
            .inflate(R.layout.single_photo, parent, false))
        return vh
    }

    override fun getItemCount(): Int = images.size

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        holder.bind(images[position])
    }

    inner class PhotosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(image: Image) {
            Picasso.get().load(image.url)
                .resize(512, 512)
                .centerCrop()
                .into(itemView.findViewById(R.id.imageView) as ImageView)
        }
    }
}