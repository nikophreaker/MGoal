package com.providoindodigital.mgoal.api

import com.providoindodigital.mgoal.api.dao.MatchDao
import com.providoindodigital.mgoal.api.dao.MatchDataDao
import com.providoindodigital.mgoal.api.dao.TokenDao
import com.providoindodigital.mgoal.utils.Constant
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.MultipartBody

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*


interface ApiService {

//    @GET("https://mgoalindo.com/match2/{api_league}")
//    fun getMatchData(
//        @Path("api_league") api_league: String
//    ): Observable<List<Match>>

    @FormUrlEncoded
    @POST("login")
    fun getToken(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<ResponseBody>

    @GET("mscore")
    fun getMatchData(
        @Header("Authorization") tokenBearer: String
    ): Observable<MatchDao>


    companion object Factory {

        fun create():ApiService{

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(
                    RxJava2CallAdapterFactory.create())
                .addConverterFactory(
                    GsonConverterFactory.create())
                .baseUrl(Constant.BASE_URL2)
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}