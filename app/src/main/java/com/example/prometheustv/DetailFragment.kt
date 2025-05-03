package com.example.prometheustv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail_router, container, false)

        val title = arguments?.getString("TITLE")

        val targetFragment = when (title) {
            "Acerca de nosotros" -> AboutFragment()
            "WIFI" -> WifiFragment()
            "Conoce a tu host" -> HostFragment()
            "Check in & Check out" -> CheckInFragment()
            "Reglas de la casa" -> RulesFragment()
            "CheckList de salida" -> ChecklistFragment()
            "Que puedo hacer en Mazatlán?" -> ActivitiesFragment()
            "Restaurantes" -> RestaurantsFragment()
            "Bares" -> BarsFragment()
            else -> null
        }

        childFragmentManager.beginTransaction()
            .replace(R.id.inner_fragment_container, targetFragment as Fragment)
            .commit()

        return view
    }
}
