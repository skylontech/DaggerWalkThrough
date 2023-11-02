package com.example.daggerwalkthrough.di

import androidx.lifecycle.ViewModelProvider
import com.example.daggerwalkthrough.viewModel.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelFactoryModule {
    @Binds
    fun bindViewModelFactory(viewModelProviderFactory: ViewModelProviderFactory) : ViewModelProvider.Factory
}