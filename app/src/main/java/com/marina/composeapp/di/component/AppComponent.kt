package com.marina.composeapp.di.component

import android.app.Application
import com.marina.composeapp.di.annotation.ApplicationScope
import com.marina.composeapp.di.module.DataModule
import com.marina.composeapp.di.module.ViewModelModule
import com.marina.composeapp.presentation.list.CharacterListViewModel
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [DataModule::class, ViewModelModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): AppComponent
    }

    fun getViewModel(): CharacterListViewModel
}