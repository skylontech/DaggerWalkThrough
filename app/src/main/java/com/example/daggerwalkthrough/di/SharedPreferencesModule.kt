package com.example.daggerwalkthrough.di

import android.app.Application
import com.example.daggerwalkthrough.objects.SharedPreferenceProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SharedPreferencesModule {

    @Provides
    @Singleton
    fun provideSharedPreferenceProvider(application: Application) : SharedPreferenceProvider {
        return SharedPreferenceProvider(application)
    }
}