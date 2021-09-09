package com.providoindodigital.mgoal.funmatch

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
}