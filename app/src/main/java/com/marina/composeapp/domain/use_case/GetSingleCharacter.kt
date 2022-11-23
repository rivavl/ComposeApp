package com.marina.composeapp.domain.use_case

import com.marina.composeapp.domain.entity.CharacterEntity
import com.marina.composeapp.domain.repository.CharacterRepository
import com.marina.composeapp.util.Resource
import javax.inject.Inject

class GetSingleCharacter @Inject constructor(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(): Resource<CharacterEntity> {
        return repository.getSingleCharacter()
    }
}