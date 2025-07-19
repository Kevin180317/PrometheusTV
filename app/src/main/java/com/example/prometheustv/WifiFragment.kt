package com.example.prometheustv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment

class WifiFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_wifi, container, false)

        val image = view.findViewById<ImageView>(R.id.wifi_image)
        image.setImageResource(R.drawable.wifi_image)

        return view
    }
}
