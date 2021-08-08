package com.portfolio.rickantasticapp.data.network

import com.portfolio.rickantasticapp.data.model.character.CharacterModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharacterService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getCharacter(id:Int):CharacterModel{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(API.Character::class.java).getCharacterById(id)
            response.body() ?: CharacterModel()
        }

    }
}