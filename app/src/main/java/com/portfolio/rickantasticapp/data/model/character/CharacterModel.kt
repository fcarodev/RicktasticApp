package com.portfolio.rickantasticapp.data.model.character

import com.google.gson.annotations.SerializedName

data class CharacterModel(
    @SerializedName("id")
    val id: Int? = -1,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("status")
    val status:String?=null,
    @SerializedName("species")
    val species: String? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("gender")
    val gender: String? = null,
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("created")
    val created: String? = null,
    @SerializedName("episode")
    val episode: MutableList<String>? = mutableListOf(),
    @SerializedName("origin")
    val origin: Data? = null,
    @SerializedName("location")
    val location: Data? = null
)

data class Data(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("url")
    val url: String? = null
)