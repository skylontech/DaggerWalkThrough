package com.example.daggerwalkthrough.storage.impl

import com.example.daggerwalkthrough.storage.DataStore
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FileDataSource @Inject constructor(): DataStore {

    override fun getInt(key: String, defaultValue: Int): Int {
        return defaultValue
    }

    override fun saveInt(key: String, value: Int) {

    }
}