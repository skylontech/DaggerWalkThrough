package com.example.daggerwalkthrough.di

import androidx.lifecycle.ViewModel
import com.example.daggerwalkthrough.viewModel.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {
    @Binds
    @ViewModelKey(LoginViewModel::class)
    @IntoMap
    abstract fun bindLoginViewModel(loginViewModel: LoginViewModel) : ViewModel
}