package com.portfolio.rickantasticapp.data

import com.portfolio.rickantasticapp.data.model.character.CharacterModel
import com.portfolio.rickantasticapp.data.model.character.CharacterProvider
import com.portfolio.rickantasticapp.data.network.CharacterService
import javax.inject.Inject

/**
 * Class in charge of managing where the data is obtained, either from a REST Service or local database.
 */
class CharacterRepository @Inject constructor(private val api : CharacterService,private val characterProvider: CharacterProvider){

    suspend fun getCharacterById(id: Int): CharacterModel = api.getCharacter(id)

    suspend fun getCharacterByPage(page:Int): MutableList<CharacterModel> = api.getCharacterByPage(page)

}