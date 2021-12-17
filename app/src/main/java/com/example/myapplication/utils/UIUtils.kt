package com.example.myapplication.utils

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.databinding.BindingAdapter

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}
object BindingAdapters{

    @BindingAdapter("app:hideProgressBar",requireAll = false)
    @JvmStatic
    fun hideIfZero(view: View, isShow: Boolean) {
        view.visibility = if (!isShow) View.GONE else View.VISIBLE
    }

}
