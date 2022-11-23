package com.marina.composeapp.data.storage.remote.dto

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("name")
    val name: String
)