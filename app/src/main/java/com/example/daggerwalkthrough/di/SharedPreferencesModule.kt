package com.example.daggerwalkthrough.di

import android.app.Application
import com.example.daggerwalkthrough.objects.SharedPreferenceProvider
import dagger.Module
import dagger.Provides

@Module
class SharedPreferencesModule(private val application: Application) {

    @Provides
    fun provideSharedPreferenceProvider() : SharedPreferenceProvider {
        return SharedPreferenceProvider(application)
    }
}