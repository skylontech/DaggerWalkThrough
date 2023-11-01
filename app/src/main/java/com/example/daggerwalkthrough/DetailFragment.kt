package com.example.daggerwalkthrough

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.daggerwalkthrough.objects.DetailObject
import com.example.daggerwalkthrough.objects.SharedPreferenceProvider
import com.example.daggerwalkthrough.utils.log
import javax.inject.Inject

class DetailFragment : Fragment() {

    @Inject
    lateinit var sharedPreferenceProvider: SharedPreferenceProvider

    @Inject
    lateinit var detailObject: DetailObject

    private val sharedPreferences by lazy {
        sharedPreferenceProvider.preferences
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity().application as MainApplication).injector.inject(this)

        val data = sharedPreferences.getInt(MainActivity.DATA_KEY, -1)

        "StoredData in DetailFragment: $data".log()

        "sharedPreferenceProvider in DetailFragment: $sharedPreferenceProvider".log()

        "detailObject in DetailFragment: $detailObject".log()
    }
}