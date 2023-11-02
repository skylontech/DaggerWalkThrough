package com.example.daggerwalkthrough

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.daggerwalkthrough.storage.DataStore
import com.example.daggerwalkthrough.viewModel.LoginViewModel
import javax.inject.Inject
import javax.inject.Named

class MainActivity : AppCompatActivity() {

    @Inject
    @Named("prefs")
    lateinit var dataStore: DataStore

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MainApplication).injector.inject(this)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, LandingFragment(), "landing")
            .commit()

        val viewModel = ViewModelProvider(this, viewModelFactory)[LoginViewModel::class.java]
        viewModel.isLoggedIn.observe(this) {
            if (it) {
                supportFragmentManager.popBackStack()
            } else {
                doLogin()
            }
        }
    }

    private fun doLogin() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, LoginFragment(), "login")
            .addToBackStack(null)
            .commit()
    }
}