package com.marina.composeapp.di.module

import com.marina.composeapp.data.repository.CharacterRepositoryImpl
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

    companion object {
        @Provides
        fun provideApi(): CharacterApi {
            return RetrofitInstance.characterApi
        }
    }
}