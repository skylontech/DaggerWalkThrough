package com.example.daggerwalkthrough

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.daggerwalkthrough.objects.ImportantObject
import com.example.daggerwalkthrough.utils.log
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var importantObject: ImportantObject

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MainApplication).injector.inject(this)

        "Important object in MainActivity: $importantObject".log()
        importantObject.doSomeWork()
    }
}