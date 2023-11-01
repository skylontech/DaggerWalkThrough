package com.example.daggerwalkthrough

import android.app.Application
import com.example.daggerwalkthrough.di.ApplicationComponent
import com.example.daggerwalkthrough.di.DaggerApplicationComponent
import com.example.daggerwalkthrough.di.SharedPreferencesModule

class MainApplication : Application() {
    val injector: ApplicationComponent = DaggerApplicationComponent.builder()
        .sharedPreferencesModule(
            SharedPreferencesModule(application = this)
        ).build()
}