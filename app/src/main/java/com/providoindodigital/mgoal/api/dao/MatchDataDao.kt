package com.providoindodigital.mgoal.api.dao


import com.google.gson.annotations.SerializedName

data class MatchDataDao(
    @SerializedName("awayCorner")
    val awayCorner: Int,
    @SerializedName("awayHalfScore")
    val awayHalfScore: Int,
    @SerializedName("awayId")
    val awayId: String,
    @SerializedName("awayLogo")
    val awayLogo: String,
    @SerializedName("awayName")
    val awayName: String,
    @SerializedName("awayRank")
    val awayRank: String,
    @SerializedName("awayRed")
    val awayRed: Int,
    @SerializedName("awayScore")
    val awayScore: Int,
    @SerializedName("awayYellow")
    val awayYellow: Int,
    @SerializedName("explain")
    val explain: String,
    @SerializedName("extraExplain")
    val extraExplainDao: ExtraExplainDao,
    @SerializedName("group")
    val group: String,
    @SerializedName("halfStartTime")
    val halfStartTime: Int,
    @SerializedName("hasLineup")
    val hasLineup: Boolean,
    @SerializedName("homeCorner")
    val homeCorner: Int,
    @SerializedName("homeHalfScore")
    val homeHalfScore: Int,
    @SerializedName("homeId")
    val homeId: String,
    @SerializedName("homeLogo")
    val homeLogo: String,
    @SerializedName("homeName")
    val homeName: String,
    @SerializedName("homeRank")
    val homeRank: String,
    @SerializedName("homeRed")
    val homeRed: Int,
    @SerializedName("homeScore")
    val homeScore: Int,
    @SerializedName("homeYellow")
    val homeYellow: Int,
    @SerializedName("leagueColor")
    val leagueColor: String,
    @SerializedName("leagueId")
    val leagueId: String,
    @SerializedName("leagueName")
    val leagueName: String,
    @SerializedName("leagueShortName")
    val leagueShortName: String,
    @SerializedName("leagueType")
    val leagueType: Int,
    @SerializedName("location")
    val location: String,
    @SerializedName("matchId")
    val matchId: String,
    @SerializedName("matchTime")
    val matchTime: Int,
    @SerializedName("neutral")
    val neutral: Boolean,
    @SerializedName("round")
    val round: String,
    @SerializedName("season")
    val season: String,
    @SerializedName("status")
    val status: Int,
    @SerializedName("subLeagueId")
    val subLeagueId: String,
    @SerializedName("subLeagueName")
    val subLeagueName: String,
    @SerializedName("temperature")
    val temperature: String,
    @SerializedName("weather")
    val weather: String
)