package com.marina.composeapp.data.storage.remote.dto

import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val characterDtos: List<CharacterDto>
)