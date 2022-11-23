package com.marina.composeapp.data.storage.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.marina.composeapp.data.storage.local.db.entity.CharacterDB

@Dao
interface CharacterDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCharacter(pictureDB: CharacterDB)

    @Query("select * from character")
    suspend fun getFavoriteCharacters(): List<CharacterDB>

    @Query("delete from character where id=:id")
    suspend fun removeCharacter(id: String)
}