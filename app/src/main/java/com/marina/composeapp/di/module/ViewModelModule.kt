package com.marina.composeapp.di.module

import android.app.Application
import com.marina.composeapp.di.annotation.ApplicationScope
import com.marina.composeapp.domain.use_case.GetAllCharacters
import com.marina.composeapp.domain.use_case.GetFavoriteCharacters
import com.marina.composeapp.domain.use_case.RemoveCharacterFromFavorites
import com.marina.composeapp.presentation.list.CharacterListViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @Provides
    @ApplicationScope
    fun provideViewModel(
        context: Application,
        getAllCharacters: GetAllCharacters,
        getFavoriteCharacters: GetFavoriteCharacters,
        removeCharacterFromFavorites: RemoveCharacterFromFavorites
    ): CharacterListViewModel {
        return CharacterListViewModel(
            context = context,
            getAllCharacters = getAllCharacters,
            getFavoriteCharacters = getFavoriteCharacters,
            removeCharacterFromFavorites = removeCharacterFromFavorites
        )
    }
}