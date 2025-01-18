package com.example.movietv.network.model

import com.google.gson.annotations.SerializedName

data class MovieOrShow(
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("year") val year: String?,
    @SerializedName("poster") val poster: String?
)
