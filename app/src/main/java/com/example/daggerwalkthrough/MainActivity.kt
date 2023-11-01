package com.example.daggerwalkthrough

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.daggerwalkthrough.objects.Car
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var car: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MainApplication).injector.inject(this)

        car.start()
        car.drive()
        car.turnOff()
    }
}