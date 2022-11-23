package com.marina.composeapp.domain.repository

import com.marina.composeapp.domain.entity.CharacterEntity
import com.marina.composeapp.util.Resource

interface CharacterRepository {

    suspend fun getCharacters(): Resource<List<CharacterEntity>>
    suspend fun getFavoriteCharacters(): Resource<List<CharacterEntity>>
    suspend fun getSingleCharacter(id: Int): Resource<CharacterEntity>
    suspend fun removeFavoriteCharacter(id: Int)
    suspend fun removeAllFavoriteCharacters()
    suspend fun saveCharacter(character: CharacterEntity)
}