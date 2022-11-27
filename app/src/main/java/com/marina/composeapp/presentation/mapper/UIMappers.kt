package com.marina.composeapp.presentation.mapper

import com.marina.composeapp.domain.entity.CharacterEntity
import com.marina.composeapp.presentation.entity.CharacterUI

fun CharacterEntity.fromEntityToUI(): CharacterUI {
    return CharacterUI(
        id = id,
        name = name,
        image = image
    )
}

fun List<CharacterEntity>.fromEntityToUI(): List<CharacterUI> {
    return map {
        it.fromEntityToUI()
    }
}