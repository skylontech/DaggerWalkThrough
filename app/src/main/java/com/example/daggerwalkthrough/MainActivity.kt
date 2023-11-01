package com.example.daggerwalkthrough

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.daggerwalkthrough.objects.SharedPreferenceProvider
import com.example.daggerwalkthrough.utils.log
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    companion object {
        private const val DATA_KEY = "data"
    }

    @Inject
    lateinit var sharedPreferenceProvider: SharedPreferenceProvider

    private val sharedPreferences by lazy {
        sharedPreferenceProvider.preferences
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MainApplication).injector.inject(this)

        val storedData = sharedPreferences.getInt(DATA_KEY, -1)
        "storedData: $storedData".log()
        if (storedData == -1) {
            sharedPreferences.edit().putInt(DATA_KEY, 10).apply()
            "storedValue updated to 10".log()
        }
    }
}