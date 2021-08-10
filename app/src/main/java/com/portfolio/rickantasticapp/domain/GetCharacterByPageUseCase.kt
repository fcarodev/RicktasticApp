package com.portfolio.rickantasticapp.domain

import com.portfolio.rickantasticapp.data.CharacterRepository
import com.portfolio.rickantasticapp.data.model.character.CharacterModel
import javax.inject.Inject

class GetCharacterByPageUseCase @Inject constructor(private val repository: CharacterRepository) {

    suspend operator fun invoke(page:Int): MutableList<CharacterModel> =  repository.getCharacterByPage(page)
}