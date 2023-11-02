package com.example.daggerwalkthrough

import com.example.daggerwalkthrough.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MainApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.factory().create(this)
    }

//    val injector: ApplicationComponent = DaggerApplicationComponent.factory().create(this)
}