package com.marina.composeapp.presentation.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.marina.composeapp.presentation.entity.CharacterUI

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CharacterCard(
    modifier: Modifier = Modifier,
    character: CharacterUI,
    onClickListener: () -> Unit
) {
    Card(
        modifier = modifier
            .clickable { onClickListener() }
            .background(MaterialTheme.colors.onBackground),
        elevation = 2.dp,

        ) {
        Column {
            GlideImage(
                modifier = Modifier.size(320.dp),
                model = character.image,
                contentDescription = null
            )
            Text(
                text = character.name,
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier
                    .padding(4.dp)
            )
        }
    }
}