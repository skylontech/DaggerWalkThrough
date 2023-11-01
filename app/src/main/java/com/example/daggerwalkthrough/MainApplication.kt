package com.example.daggerwalkthrough

import android.app.Application
import com.example.daggerwalkthrough.di.ApplicationComponent
import com.example.daggerwalkthrough.di.DaggerApplicationComponent

class MainApplication : Application() {
    val injector: ApplicationComponent = DaggerApplicationComponent.create()
}