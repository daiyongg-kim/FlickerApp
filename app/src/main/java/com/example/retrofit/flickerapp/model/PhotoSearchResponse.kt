package com.example.retrofit.flickerapp.model

import com.squareup.moshi.Json

data class PhotoSearchResponse(
    @Json(name = "groups")
    val photos: PhotosMetadata
)
