package com.marina.composeapp.presentation.list

import android.app.Application
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.marina.composeapp.presentation.entity.CharacterUI
import com.marina.composeapp.presentation.ui.theme.CharacterCard

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
fun CharacterListScreen(viewModel: CharacterListViewModel) {
    Scaffold(
//        bottomBar = {
//            BottomNavigation {
//                val selectedItemPosition = remember {
//                    mutableStateOf(0)
//                }
//
//                val items = listOf(
//                    NavigationItem.Home,
//                    NavigationItem.Favourite,
//                    NavigationItem.Profile
//                )
//                items.forEachIndexed { index, item ->
//                    BottomNavigationItem(
//                        selected = selectedItemPosition.value == index,
//                        onClick = { selectedItemPosition.value = index },
//                        icon = {
//                            Icon(item.icon, contentDescription = null)
//                        },
//                        label = {
//                            Text(text = stringResource(id = item.titleResId))
//                        },
//                        selectedContentColor = MaterialTheme.colors.onPrimary,
//                        unselectedContentColor = MaterialTheme.colors.onSecondary
//                    )
//                }
//            }
//        }
    ) {
        val charactersList = viewModel.charactersList.observeAsState(listOf())

        LazyColumn(
            modifier = Modifier.padding(it).fillMaxWidth(),
            contentPadding = PaddingValues(
                top = 16.dp,
                start = 8.dp,
                end = 8.dp,
                bottom = 72.dp
            ),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
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
                        modifier = Modifier.size(320.dp),
                        character = character,
                        onClickListener = {
                            Log.e("MYTAG", character.name)
                        }
                    )
                }
            }
        }
    }
}