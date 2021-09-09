package com.providoindodigital.mgoal.api.dao


import com.google.gson.annotations.SerializedName

data class MatchDao(
    @SerializedName("data")
    val matchDao: List<MatchDataDao>
)