package com.example.daggerwalkthrough.di

import android.app.Application
import com.example.daggerwalkthrough.storage.DataStore
import com.example.daggerwalkthrough.storage.impl.FileDataSource
import com.example.daggerwalkthrough.storage.impl.SharedPreferenceDataStore
import dagger.Binds
import dagger.Module
import javax.inject.Named

@Module
abstract class DataStoreModule {

    @Binds
    @Named("prefs")
    abstract fun bindsSharedPreferenceDataStore(sharedPreferenceDataStore: SharedPreferenceDataStore) : DataStore

    @Binds
    @Named("file")
    abstract fun bindFileDataStore(fileDataSource: FileDataSource) : DataStore
}