package com.wjom.parcialpasado01.interfaces

import com.wjom.parcialpasado01.Joke
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

object RETROFIT_FORMATS {
    const val JSON_FORMAT = "application/json"
    const val XML_FORMAT = "xml"
}

interface JokeService {
    @GET(".")
    fun getJoke(
        @Header("Content-Type") content_type: String,
        @Header("Accept") accept: String
    ): Call<Joke>
}