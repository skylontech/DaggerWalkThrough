package com.example.daggerwalkthrough

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.daggerwalkthrough.objects.SharedPreferenceProvider
import com.example.daggerwalkthrough.utils.log
import javax.inject.Inject

class LandingFragment : Fragment() {

    @Inject
    lateinit var sharedPreferenceProvider: SharedPreferenceProvider

    private val sharedPreferences by lazy {
        sharedPreferenceProvider.preferences
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.landing_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity().application as MainApplication).injector.inject(this)

        val data = sharedPreferences.getInt(MainActivity.DATA_KEY, -1)
        "StoredData in fragment: $data".log()
        "sharedPreferenceProvider in fragment: $sharedPreferenceProvider".log()
    }
}