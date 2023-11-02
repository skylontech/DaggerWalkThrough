package com.example.daggerwalkthrough

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.daggerwalkthrough.storage.DataStore
import javax.inject.Inject
import javax.inject.Named

class LoginFragment : Fragment() {

    companion object {
        const val IS_LOGGED_IN = "isLoggedIn"
        const val LOGGED_IN = 1
        const val LOGGED_OFF = 0
    }

    @Inject
    @Named("prefs")
    lateinit var dataStore: DataStore

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity().application as MainApplication).injector.inject(this)

        view.findViewById<Button>(R.id.btn_login).setOnClickListener {
            dataStore.saveInt(IS_LOGGED_IN, LOGGED_IN)
            parentFragmentManager.popBackStack()
        }
    }
}