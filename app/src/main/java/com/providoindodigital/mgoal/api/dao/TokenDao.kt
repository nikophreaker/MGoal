package com.providoindodigital.mgoal.api.dao

import com.google.gson.annotations.SerializedName

data class TokenDao(
    @SerializedName("token")
    val token: String
)