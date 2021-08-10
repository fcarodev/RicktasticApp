package com.portfolio.rickantasticapp.data.network

import com.portfolio.rickantasticapp.data.model.character.CharacterModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import javax.inject.Inject

class CharacterService  @Inject constructor(private val api:API.Character){

    suspend fun getCharacter(id:Int):CharacterModel{
        return withContext(Dispatchers.IO){
            val response = api.getCharacterById(id)
            response.body() ?: CharacterModel()
        }
    }

    suspend fun getCharacterByPage(page:Int):MutableList<CharacterModel>{
        return withContext(Dispatchers.IO){
            val response = api.getCharacterByPage(page)
            response.body()!!.result ?: mutableListOf()
        }
    }
}