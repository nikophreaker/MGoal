package com.providoindodigital.mgoal.data.source.local

import android.content.SharedPreferences
import androidx.annotation.VisibleForTesting
import com.providoindodigital.mgoal.data.source.MainDataSource

class MainDataLocalSource  private constructor(private val preferences: SharedPreferences) :
    MainDataSource {
    override fun getMatchData(callback: MainDataSource.GetMatchDataCallback) {

    }

//    override fun getMainData(callback: MainDataSource.GetMainDataCallback) {
//
//    }

    companion object {
        private var INSTANCE: MainDataLocalSource? = null
        @JvmStatic
        fun getInstance(preferences: SharedPreferences) : MainDataLocalSource?{
            if (INSTANCE == null){
                synchronized(MainDataLocalSource::class.java){
                    INSTANCE = MainDataLocalSource(preferences)
                }
            }
            return INSTANCE
        }

        @VisibleForTesting
        fun clearInstance(){
            INSTANCE = null
        }
    }
}