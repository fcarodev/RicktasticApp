package com.portfolio.rickantasticapp.data

import com.portfolio.rickantasticapp.data.model.character.CharacterModel
import com.portfolio.rickantasticapp.data.model.character.CharacterProvider
import com.portfolio.rickantasticapp.data.network.CharacterService

class CharacterRepository {

    private val api = CharacterService()

    suspend fun getCharacterById(id:Int):CharacterModel{
        val response = api.getCharacter(id)
        CharacterProvider.characterModel = response
        return response
    }
}