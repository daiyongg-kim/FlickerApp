package com.example.retrofit.flickerapp.model

import com.squareup.moshi.Json

data class PhotosMetadata(
    @Json(name = "page")
    val page: Int,
    @Json(name = "group")
    val photo: List<PhotoResponse>
)
