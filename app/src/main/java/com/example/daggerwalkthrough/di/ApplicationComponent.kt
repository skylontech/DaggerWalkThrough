package com.example.daggerwalkthrough.di

import com.example.daggerwalkthrough.MainActivity
import dagger.Component

@Component
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
}