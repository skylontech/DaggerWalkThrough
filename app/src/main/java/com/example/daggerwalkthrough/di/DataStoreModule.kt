package com.example.daggerwalkthrough.di

import android.app.Application
import com.example.daggerwalkthrough.storage.DataStore
import com.example.daggerwalkthrough.storage.impl.SharedPreferenceDataStore
import dagger.Binds
import dagger.Module

@Module
abstract class DataStoreModule {

    @Binds
    abstract fun bindsSharedPreferenceDataStore(sharedPreferenceDataStore: SharedPreferenceDataStore) : DataStore
}