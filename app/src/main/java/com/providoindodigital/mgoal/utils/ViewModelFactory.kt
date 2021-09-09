package com.providoindodigital.mgoal.utils

import android.annotation.SuppressLint
import android.app.Application
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.providoindodigital.mgoal.data.source.MainDataMatch
import com.providoindodigital.mgoal.funmatch.MatchViewModel

class ViewModelFactory private constructor(
    private val application: Application,
    private val mainDataMatch: MainDataMatch
) : ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>)= with(modelClass) {
        when{
            isAssignableFrom(MatchViewModel::class.java) ->
                MatchViewModel(application,mainDataMatch)
//            isAssignableFrom(RepoViewModel::class.java) ->
//                RepoViewModel(application, mainDataRepository)
            else ->
                throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }as T

    companion object {
        @SuppressLint("StaticFieldLeak")
        @Volatile private var INSTANCE: ViewModelFactory? = null

        fun getInstance(application: Application) =
            INSTANCE
                ?: synchronized(ViewModelFactory::class.java){
                    INSTANCE
                        ?: ViewModelFactory(
                            application, Injection.providedMainDataMatch(application.applicationContext))
                            .also { INSTANCE = it }
                }

        @VisibleForTesting
        fun destroyInstance(){
            INSTANCE = null
        }
    }
}