package com.example.daggerwalkthrough.di

import com.example.daggerwalkthrough.DetailActivity
import com.example.daggerwalkthrough.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityModule {
    @ContributesAndroidInjector
    fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    fun contributeDetailActivity() : DetailActivity
}