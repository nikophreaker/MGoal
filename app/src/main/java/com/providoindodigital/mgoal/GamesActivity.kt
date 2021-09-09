package com.providoindodigital.mgoal

import android.os.Bundle
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.Window

import android.view.WindowManager
import com.providoindodigital.mgoal.databinding.ActivityGamesBinding


class GamesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGamesBinding
    private var mWebView: WebView? = null
    private val GAME_URL = "http://192.168.1.15/games/index.html"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //requestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = ActivityGamesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        mWebView = findViewById(R.id.game_canva)
        val webSettings = mWebView?.settings
        webSettings?.javaScriptEnabled = true
        webSettings?.domStorageEnabled = true
        webSettings?.databaseEnabled = true
        webSettings?.pluginState = WebSettings.PluginState.ON
        webSettings?.allowFileAccess = true
        webSettings?.allowContentAccess = true
        webSettings?.allowFileAccessFromFileURLs = true
        webSettings?.allowUniversalAccessFromFileURLs = true
        webSettings?.useWideViewPort = true
        mWebView?.webViewClient = AppWebViewClient()
//        val imeManager =
//            applicationContext.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
//        imeManager.showInputMethodPicker()
    }

    override fun onResume() {
        mWebView?.loadUrl(GAME_URL)
        super.onResume()
    }

    override fun onBackPressed() {
        if (mWebView?.canGoBack() == true) {
            mWebView?.goBack()
        } else {
            super.onBackPressed()
        }
    }
}