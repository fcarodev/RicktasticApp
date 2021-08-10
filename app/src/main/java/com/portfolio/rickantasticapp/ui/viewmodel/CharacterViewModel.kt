package com.portfolio.rickantasticapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.portfolio.rickantasticapp.data.model.character.CharacterModel
import com.portfolio.rickantasticapp.data.model.character.CharacterProvider
import com.portfolio.rickantasticapp.domain.GetCharacterByPageUseCase
import com.portfolio.rickantasticapp.domain.GetCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val getCharacterUseCase: GetCharacterUseCase,
    private val getCharacterByPageUseCase: GetCharacterByPageUseCase
    ) : ViewModel() {

    val characterModel = MutableLiveData<CharacterModel>()
    val listCharacterModel = MutableLiveData<MutableList<CharacterModel>>()

    fun onCreate() {
        viewModelScope.launch {
            val result = getCharacterByPageUseCase(1)
            if(result.isEmpty()) {
                val characterEmpty  = CharacterModel(-2)
                result.add(characterEmpty)
            }
            listCharacterModel.postValue(result)
        }
    }

    fun randomCharacter(int: Int) {
        viewModelScope.launch {
            val result = getCharacterUseCase(int)
            characterModel.postValue(result)
        }
    }

    fun getCharacterByPage(page:Int){
        viewModelScope.launch {
            val result = getCharacterByPageUseCase(page)
            listCharacterModel.postValue(result)
        }
    }
}
