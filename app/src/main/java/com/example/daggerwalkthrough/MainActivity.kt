package com.example.daggerwalkthrough

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.daggerwalkthrough.objects.SharedPreferenceProvider
import com.example.daggerwalkthrough.storage.DataStore
import com.example.daggerwalkthrough.utils.log
import javax.inject.Inject
import javax.inject.Named

class MainActivity : AppCompatActivity(), LandingFragment.Observer {

    @Inject
    @Named("prefs")
    lateinit var dataStore: DataStore

    @Inject
    lateinit var setOfStings: Set<String>

    @Inject
    lateinit var mapOfStrings : Map<String, String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MainApplication).injector.inject(this)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, LandingFragment(), "landing")
            .commit()

        setOfStings.log()

        mapOfStrings.log()
    }

    override fun onLogout() {
        doLogin()
    }

    private fun doLogin() {
        if (dataStore.getInt(LoginFragment.IS_LOGGED_IN, LoginFragment.LOGGED_OFF) == LoginFragment.LOGGED_OFF) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, LoginFragment(), "login")
                .addToBackStack(null)
                .commit()
        }
    }
}