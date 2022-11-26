package com.marina.composeapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.marina.composeapp.di.component.DaggerAppComponent
import com.marina.composeapp.presentation.list.CharacterListScreen
import com.marina.composeapp.presentation.list.CharacterListViewModel
import com.marina.composeapp.presentation.ui.theme.ComposeAppTheme
import com.marina.composeapp.presentation.util.daggerViewModel

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: CharacterListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                val component = DaggerAppComponent.factory().create(application)

                val viewModel: CharacterListViewModel = daggerViewModel {
                    Log.i("COMPNAVILOG", "create VM: Screen1ViewModel")
                    component.getViewModel()
                }
                CharacterListScreen(viewModel = viewModel)
            }
        }
    }
}