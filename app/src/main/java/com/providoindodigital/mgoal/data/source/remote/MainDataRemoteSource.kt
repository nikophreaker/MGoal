package com.providoindodigital.mgoal.data.source.remote

import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.providoindodigital.mgoal.api.ApiService
import com.providoindodigital.mgoal.api.dao.MatchDao
import com.providoindodigital.mgoal.api.dao.MatchDataDao
import com.providoindodigital.mgoal.data.Match
import com.providoindodigital.mgoal.data.MatchData
import com.providoindodigital.mgoal.data.TokenData
import com.providoindodigital.mgoal.data.source.MainDataSource
import com.providoindodigital.mgoal.data.source.remote.MainDataRemoteSource.apiService
import com.providoindodigital.mgoal.ui.base.MainActivity
import com.providoindodigital.mgoal.ui.base.MatchListActivity
import com.providoindodigital.mgoal.utils.Constant
import com.providoindodigital.mgoal.utils.SessionManagerUtil
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response

object MainDataRemoteSource : MainDataSource {

    private val apiService = ApiService.create()
    //private val matchListActivity: MatchListActivity = MatchListActivity()
    private var token: String? = "-"

//    override fun getTokenData(callback: MainDataSource.GetTokenCallback) {
//        val mediaType = "text/plain".toMediaType()
//        val email: RequestBody =
//            Constant.email.toRequestBody(mediaType)
//        val password: RequestBody =
//            Constant.password.toRequestBody(mediaType)
//        apiService.getToken(Constant.email, Constant.password)
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeOn(Schedulers.io())
//            .subscribe ({
//                run {
//                    if (it.token != "") {
//                        val tokenData = TokenData(it.token)
//                        Log.i("xx", " ${it.token}")
//                        callback.onDataLoaded(tokenData)
//                    } else {
//                        callback.onNotAvailable()
//                    }
//                }
//            }, {
//                callback.onError(it.message)
//            })
//    }

    override fun getMatchData(callback: MainDataSource.GetMatchDataCallback) {
        apiService.getMatchData("Bearer $token")
//            .flatMap{ getMatchDataResponse->
//                if(getMatchDataResponse.msg != "success") {
//                    fun getTokenData(email: RequestBody, password: RequestBody){
//                        apiService.getToken(email, password)
//                            .observeOn(AndroidSchedulers.mainThread())
//                            .subscribeOn(Schedulers.io())
//                            .subscribe ({
//                                run {
//                                    if (it.token != "") {
//                                        val tokenData = TokenData(it.token)
//                                        token = tokenData.token
//                                        Log.i("xx", " ${it.token}")
//                                        Observable.just(getMatchDataResponse)
//                                        SessionManagerUtil.startUserSession(matchListActivity.applicationContext, 1200) // starting session
//                                        SessionManagerUtil.storeUserToken(matchListActivity.applicationContext, token.toString())
//                                        SessionManagerUtil.storeUserEmail(matchListActivity.applicationContext, Constant.email)
//                                        SessionManagerUtil.storeUserPwd(matchListActivity.applicationContext, Constant.password)
//                                    } else {
//                                        Log.e("NOT FOUND","NO DATA")
//                                    }
//                                }
//                            }, {
//                            })
//                    }
//                    return@flatMap ObservableSource {
//                        getTokenData(email, password)
//                    }
//                } else {
//                    return@flatMap Observable.just(getMatchDataResponse)
//                }
//            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                run {

                    if (it?.matchDao!!.isNotEmpty()) {
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
                            //if(item.status == -1) {
                            matchDatas.add(matchData)
                            //}


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