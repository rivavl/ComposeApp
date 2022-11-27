package com.marina.composeapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.marina.composeapp.app.App
import com.marina.composeapp.presentation.list.CharacterListScreen
import com.marina.composeapp.presentation.ui.theme.BlueDarkest
import com.marina.composeapp.presentation.ui.theme.ComposeAppTheme

class MainActivity : ComponentActivity() {

    private val component by lazy {
        (application as App).component
    }

    private val viewModel by lazy {
        component.getViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                SetStatusBarColor()
                CharacterListScreen(viewModel = viewModel)
            }
        }
    }

    @Composable
    private fun SetStatusBarColor() {
        val systemUiController = rememberSystemUiController()
        SideEffect {
            systemUiController.setStatusBarColor(
                color = BlueDarkest,
                darkIcons = false
            )
        }
    }

}