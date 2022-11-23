package com.marina.composeapp.data.storage.mapper

import com.marina.composeapp.data.storage.local.db.entity.CharacterDB
import com.marina.composeapp.data.storage.remote.dto.CharacterDto
import com.marina.composeapp.domain.entity.CharacterEntity

fun CharacterDto.fromDtoToEntity(): CharacterEntity {
    return CharacterEntity(
        id = id,
        name = name,
        image = image,
        gender = gender,
        locationName = location.name,
        originName = origin.name,
        species = species,
        status = status,
        type = type
    )
}

fun List<CharacterDto>.fromDtoToEntity(): List<CharacterEntity> {
    return map {
        it.fromDtoToEntity()
    }
}

fun CharacterDB.fromDBToEntity(): CharacterEntity {
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

fun List<CharacterDB>.fromDBToEntity(): List<CharacterEntity> {
    return map {
        it.fromDBToEntity()
    }
}

fun CharacterEntity.fromEntityToDB(): CharacterDB {
    return CharacterDB(
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