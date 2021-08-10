package com.portfolio.rickantasticapp.data.model.base

import com.google.gson.annotations.SerializedName

data class BaseResponseData<T>(
    @SerializedName("info")
    val info: Info? = null,
    @SerializedName("results")
    val result: MutableList<T>? = null
)

data class Info(
    @SerializedName("count")
    val count: Int? = 0,
    @SerializedName("pages")
    val pages: Int? = 0,
    @SerializedName("next")
    val next: String? = null,
    @SerializedName("prev")
    val prev: String? = null
)









