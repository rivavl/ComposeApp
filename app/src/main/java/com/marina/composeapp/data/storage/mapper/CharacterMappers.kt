package com.marina.composeapp.data.storage.mapper

import com.marina.composeapp.data.storage.remote.dto.CharacterDto
import com.marina.composeapp.domain.entity.CharacterEntity

fun CharacterDto.fromDtoToEntity(): CharacterEntity {
    return CharacterEntity(
        id = id,
        name = name,
        image = image
    )
}

fun List<CharacterDto>.fromDtoToEntity(): List<CharacterEntity> {
    return map {
        it.fromDtoToEntity()
    }
}