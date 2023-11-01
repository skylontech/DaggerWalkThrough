package com.example.daggerwalkthrough

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.daggerwalkthrough.objects.DetailObject
import com.example.daggerwalkthrough.utils.log
import javax.inject.Inject

class DetailActivity : AppCompatActivity() {

    @Inject
    lateinit var detailObject: DetailObject

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        (application as MainApplication).injector.inject(this)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, DetailFragment(), "detail")
            .commit()

        "detailObject in DetailActivity: $detailObject".log()
    }
}