package com.portfolio.rickantasticapp.data.network

import com.portfolio.rickantasticapp.data.model.base.BaseResponseData
import com.portfolio.rickantasticapp.data.model.character.CharacterModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface API {

    interface Character{
        @GET("api/character/{id}")
        suspend fun getCharacterById(@Path("id") sub: Int):Response<CharacterModel>

        @GET("api/character/")
        suspend fun getCharacterByPage(@Query("page") page:Int):Response<BaseResponseData<CharacterModel>>
    }
    interface Episode{}
    interface Location{}
}