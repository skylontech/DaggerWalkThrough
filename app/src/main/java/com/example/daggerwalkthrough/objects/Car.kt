package com.example.daggerwalkthrough.objects

import com.example.daggerwalkthrough.utils.log
import javax.inject.Inject

class Car @Inject constructor(
    private val engine: Engine?,
    private val seat1: Seat?,
    private val seat2: Seat?,
    private val seat3: Seat?,
    private val seat4: Seat?,
) {
    private var started: Boolean = false
    fun start() {
        if (engine == null) {
            "Car missing engine".log()
        } else {
            started = true
            "Car has started".log()
        }
    }

    fun drive() {
        if (!started) {
            "You need to start the car first".log()
        } else if (seat1 == null && seat2 == null && seat3 == null && seat4 == null) {
            "Cannot drive without seats".log()
        } else {
            "Car is now driving".log()
        }
    }

    fun turnOff() {
        if (engine == null) {
            "Car missing engine".log()
        }
        if (!started) {
            "Car is already off".log()
        } else {
            started = false
            "Car has been turned off".log()
        }

    }
}