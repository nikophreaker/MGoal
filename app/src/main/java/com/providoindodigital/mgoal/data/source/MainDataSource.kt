package com.providoindodigital.mgoal.data.source

import com.providoindodigital.mgoal.data.MatchData

interface MainDataSource {
//    fun getMainData(callback: GetMainDataCallback)
    fun getMatchData(callback: GetMatchDataCallback)

//    interface GetMainDataCallback{
//        fun onDataLoaded(mainData: MainData?)
//        fun onNotAvailable()
//        fun onError(msg: String?)
//    }

    interface GetMatchDataCallback{
        fun onDataLoaded(matchData: MutableList<MatchData?>)
        fun onNotAvailable()
        fun onError(msg: String?)
    }
}