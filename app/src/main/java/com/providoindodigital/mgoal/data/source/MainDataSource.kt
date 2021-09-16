package com.providoindodigital.mgoal.data.source

import com.providoindodigital.mgoal.data.MatchData
import com.providoindodigital.mgoal.data.TokenData

interface MainDataSource {
//    fun getTokenData(callback: GetTokenCallback)
    fun getMatchData(callback: GetMatchDataCallback)

    //    interface GetMainDataCallback{
//        fun onDataLoaded(mainData: MainData?)
//        fun onNotAvailable()
//        fun onError(msg: String?)
//    }

//    interface GetTokenCallback {
//        fun onDataLoaded(token: TokenData?)
//        fun onNotAvailable()
//        fun onError(msg: String?)
//    }

    interface GetMatchDataCallback {
        fun onDataLoaded(matchData: MutableList<MatchData?>)
        fun onNotAvailable()
        fun onError(msg: String?)
    }
}