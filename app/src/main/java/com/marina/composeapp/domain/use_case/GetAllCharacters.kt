package com.marina.composeapp.domain.use_case

import com.marina.composeapp.domain.entity.CharacterEntity
import com.marina.composeapp.domain.repository.CharacterRepository
import com.marina.composeapp.util.Resource
import javax.inject.Inject

class GetAllCharacters @Inject constructor(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(): Resource<List<CharacterEntity>> {
        return repository.getCharacters()
    }
}