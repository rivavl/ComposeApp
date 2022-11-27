package com.marina.composeapp.data.storage.remote.dto

import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("results")
    val characterDtos: List<CharacterDto>
)