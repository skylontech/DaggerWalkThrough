package com.example.daggerwalkthrough

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.daggerwalkthrough.objects.SharedPreferenceProvider
import com.example.daggerwalkthrough.storage.DataStore
import com.example.daggerwalkthrough.utils.log
import javax.inject.Inject
import javax.inject.Named

class MainActivity : AppCompatActivity() {

    @Inject
    @Named("prefs")
    lateinit var dataStore: DataStore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MainApplication).injector.inject(this)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, LandingFragment(), "landing")
            .commit()

        if (dataStore.getInt(LoginFragment.IS_LOGGED_IN, LoginFragment.LOGGED_OFF) == LoginFragment.LOGGED_OFF) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, LoginFragment(), "login")
                .addToBackStack(null)
                .commit()
        }
    }
}