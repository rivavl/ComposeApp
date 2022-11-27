package com.marina.composeapp.presentation.list

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.marina.composeapp.presentation.ui.theme.CharacterCard

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
fun CharacterListScreen(viewModel: CharacterListViewModel) {
    Scaffold {
        val charactersList = viewModel.charactersList.observeAsState(listOf())

        LazyColumn(
            modifier = Modifier
                .padding(it)
                .fillMaxWidth()
                .background(Color.Magenta),
            contentPadding = PaddingValues(
                top = 16.dp,
                start = 8.dp,
                end = 8.dp,
                bottom = 72.dp
            ),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = CenterHorizontally
        ) {
            items(
                items = charactersList.value,
                key = { it.id },
            ) { character ->
                val dismissState = rememberDismissState()
                if (dismissState.isDismissed(DismissDirection.EndToStart)) {
                    viewModel.removeCharacter(character)
                }

                SwipeToDismiss(
                    modifier = Modifier.animateItemPlacement(),
                    state = dismissState,
                    background = {},
                    directions = setOf(DismissDirection.EndToStart),
                ) {
                    CharacterCard(
                        modifier = Modifier
                            .height(350.dp)
                            .width(320.dp),
                        character = character,
                        onClickListener = {
                            Log.e(this.javaClass.simpleName, character.name)
                        }
                    )
                }
            }
        }
    }
}
