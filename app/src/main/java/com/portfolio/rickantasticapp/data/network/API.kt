package com.portfolio.rickantasticapp.data.network

import com.portfolio.rickantasticapp.data.model.character.CharacterModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface API {

    interface Character{
        @GET("api/character/{id}")
        suspend fun getCharacterById(@Path("id") sub: Int):Response<CharacterModel>

    }
    interface Episode{}
    interface Location{}
}