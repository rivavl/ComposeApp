package com.marina.composeapp.domain.use_case

import com.marina.composeapp.domain.repository.CharacterRepository
import javax.inject.Inject

class RemoveAllCharactersFromFavorites @Inject constructor(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke() {
        return repository.removeAllFavoriteCharacters()
    }
}