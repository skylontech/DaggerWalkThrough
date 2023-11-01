package com.example.daggerwalkthrough.storage

interface DataStore {

    fun getInt(key: String, defaultValue: Int) : Int

    fun saveInt(key: String, value: Int)
}