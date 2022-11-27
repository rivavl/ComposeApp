package com.marina.composeapp.domain.repository

import com.marina.composeapp.domain.entity.CharacterEntity
import com.marina.composeapp.domain.util.Resource

interface CharacterRepository {
    suspend fun getCharacters(): Resource<List<CharacterEntity>>
}