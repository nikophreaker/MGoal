package com.providoindodigital.mgoal.data.source.remote

import android.util.Log
import com.providoindodigital.mgoal.api.ApiService
import com.providoindodigital.mgoal.api.dao.MatchDao
import com.providoindodigital.mgoal.api.dao.MatchDataDao
import com.providoindodigital.mgoal.data.Match
import com.providoindodigital.mgoal.data.MatchData
import com.providoindodigital.mgoal.data.source.MainDataSource
import com.providoindodigital.mgoal.utils.Constant
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.internal.notifyAll

object MainDataRemoteSource : MainDataSource {

    private val apiService = ApiService.create()

    override fun getMatchData(callback: MainDataSource.GetMatchDataCallback) {
        apiService.getMatchData(Constant.api_key)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                run {

                    if (it.matchDao.isNotEmpty()) {
                        Log.i("xx", " ${it.matchDao.size}")

                        val listMatch: MutableList<Match?> = mutableListOf()
                        val matchDatas: MutableList<MatchData?> = mutableListOf()
                        for (item: MatchDataDao in it.matchDao) {
                            Log.i("xx", " -- ${item.leagueName}")
                            val matchData = MatchData(
                                item.awayCorner,
                                item.awayHalfScore,
                                item.awayId,
                                item.awayLogo,
                                item.awayName,
                                item.awayRank,
                                item.awayRed,
                                item.awayScore,
                                item.awayYellow,
                                item.explain,
                                item.extraExplainDao,
                                item.group,
                                item.halfStartTime,
                                item.hasLineup,
                                item.homeCorner,
                                item.homeHalfScore,
                                item.homeId,
                                item.homeLogo,
                                item.homeName,
                                item.homeRank,
                                item.homeRed,
                                item.homeScore,
                                item.homeYellow,
                                item.leagueColor,
                                item.leagueId,
                                item.leagueName,
                                item.leagueShortName,
                                item.leagueType,
                                item.location,
                                item.matchId,
                                item.matchTime,
                                item.neutral,
                                item.round,
                                item.season,
                                item.status,
                                item.subLeagueId,
                                item.subLeagueName,
                                item.temperature,
                                item.weather
                            )
                            if(item.status == -1) {
                                matchDatas.add(matchData)
                            }


                        }

                        callback.onDataLoaded(matchDatas)
                    } else {
                        callback.onNotAvailable()
                    }

                }
            }, {
                callback.onError(it.message)
            })
    }
}