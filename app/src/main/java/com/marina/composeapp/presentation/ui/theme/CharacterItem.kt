package com.marina.composeapp.presentation.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
            .fillMaxWidth(),
        elevation = 2.dp,
    ) {
        GlideImage(
            model = character.image,
            contentDescription = null,
            modifier = modifier,
            alignment = Alignment.TopCenter
        )
    }
}