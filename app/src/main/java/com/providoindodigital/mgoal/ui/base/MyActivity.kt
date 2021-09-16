package com.providoindodigital.mgoal.ui.base

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.facebook.*
import com.facebook.login.LoginManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.providoindodigital.mgoal.databinding.ActivityMyBinding
import com.providoindodigital.mgoal.utils.SessionManagerUtil
import com.scwang.smart.refresh.header.ClassicsHeader

class MyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMyBinding
    private var mGoogleSignInClient: GoogleSignInClient? = null

    override fun onCreate(savedInstanceBundle: Bundle?) {
        super.onCreate(savedInstanceBundle)
        binding = ActivityMyBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val profile: Profile
        val acct = GoogleSignIn.getLastSignedInAccount(this)
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
        if (acct != null) {
            val personName = acct.displayName
            binding.myTvName.text = personName
        } else if (isLoggedIn()) {
            profile = Profile.getCurrentProfile()
            binding.myTvName.text = profile.name
        }

        binding.myRefreshLayout.setRefreshHeader(ClassicsHeader(this))
        binding.myRefreshLayout.setOnRefreshListener { refreshlayout ->
            refreshlayout.finishRefresh(2000 /*,false*/) //传入false表示刷新失败
        }
        binding.ivSetting.setOnClickListener {
            if (isLoggedIn()) {
                SessionManagerUtil.endUserSession(this)
                LoginManager.getInstance().logOut()
                val intent = Intent(
                    this,
                    LoginActivity::class.java
                ).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)
                finish()
            } else {
                signOut()
                SessionManagerUtil.endUserSession(this)
            }
        }
        binding.btnBack.setOnClickListener {
            val i = Intent(
                this@MyActivity,
                MainActivity::class.java
            ).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(i)
            finish()
        }
    }

    private fun signOut() {
        mGoogleSignInClient!!.signOut().addOnCompleteListener(
            this
        ) { Toast.makeText(this@MyActivity, "Signed Out", Toast.LENGTH_LONG).show() }
        val intent = Intent(
            this,
            LoginActivity::class.java
        ).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent)
        finish()
    }

    private fun revokeAccess() {
        mGoogleSignInClient!!.revokeAccess()
            .addOnCompleteListener(this) {
                // Update your UI here
                val i = Intent(
                    this@MyActivity,
                    LoginActivity::class.java
                ).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(i)
                finish()
            }
    }

    fun isLoggedIn(): Boolean {
        val accessToken = AccessToken.getCurrentAccessToken()
        return accessToken != null && !accessToken.isExpired
    }
}