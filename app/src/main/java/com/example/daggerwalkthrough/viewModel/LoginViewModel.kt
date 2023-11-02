package com.example.daggerwalkthrough.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.daggerwalkthrough.LoginFragment
import com.example.daggerwalkthrough.storage.DataStore
import javax.inject.Inject
import javax.inject.Named

class LoginViewModel @Inject constructor(
    @Named("prefs") private val dataStore: DataStore,
) : ViewModel() {

    companion object {
        const val IS_LOGGED_IN = "isLoggedIn"
        const val LOGGED_IN = 1
        const val LOGGED_OFF = 0
    }

    private val _isLoggedIn = MutableLiveData(
        dataStore.getInt(
            IS_LOGGED_IN,
            LOGGED_OFF
        ) == LOGGED_IN
    )
    val isLoggedIn: LiveData<Boolean> = _isLoggedIn

    fun logIn() {
        dataStore.saveInt(IS_LOGGED_IN, LOGGED_IN)
        _isLoggedIn.postValue(true)
    }

    fun logOff() {
        dataStore.saveInt(IS_LOGGED_IN, LOGGED_OFF)
        _isLoggedIn.postValue(false)
    }
}