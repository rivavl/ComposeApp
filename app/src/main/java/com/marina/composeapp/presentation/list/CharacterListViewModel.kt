package com.marina.composeapp.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marina.composeapp.domain.use_case.GetCharacters
import com.marina.composeapp.presentation.entity.CharacterUI
import com.marina.composeapp.presentation.mapper.fromEntityToUI
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharacterListViewModel @Inject constructor(
    private val getCharacters: GetCharacters
) : ViewModel() {

    private val _charactersList = MutableLiveData<List<CharacterUI>>()
    val charactersList: LiveData<List<CharacterUI>> get() = _charactersList

    init {
        loadCharactersPaginated()
    }

    private fun loadCharactersPaginated() = viewModelScope.launch {
        val characters = getCharacters.invoke()
        val data = characters.data?.fromEntityToUI()
        _charactersList.postValue(data)
    }

    fun removeCharacter(characterUI: CharacterUI) {
        val newList = charactersList.value?.toMutableList()?.apply { remove(characterUI) }
        _charactersList.postValue(newList)
    }
}