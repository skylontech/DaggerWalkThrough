package com.example.daggerwalkthrough

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.daggerwalkthrough.storage.DataStore
import javax.inject.Inject
import javax.inject.Named

class LandingFragment : Fragment() {

    @Inject
    @Named("prefs")
    lateinit var dataStore: DataStore

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

        view.findViewById<Button>(R.id.btn_detail).setOnClickListener {
            startActivity(Intent(requireContext(), DetailActivity::class.java))
        }

        view.findViewById<Button>(R.id.btn_logOff).setOnClickListener {
            dataStore.saveInt(LoginFragment.IS_LOGGED_IN, LoginFragment.LOGGED_OFF)
        }
    }
}