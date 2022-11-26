package com.marina.composeapp.presentation.mapper

import com.marina.composeapp.domain.entity.CharacterEntity
import com.marina.composeapp.presentation.entity.CharacterUI

fun CharacterEntity.fromEntityToUI(): CharacterUI {
    return CharacterUI(
        id = id,
        name = name,
        image = image,
        gender = gender,
        location = locationName,
        origin = originName,
        species = species,
        status = status,
        type = type
    )
}

fun List<CharacterEntity>.fromEntityToUI(): List<CharacterUI> {
    return map {
        it.fromEntityToUI()
    }
}

fun CharacterUI.fromUIToEntity(): CharacterEntity {
    return CharacterEntity(
        id = id,
        name = name,
        image = image,
        gender = gender,
        locationName = location,
        originName = origin,
        species = species,
        status = status,
        type = type
    )
}