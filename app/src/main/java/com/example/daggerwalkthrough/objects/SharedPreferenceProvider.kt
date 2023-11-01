package com.example.daggerwalkthrough.objects

import android.app.Application
import android.content.Context

class SharedPreferenceProvider constructor(application: Application) {

    val preferences = application.getSharedPreferences("appPrefs", Context.MODE_PRIVATE)

}