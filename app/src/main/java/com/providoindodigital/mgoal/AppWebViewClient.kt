package com.providoindodigital.mgoal

import android.content.Intent
import android.net.Uri
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

class AppWebViewClient : WebViewClient() {
    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
        if(Uri.parse(url).host?.length  == 0) {
            return false
        }

        val i = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        view?.context?.startActivity(i)
        return true
    }
}