package com.example.daggerwalkthrough.di

import com.example.daggerwalkthrough.DetailFragment
import com.example.daggerwalkthrough.LandingFragment
import com.example.daggerwalkthrough.LoginFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentModule {
    @ContributesAndroidInjector
    fun contributeLoginFragment(): LoginFragment

    @ContributesAndroidInjector
    fun contributeLandingFragment(): LandingFragment

    @ContributesAndroidInjector
    fun contributeDetailFragment(): DetailFragment
}