package com.providoindodigital.mgoal.utils

import android.content.Context
import android.preference.PreferenceManager
import com.providoindodigital.mgoal.data.source.MainDataMatch
import com.providoindodigital.mgoal.data.source.local.MainDataLocalSource
import com.providoindodigital.mgoal.data.source.remote.MainDataRemoteSource

object Injection {
    fun providedMainDataMatch(context: Context) = MainDataMatch.getInstance(
        MainDataRemoteSource,
        MainDataLocalSource.getInstance(PreferenceManager.getDefaultSharedPreferences(context))!!)
}