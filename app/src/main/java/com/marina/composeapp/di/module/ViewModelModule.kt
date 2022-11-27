package com.marina.composeapp.di.module

import com.marina.composeapp.di.annotation.ApplicationScope
import com.marina.composeapp.domain.use_case.GetCharacters
import com.marina.composeapp.presentation.list.CharacterListViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @Provides
    @ApplicationScope
    fun provideViewModel(
        getCharacters: GetCharacters
    ): CharacterListViewModel {
        return CharacterListViewModel(
            getCharacters = getCharacters
        )
    }
}