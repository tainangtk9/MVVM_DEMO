package com.example.myapplication.ui.home

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView

import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.webkit.WebViewAssetLoader
import androidx.webkit.WebViewClientCompat
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityHomeBinding
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {
    private val TAG = HomeActivity::class.java.name
    private val homeViewModel: HomeViewModel by viewModels()
    private var binding: ActivityHomeBinding? = null

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding?.webView?.settings?.javaScriptEnabled = true;
        binding?.webView?.settings?.domStorageEnabled = true;
        binding?.webView?.loadUrl("file:///android_asset/index.html")
        binding?.webView?.addJavascriptInterface(JavaScriptInterface(this), "Android")
        getUsers()
    }

    private fun getUsers() {
        lifecycleScope.launch {
            homeViewModel.getUsers()
            homeViewModel.userPagingLiveData.observe(this@HomeActivity, {
            })
        }

    }
}

private class LocalContentWebViewClient(private val assetLoader: WebViewAssetLoader) :
    WebViewClientCompat() {
    @RequiresApi(21)
    override fun shouldInterceptRequest(
        view: WebView,
        request: WebResourceRequest
    ): WebResourceResponse? {
        return assetLoader.shouldInterceptRequest(request.url)
    }

    // to support API < 21
    override fun shouldInterceptRequest(
        view: WebView,
        url: String
    ): WebResourceResponse? {
        return assetLoader.shouldInterceptRequest(Uri.parse(url))
    }
}