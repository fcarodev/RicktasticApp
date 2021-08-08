package com.portfolio.rickantasticapp.domain

import com.portfolio.rickantasticapp.data.CharacterRepository
import com.portfolio.rickantasticapp.data.model.character.CharacterModel

class GetCharacterUseCase {

    private val repository = CharacterRepository()
    suspend operator fun invoke(id: Int): CharacterModel? =  repository.getCharacterById(id)

}