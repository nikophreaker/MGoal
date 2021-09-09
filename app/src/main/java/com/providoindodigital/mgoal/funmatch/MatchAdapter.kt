package com.providoindodigital.mgoal.funmatch

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.providoindodigital.mgoal.R
import com.providoindodigital.mgoal.data.MatchData
import com.providoindodigital.mgoal.databinding.ItemMatchBinding

class MatchAdapter(private var matchData: MutableList<MatchData>, private var matchViewModel: MatchViewModel) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val matchItemBinding : ItemMatchBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.item_match,parent,false)
        return MatchHolder(matchItemBinding)
    }

    override fun getItemCount(): Int = matchData.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val datas = matchData[position]
        val actionListener = object : MatchsItemActionListener{
            override fun onMatchClicked() {
                //matchViewModel.openRepo.value = datas.url // onClick match go to detail match
            }


        }
        (holder as MatchHolder).bindRows(datas, actionListener)
    }

    fun replaceData(matchData: MutableList<MatchData>){
        setList(matchData)
    }

    fun setList(matchData: MutableList<MatchData>){
        this.matchData = matchData
        notifyDataSetChanged()
    }

    class MatchHolder(binding: ItemMatchBinding) : RecyclerView.ViewHolder(binding.root){
        val matchItemBinding = binding

        fun bindRows(matchData: MatchData, userActionListener: MatchsItemActionListener) {
            matchItemBinding.datas =  matchData
            matchItemBinding.action = userActionListener
            matchItemBinding.executePendingBindings()
        }
    }
}