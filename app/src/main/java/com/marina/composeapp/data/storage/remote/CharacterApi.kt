package com.marina.composeapp.data.storage.remote

import com.marina.composeapp.data.storage.remote.dto.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApi {
    @GET("character/")
    suspend fun getCharacters(
        @Query("page")
        pageNumber: Int = 1
    ): CharacterResponse
}