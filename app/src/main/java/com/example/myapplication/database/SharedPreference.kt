package com.example.myapplication.database

import android.content.Context
import com.example.myapplication.di.module.AdminPreference
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

/**
 * Shared preference
 * @constructor
 * <p>
 * Class handling normal data
 * </p>
 * @param context
 */
open class SharedPreference @Inject constructor(
    context: Context,
    prefer: String
) {

    /**
     * SetShared preference
     */
    private val sharedPreference = context.getSharedPreferences(prefer, Context.MODE_PRIVATE)


    fun getString(key: String): String? {
        return sharedPreference.getString(key, "")
    }

    fun putString(key: String, value: String) {
        sharedPreference.edit().putString(key, value).apply()
    }

}