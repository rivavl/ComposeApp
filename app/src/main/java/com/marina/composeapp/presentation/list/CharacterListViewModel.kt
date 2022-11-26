package com.marina.composeapp.presentation.list

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marina.composeapp.data.repository.CharacterRepositoryImpl
import com.marina.composeapp.data.storage.remote.RetrofitInstance
import com.marina.composeapp.domain.use_case.GetAllCharacters
import com.marina.composeapp.domain.use_case.GetFavoriteCharacters
import com.marina.composeapp.domain.use_case.RemoveCharacterFromFavorites
import com.marina.composeapp.presentation.entity.CharacterUI
import com.marina.composeapp.presentation.mapper.fromEntityToUI
import com.marina.composeapp.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharacterListViewModel @Inject constructor(
    private val context: Application,
    private val getAllCharacters: GetAllCharacters,
    private val getFavoriteCharacters: GetFavoriteCharacters,
    private val removeCharacterFromFavorites: RemoveCharacterFromFavorites
) : ViewModel() {

    private val _charactersList = MutableLiveData<List<CharacterUI>>()
    val charactersList: LiveData<List<CharacterUI>> get() = _charactersList

    private val _loadError = MutableLiveData("")
    val loadError: LiveData<String> get() = _loadError

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _endReached = MutableLiveData(false)
    val endReached: LiveData<Boolean> get() = _endReached

    init {
        viewModelScope.launch(Dispatchers.Default) {
            val characters = getAllCharacters.invoke()
            when (characters) {
                is Resource.Success -> {
                    val data = characters.data?.fromEntityToUI()
                    _charactersList.postValue(data)
                }
                else -> {}
            }
        }
    }

    fun removeCharacter(characterUI: CharacterUI) {
        val newList = charactersList.value?.toMutableList()?.apply { remove(characterUI) }
        _charactersList.postValue(newList)
    }
}