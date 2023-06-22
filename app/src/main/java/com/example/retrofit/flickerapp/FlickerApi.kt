package com.example.retrofit.flickerapp

import com.example.retrofit.flickerapp.model.PhotoSearchResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val FlickerApiKey = "b0b3ba9938fe215ba5be8139d1b6d3fe";

interface FlickerApi {
    // https://www.flickr.com/services/rest/
    // ?method=flickr.photos.getRecent&api_key=f26122f865cabe63c16d807e9d803bbf&format=rest

    @GET("?method=flickr.photos.getRecent&api_key=${FlickerApiKey}&format=json&nojsoncallback=?")
    suspend fun fetchPhotos(): PhotoSearchResponse


    @GET("?method=flickr.photos.search&api_key=${FlickerApiKey}&format=json&nojsoncallback=?")
    suspend fun searchPhotos(@Query("text") search: String): PhotoSearchResponse
}