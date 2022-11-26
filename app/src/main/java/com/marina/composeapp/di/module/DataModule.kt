package com.marina.composeapp.di.module

import android.app.Application
import com.marina.composeapp.data.repository.CharacterRepositoryImpl
import com.marina.composeapp.data.storage.local.db.AppDatabase
import com.marina.composeapp.data.storage.local.db.dao.CharacterDao
import com.marina.composeapp.data.storage.local.file.SaveImageIntoFile
import com.marina.composeapp.data.storage.local.file.SaveImageIntoStorage
import com.marina.composeapp.data.storage.remote.CharacterApi
import com.marina.composeapp.data.storage.remote.RetrofitInstance
import com.marina.composeapp.di.annotation.ApplicationScope
import com.marina.composeapp.domain.repository.CharacterRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindCoinRepository(impl: CharacterRepositoryImpl): CharacterRepository

    @ApplicationScope
    @Binds
    fun bindSaveImageIntoStorage(impl: SaveImageIntoFile): SaveImageIntoStorage

    companion object {
        @ApplicationScope
        @Provides
        fun provideApi(): CharacterApi {
            return RetrofitInstance.characterApi
        }

        @ApplicationScope
        @Provides
        fun provideDao(database: AppDatabase): CharacterDao {
            return database.characterDao()
        }

        @ApplicationScope
        @Provides
        fun provideDatabase(context: Application): AppDatabase {
            return AppDatabase.getInstance(context)
        }
    }
}