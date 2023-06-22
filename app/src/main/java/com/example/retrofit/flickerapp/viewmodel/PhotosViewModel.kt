package com.example.retrofit.flickerapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.flickerapp.ImageRepository
import com.example.retrofit.flickerapp.PhotosAdapter
import com.example.retrofit.flickerapp.model.Image
import com.example.retrofit.flickerapp.model.PhotoSearchResponse
import kotlinx.coroutines.launch

class PhotosViewModel : ViewModel(){
    val imagesLiveData = MutableLiveData<List<Image>> ()
    var photoAdapter = PhotosAdapter()


    fun loadPhotos(search : String) : LiveData<List<Image>>
    {
        viewModelScope.launch {
            val results : PhotoSearchResponse = ImageRepository.flickerApi.searchPhotos(search)
            val imgList : List<Image> = results.photos.photo.map { photo->
                Image(id = photo.id,
                    url = "https://live.staticflickr.com/${photo.server}/${photo.id}_${photo.secret}.jpg",
                    title = photo.title)
            }
            imagesLiveData.postValue(imgList)
        }

        return imagesLiveData
    }
}