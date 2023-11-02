package com.example.daggerwalkthrough

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.daggerwalkthrough.objects.DetailObject
import com.example.daggerwalkthrough.utils.log
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class DetailActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var detailObject: DetailObject

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        "detailObject in DetailActivity: $detailObject".log()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, DetailFragment(), "detail")
            .commit()
    }
}