package com.example.daggerwalkthrough

import android.app.Application

class MainApplication : Application() {
    val injector: ApplicationComponent = DaggerApplicationComponent.create()
}