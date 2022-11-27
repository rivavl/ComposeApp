package com.marina.composeapp.app

import android.app.Application
import com.marina.composeapp.di.component.DaggerAppComponent

class App : Application() {
    val component by lazy {
        DaggerAppComponent.factory().create(this)
    }
}