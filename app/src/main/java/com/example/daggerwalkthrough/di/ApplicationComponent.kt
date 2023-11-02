package com.example.daggerwalkthrough.di

import android.app.Application
import com.example.daggerwalkthrough.MainApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityModule::class,
        FragmentModule::class,
        SharedPreferencesModule::class,
        DataStoreModule::class,
        ViewModelFactoryModule::class,
        ViewModelModule::class
    ]
)
@Singleton
interface ApplicationComponent : AndroidInjector<MainApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): ApplicationComponent
    }
}