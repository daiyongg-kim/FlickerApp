package com.example.retrofit.flickerapp.model

import com.squareup.moshi.Json

data class PhotoResponse(
    @Json(name = "id")
    val id : String,
    @Json(name = "owner")
    val owner: String,
    @Json(name = "secret")
    val secret: String,
    @Json(name = "server")
    val server: String,
    @Json(name = "farm")
    val farm: Int,
    @Json(name = "title")
    val title: String
)
