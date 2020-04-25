package com.wjom.parcialpasado01

import com.google.gson.annotations.SerializedName

data class Joke(
    val id: String,
    @SerializedName("joke") val joke: String,
    val status: Int
)