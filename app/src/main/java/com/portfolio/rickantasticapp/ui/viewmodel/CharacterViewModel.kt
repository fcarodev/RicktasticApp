package com.portfolio.rickantasticapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.portfolio.rickantasticapp.data.model.character.CharacterModel
import com.portfolio.rickantasticapp.data.model.character.CharacterProvider
import com.portfolio.rickantasticapp.domain.GetCharacterUseCase
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {

    val characterModel = MutableLiveData<CharacterModel>()
    private val getCharacterUseCase = GetCharacterUseCase()
    fun randomCharacter(int: Int){
        viewModelScope.launch {
            val result = getCharacterUseCase(int)
            if (result != null ){
                characterModel.postValue(result!!)
            }
        }
    }

    fun onCreate(){
        viewModelScope.launch {
            val result = getCharacterUseCase(1)
            if (result != null ){
                characterModel.postValue(result!!)
            }
        }
    }
}
