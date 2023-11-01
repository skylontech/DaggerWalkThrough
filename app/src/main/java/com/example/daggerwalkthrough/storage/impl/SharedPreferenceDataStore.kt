package com.example.daggerwalkthrough.storage.impl

import android.app.Application
import android.content.Context
import com.example.daggerwalkthrough.storage.DataStore
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPreferenceDataStore @Inject constructor(
    application: Application
): DataStore {

    private val preferences = application.getSharedPreferences("appDataStore", Context.MODE_PRIVATE)

    override fun getInt(key: String, defaultValue: Int) : Int {
        return preferences.getInt(key, defaultValue)
    }

    override fun saveInt(key: String, value: Int) {
        preferences.edit().putInt(key, value).apply()
    }
}