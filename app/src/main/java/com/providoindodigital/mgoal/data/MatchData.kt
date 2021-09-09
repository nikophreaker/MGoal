package com.providoindodigital.mgoal.data


import com.providoindodigital.mgoal.api.dao.ExtraExplainDao

class MatchData (
    var awayCorner: Int? = 0,
    var awayHalfScore: Int? = 0,
    var awayId: String? = "-",
    var awayLogo: String? = "-",
    var awayName: String? = "-",
    var awayRank: String? = "-",
    var awayRed: Int? = 0,
    var awayScore: Int? = 0,
    var awayYellow: Int? = 0,
    var explain: String? = "-",
    var extraExplainDao: ExtraExplainDao,
    var group: String? = "-",
    var halfStartTime: Int? = 0,
    var hasLineup: Boolean,
    var homeCorner: Int? = 0,
    var homeHalfScore: Int? = 0,
    var homeId: String? = "-",
    var homeLogo: String? = "-",
    var homeName: String? = "-",
    var homeRank: String? = "-",
    var homeRed: Int? = 0,
    var homeScore: Int? = 0,
    var homeYellow: Int? = 0,
    var leagueColor: String? = "-",
    var leagueId: String? = "-",
    var leagueName: String? = "-",
    var leagueShortName: String? = "-",
    var leagueType: Int? = 0,
    var location: String? = "-",
    var matchId: String? = "-",
    var matchTime: Int? = 0,
    var neutral: Boolean,
    var round: String? = "-",
    var season: String? = "-",
    var status: Int? = 0,
    var subLeagueId: String? = "-",
    var subLeagueName: String? = "-",
    var temperature: String? = "-",
    var weather: String? = "-"
)