package com.example.daggerwalkthrough.di

import android.app.Application
import com.example.daggerwalkthrough.objects.SharedPreferenceProvider
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet
import dagger.multibindings.StringKey
import javax.inject.Singleton

@Module
class SharedPreferencesModule {

    @Provides
    @Singleton
    fun provideSharedPreferenceProvider(application: Application) : SharedPreferenceProvider {
        return SharedPreferenceProvider(application)
    }

    @Provides
    @IntoSet
    fun provideStringOne() = "one"

    @Provides
    @IntoSet
    fun provideStringTwo() = "two"

    @Provides
    @StringKey("a")
    @IntoMap
    fun provideStringA() = "A"

    @Provides
    @StringKey("b")
    @IntoMap
    fun provideStringB() = "B"
}