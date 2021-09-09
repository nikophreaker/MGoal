package com.providoindodigital.mgoal.api

import com.providoindodigital.mgoal.api.dao.MatchDao
import com.providoindodigital.mgoal.api.dao.MatchDataDao
import com.providoindodigital.mgoal.utils.Constant
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("livescores")
    fun getMatchData(
        @Query("api_key") api_key: String
    ): Observable<MatchDao>

//    @GET("https://mgoalindo.com/match2/{api_league}")
//    fun getMatchData(
//        @Path("api_league") api_league: String
//    ): Observable<List<Match>>

    companion object Factory {

        fun create():ApiService{

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(
                    RxJava2CallAdapterFactory.create())
                .addConverterFactory(
                    GsonConverterFactory.create())
                .baseUrl(Constant.BASE_URL)
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}