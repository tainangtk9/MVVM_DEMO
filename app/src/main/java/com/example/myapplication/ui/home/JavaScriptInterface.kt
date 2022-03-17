package com.example.myapplication.ui.home

import android.content.Context
import android.webkit.JavascriptInterface
import android.widget.Toast


class JavaScriptInterface internal constructor(c: Context) {
    var mContext: Context = c

    @get:JavascriptInterface
    val fromAndroid: String
        get() = "This is from android."

    @JavascriptInterface
    fun Add(a: Int, b: Int): Int {
        val tong = a + b
        return tong
    }

}