package com.marina.composeapp.data.repository

import android.app.Application
import android.graphics.BitmapFactory
import com.marina.composeapp.R
import com.marina.composeapp.data.storage.local.db.AppDatabase
import com.marina.composeapp.data.storage.local.db.dao.CharacterDao
import com.marina.composeapp.data.storage.local.file.InternalStoragePicture
import com.marina.composeapp.data.storage.local.file.SaveImageIntoFile
import com.marina.composeapp.data.storage.local.file.SaveImageIntoStorage
import com.marina.composeapp.data.storage.mapper.fromDBToEntity
import com.marina.composeapp.data.storage.mapper.fromDtoToEntity
import com.marina.composeapp.data.storage.mapper.fromEntityToDB
import com.marina.composeapp.data.storage.remote.CharacterApi
import com.marina.composeapp.domain.entity.CharacterEntity
import com.marina.composeapp.domain.repository.CharacterRepository
import com.marina.composeapp.util.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL
import javax.inject.Inject


class CharacterRepositoryImpl @Inject constructor(
    private val api: CharacterApi,
    private val dao: CharacterDao,
    private val storage: SaveImageIntoStorage,
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

    override suspend fun getFavoriteCharacters(): Resource<List<CharacterEntity>> {
        return try {
            val response = dao.getFavoriteCharacters()
            val characters = response.fromDBToEntity()
            Resource.Success(data = characters)
        } catch (e: Exception) {
            Resource.Error(message = context.getString(R.string.unknown_error))
        }
    }

    override suspend fun getSingleCharacter(id: Int): Resource<CharacterEntity> {
        return try {
            val response = api.getCharacterById(id)
            val character = response.fromDtoToEntity()
            Resource.Success(data = character)
        } catch (e: Exception) {
            Resource.Error(message = context.getString(R.string.unknown_error))
        }
    }

    override suspend fun removeFavoriteCharacter(id: Int) {
        val character = dao.getSingleCharacter(id)
        storage.deleteImage(character.name)
        dao.removeCharacter(id)
    }

    override suspend fun removeAllFavoriteCharacters() {
        dao.removeAllCharacters()
        storage.deleteAllImages()
    }

    override suspend fun saveCharacter(character: CharacterEntity) {
        val imageName = character.image
        val urlToArray = imageName.split("/")
        val nameInDb = urlToArray[urlToArray.size - 1]
        dao.saveCharacter(character.fromEntityToDB())

        CoroutineScope(Dispatchers.IO).launch {
            kotlin.runCatching {
                val url = URL(imageName)
                val image = BitmapFactory.decodeStream(url.openStream())
                storage.saveImage(InternalStoragePicture(nameInDb, image))
            }
        }
    }
}