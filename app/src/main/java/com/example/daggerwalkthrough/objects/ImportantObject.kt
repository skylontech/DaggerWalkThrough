package com.example.daggerwalkthrough.objects

import com.example.daggerwalkthrough.utils.log
import javax.inject.Inject

class ImportantObject @Inject constructor() {
    fun doSomeWork() {
        "Important object did some work".log()
    }
}