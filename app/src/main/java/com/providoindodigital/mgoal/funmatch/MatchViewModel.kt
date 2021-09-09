package com.providoindodigital.mgoal.funmatch

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.lifecycle.AndroidViewModel
import com.providoindodigital.mgoal.data.MatchData
import com.providoindodigital.mgoal.data.source.MainDataMatch
import com.providoindodigital.mgoal.data.source.MainDataSource
import com.providoindodigital.mgoal.utils.SingleLiveEvent

class MatchViewModel (application: Application, private val mainDataMatch: MainDataMatch) : AndroidViewModel(application){
    val matchDataList: ObservableList<MatchData> = ObservableArrayList()
    internal val openMatch = SingleLiveEvent<String>()

    fun start() {
        getMatch()
    }

//    fun openMatch(){
//        openMatch.value = matchList.get()
//    }

    private fun getMatch(){
        mainDataMatch.getMatchData(object : MainDataSource.GetMatchDataCallback{
            override fun onDataLoaded(matchData: MutableList<MatchData?>) {
                with(matchDataList){
                    clear()
                    addAll(matchData)
                }
            }

            override fun onNotAvailable() {
                Toast.makeText(getApplication(),"No Data Found", Toast.LENGTH_SHORT).show()
            }

            override fun onError(msg: String?) {
                Toast.makeText(getApplication(),"Error at - $msg", Toast.LENGTH_SHORT).show()
                if (msg != null) {
                    Log.e("RETROFIT_ERROR - ", msg)
                }
            }
        })
    }
}