package com.marina.composeapp.domain.entity

data class CharacterEntity(
    val id: Int,
    val name: String,
    val image: String,
    val gender: String,
    val locationName: String,
    val originName: String,
    val species: String,
    val status: String,
    val type: String
)