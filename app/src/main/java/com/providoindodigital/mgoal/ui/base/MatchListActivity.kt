package com.providoindodigital.mgoal.ui.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.providoindodigital.mgoal.data.TokenData
import com.providoindodigital.mgoal.data.source.remote.MainDataRemoteSource
import com.providoindodigital.mgoal.databinding.ActivityMatchListBinding
import com.providoindodigital.mgoal.funmatch.AllFragment
import com.providoindodigital.mgoal.funmatch.MatchViewModel
import com.providoindodigital.mgoal.funmatch.MyGamesFragment
import com.providoindodigital.mgoal.funmatch.PlayFragment
import com.providoindodigital.mgoal.ui.component.MatchFragmentAdapter
import com.providoindodigital.mgoal.utils.SessionManagerUtil
import com.providoindodigital.mgoal.utils.obtainViewModel

class MatchListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMatchListBinding
    private lateinit var adapter: MatchFragmentAdapter
    private lateinit var mActivity: AppCompatActivity
    private lateinit var viewModel: MatchViewModel
    private var tokenData: TokenData? = null
    private var context: Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMatchListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val bearerToken: String = SessionManagerUtil.getUserToken(this).toString()
        tokenData?.token = bearerToken


        adapter = MatchFragmentAdapter(supportFragmentManager)
        addFragToAdapt()
        mActivity = this
        setupViewModel()

        binding.matchListBtnScreen.setOnClickListener {
            //openDialog()
        }

    }

    private fun addFragToAdapt() {
        adapter.addFragment(AllFragment(), "All")
        adapter.addFragment(PlayFragment(), "In-Play")
        adapter.addFragment(MyGamesFragment(), "My Game")
        binding.matchListViewPager.adapter = adapter
        binding.matchListSlidingTab.setupWithViewPager(binding.matchListViewPager)
    }

    private fun setupViewModel() {
        viewModel = obtainViewModel().apply {
            openMatch.observe(this@MatchListActivity, Observer {
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

    private fun onMatchClicked(matchId: String) {
        //val builder = CustomTabsIntent.Builder()
        //val customTabsIntent = builder.build()
        val i = Intent(this, MatchInfoActivity::class.java).putExtra("matchId",matchId)
        startActivity(i)
        //builder.setToolbarColor(ContextCompat.getColor(mActivity, R.color.white))
        //customTabsIntent.launchUrl(mActivity, Uri.parse(url))
    }

    fun obtainViewModel(): MatchViewModel = obtainViewModel(MatchViewModel::class.java)

//    private fun openDialog() {
//        val fm: FragmentManager = supportFragmentManager
//        val matchBetDialog = MatchBetDialog()
//        matchBetDialog.show(fm, "")
//    }
}