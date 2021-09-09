package com.providoindodigital.mgoal.api.dao


import com.google.gson.annotations.SerializedName

data class ExtraExplainDao(
    @SerializedName("awayScore")
    val awayScore: Int,
    @SerializedName("extraAwayScore")
    val extraAwayScore: Int,
    @SerializedName("extraHomeScore")
    val extraHomeScore: Int,
    @SerializedName("extraTimeStatus")
    val extraTimeStatus: Int,
    @SerializedName("homeScore")
    val homeScore: Int,
    @SerializedName("kickOff")
    val kickOff: Int,
    @SerializedName("minute")
    val minute: Int,
    @SerializedName("penAwayScore")
    val penAwayScore: Int,
    @SerializedName("penHomeScore")
    val penHomeScore: Int,
    @SerializedName("twoRoundsAwayScore")
    val twoRoundsAwayScore: Int,
    @SerializedName("twoRoundsHomeScore")
    val twoRoundsHomeScore: Int,
    @SerializedName("winner")
    val winner: Int
)