package com.marina.composeapp.data.storage.remote.dto

import com.google.gson.annotations.SerializedName

data class Origin(
    @SerializedName("name")
    val name: String
)