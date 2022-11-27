package com.marina.composeapp.data.repository

import android.app.Application
import com.marina.composeapp.R
import com.marina.composeapp.data.storage.mapper.fromDtoToEntity
import com.marina.composeapp.data.storage.remote.CharacterApi
import com.marina.composeapp.domain.entity.CharacterEntity
import com.marina.composeapp.domain.repository.CharacterRepository
import com.marina.composeapp.domain.util.Resource
import javax.inject.Inject


class CharacterRepositoryImpl @Inject constructor(
    private val api: CharacterApi,
    private val context: Application
) : CharacterRepository {

    override suspend fun getCharacters(): Resource<List<CharacterEntity>> {
        return try {
            val response = api.getCharacters()
            val characters = response.characterDtos.fromDtoToEntity()
            Resource.Success(data = characters)
        } catch (e: Exception) {
            Resource.Error(message = context.getString(R.string.unknown_error))
        }
    }
}