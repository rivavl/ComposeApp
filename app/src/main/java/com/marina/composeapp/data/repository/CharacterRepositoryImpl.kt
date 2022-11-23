package com.marina.composeapp.data.repository

import com.marina.composeapp.domain.entity.CharacterEntity
import com.marina.composeapp.domain.repository.CharacterRepository
import com.marina.composeapp.util.Resource

class CharacterRepositoryImpl : CharacterRepository {
    override suspend fun getCharacters(): Resource<List<CharacterEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun getFavoriteCharacters(): Resource<List<CharacterEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun getSingleCharacter(): Resource<CharacterEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun removeFavoriteCharacter() {
        TODO("Not yet implemented")
    }

}