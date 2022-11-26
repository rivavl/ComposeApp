package com.marina.composeapp.presentation.entity

data class CharacterUI(
    val id: Int,
    val name: String,
    val gender: String,
    val image: String,
    val location: String,
    val origin: String,
    val species: String,
    val status: String,
    val type: String = ""
)
