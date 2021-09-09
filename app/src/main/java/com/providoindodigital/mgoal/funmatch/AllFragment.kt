package com.providoindodigital.mgoal.funmatch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.providoindodigital.mgoal.databinding.FragmentAllBinding
import com.providoindodigital.mgoal.ui.base.MatchListActivity

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class AllFragment : Fragment() {
    private lateinit var viewBinding: FragmentAllBinding
    private lateinit var matchAdapter: MatchAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBinding = FragmentAllBinding.inflate(inflater, container,false).apply {
            vm = (activity as MatchListActivity).obtainViewModel()
        }
        return viewBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupRepo()
    }

    private fun setupRepo() {
        val viewModel = viewBinding.vm
        if(viewModel != null){
            matchAdapter = MatchAdapter(viewModel.matchDataList, viewModel)
            viewBinding.rvMatch.adapter = matchAdapter
        }
    }

    override fun onResume() {
        super.onResume()
        viewBinding.vm?.start()

    }

    companion object {
        fun newInstance() = AllFragment().apply {

        }
    }
}