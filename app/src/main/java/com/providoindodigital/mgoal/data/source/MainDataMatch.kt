package com.providoindodigital.mgoal.data.source

import com.providoindodigital.mgoal.data.MatchData
import com.providoindodigital.mgoal.data.TokenData
import com.providoindodigital.mgoal.data.source.local.MainDataLocalSource

class MainDataMatch(
    val remoteDataSource: MainDataSource,
    val localDataSource: MainDataSource
) : MainDataSource {

//    override fun getTokenData(callback: MainDataSource.GetTokenCallback){
//        remoteDataSource.getTokenData(object: MainDataSource.GetTokenCallback{
//            override fun onNotAvailable() {
//                callback.onNotAvailable()
//            }
//
//            override fun onError(msg: String?) {
//                callback.onError(msg)
//            }
//
//            override fun onDataLoaded(token: TokenData?) {
//                callback.onDataLoaded(token)
//            }
//        })
//    }

    override fun getMatchData(callback: MainDataSource.GetMatchDataCallback) {
        remoteDataSource.getMatchData(object : MainDataSource.GetMatchDataCallback {
            override fun onNotAvailable() {
                callback.onNotAvailable()
            }

            override fun onError(msg: String?) {
                callback.onError(msg)
            }

            override fun onDataLoaded(matchData: MutableList<MatchData?>) {
                callback.onDataLoaded(matchData)
            }
        })
    }



    companion object {
        private var INSTANCE: MainDataMatch? = null

        @JvmStatic
        fun getInstance(
            mainDataRemoteSource: MainDataSource,
            newsLocalDataSource: MainDataLocalSource
        ) =
            INSTANCE ?: synchronized(MainDataMatch::class.java) {
                INSTANCE ?: MainDataMatch(mainDataRemoteSource, mainDataRemoteSource)
                    .also { INSTANCE = it }

            }

        @JvmStatic
        fun destroyInstance() {
            INSTANCE = null
        }
    }
}