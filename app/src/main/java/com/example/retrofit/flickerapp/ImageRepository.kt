package com.example.retrofit.flickerapp


import okhttp3.Interceptor.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


private const val baseURL = "https://www.flickr.com/services/rest/"


object ImageRepository {
    val flickerApi: FlickerApi

    init
    {

        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()

        flickerApi = retrofit.create(FlickerApi::class.java)
    }
}