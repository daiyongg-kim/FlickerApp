package com.example.retrofit.flickerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.retrofit.flickerapp.databinding.ActivityMainBinding
import com.example.retrofit.flickerapp.viewmodel.PhotosViewModel


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imagesRecyclerView.layoutManager = GridLayoutManager(this, 3)
        val photoViewModel : PhotosViewModel by viewModels()

        var textView : TextView = findViewById(R.id.searchText)

        binding.loadImagesButton.setOnClickListener {
            binding.imagesRecyclerView.adapter = photoViewModel.photoAdapter
            photoViewModel.loadPhotos(textView.text.toString())
                .observe(this, Observer { list ->
                    with (photoViewModel.photoAdapter) {
                        images.clear()
                        images.addAll(list)
                        notifyDataSetChanged()
                    }
            })
//            CoroutineScope(Dispatchers.IO).launch {
//                val results: PhotoSearchResponse = ImageRepository.flickerApi.searchPhotos("dog")
//                for(any in results.photos.photo) {
//                    Log.i("MyTag", any.toString())
//                }
//            }
        }
    }
}