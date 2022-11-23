package com.marina.composeapp.domain.use_case

import com.marina.composeapp.domain.repository.CharacterRepository
import javax.inject.Inject

class RemoveCharacterFromFavorites @Inject constructor(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(id: Int) {
        return repository.removeFavoriteCharacter(id)
    }
}