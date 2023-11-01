package com.example.daggerwalkthrough.di

import com.example.daggerwalkthrough.LandingFragment
import com.example.daggerwalkthrough.MainActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = [
    SharedPreferencesModule::class
])
@Singleton
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)

    fun inject(landingFragment: LandingFragment)
}