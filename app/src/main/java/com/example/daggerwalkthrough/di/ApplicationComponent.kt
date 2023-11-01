package com.example.daggerwalkthrough.di

import com.example.daggerwalkthrough.MainActivity
import dagger.Component

@Component(modules = [
    SharedPreferencesModule::class
])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
}