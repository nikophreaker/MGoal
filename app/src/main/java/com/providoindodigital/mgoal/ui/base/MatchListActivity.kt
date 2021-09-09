package com.providoindodigital.mgoal.ui.base

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.providoindodigital.mgoal.R
import com.providoindodigital.mgoal.databinding.ActivityMatchListBinding
import com.providoindodigital.mgoal.funmatch.AllFragment
import com.providoindodigital.mgoal.funmatch.MatchViewModel
import com.providoindodigital.mgoal.funmatch.MyGamesFragment
import com.providoindodigital.mgoal.funmatch.PlayFragment
import com.providoindodigital.mgoal.ui.component.MatchFragmentAdapter
import com.providoindodigital.mgoal.utils.obtainViewModel

class MatchListActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMatchListBinding
    private lateinit var adapter: MatchFragmentAdapter
    private lateinit var mActivity: AppCompatActivity
    private lateinit var viewModel: MatchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMatchListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        adapter = MatchFragmentAdapter(supportFragmentManager)
        addFragToAdapt()
        mActivity = this
        setupViewModel()

    }

    private fun addFragToAdapt(){
        adapter.addFragment(AllFragment(),"All")
        adapter.addFragment(PlayFragment(),"In-Play")
        adapter.addFragment(MyGamesFragment(),"My Game")
        binding.matchListViewPager.adapter = adapter
        binding.matchListSlidingTab.setupWithViewPager(binding.matchListViewPager)
    }

    private fun setupViewModel() {
        viewModel = obtainViewModel().apply{
            openMatch.observe(this@MatchListActivity, Observer{
                onMatchClicked(it!!)
            })
        }
    }

//    private fun setupFragment() {
//        supportFragmentManager.findFragmentById(R.id)
//        RepoFragment.newInstance().let {
//            replaceFragmentInActivity(it, R.id.frameRepo)
//        }
//    }

    private fun onMatchClicked(url: String) {
        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        builder.setToolbarColor(ContextCompat.getColor(mActivity, R.color.white))
        customTabsIntent.launchUrl(mActivity, Uri.parse(url))
    }

    fun obtainViewModel(): MatchViewModel = obtainViewModel(MatchViewModel::class.java)
}