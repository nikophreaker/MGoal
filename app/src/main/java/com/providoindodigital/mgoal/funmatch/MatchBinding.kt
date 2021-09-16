package com.providoindodigital.mgoal.funmatch

import android.widget.EditText
import android.widget.SearchView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.providoindodigital.mgoal.data.MatchData

object MatchBinding {
    @BindingAdapter("app:matchList")
    @JvmStatic
    fun setMatchList(recyclerView: RecyclerView, matchData: MutableList<MatchData>) {
        with(recyclerView.adapter as MatchAdapter){
            replaceData(matchData)
        }
    }

//    @BindingAdapter("app:getText")
//    @JvmStatic
//    fun getText(text: EditText) {
//        text.text
//    }

    @BindingAdapter("queryTextListener")
    @JvmStatic
    fun setOnQueryTextListener(searchView: SearchView, listener:SearchView.OnQueryTextListener) {
        searchView.setOnQueryTextListener(listener)
    }

}