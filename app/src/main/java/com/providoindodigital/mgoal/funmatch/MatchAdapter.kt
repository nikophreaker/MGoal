package com.providoindodigital.mgoal.funmatch

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.providoindodigital.mgoal.R
import com.providoindodigital.mgoal.data.MatchData
import com.providoindodigital.mgoal.databinding.ItemMatchBinding
import com.providoindodigital.mgoal.ui.base.MatchInfoActivity
import com.providoindodigital.mgoal.ui.base.MatchListActivity

class MatchAdapter(private var matchData: MutableList<MatchData>, private var matchViewModel: MatchViewModel) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), Filterable {
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
                matchViewModel.openMatch.value = datas.matchId // onClick match go to detail match
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

    override fun getFilter(): Filter {
        return object: Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                constraint?.let {
                    val constraintString = constraint.toString()
                    matchData = if(constraintString.isEmpty()) matchData
                    else {
                        val filteredList = arrayListOf<MatchData>()
                        for(match in matchData) {
                            if(match.leagueName!!.toLowerCase().contains(constraint)) filteredList.add(match)
                        }
                        matchData = filteredList
                        matchData
                    }
                }
                val filterResults = FilterResults()
                filterResults.values = matchData
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                matchData = results?.values as MutableList<MatchData>
                notifyDataSetChanged()
            }
        }
    }
}