package com.providoindodigital.mgoal.api.dao


import com.google.gson.annotations.SerializedName

data class MatchDao(
    @SerializedName("message")
    val msg: String?,
    @SerializedName("data")
    val matchDao: List<MatchDataDao>
)