package com.example.prometheustv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class WifiFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_wifi, container, false)

        val title = view.findViewById<TextView>(R.id.wifi_title)
        val wifi = view.findViewById<ImageView>(R.id.wifi_connection)
        val image = view.findViewById<ImageView>(R.id.wifi_image)

        image.setImageResource(R.drawable.wifibanner)
        title.text = "WIFI"
        wifi.setImageResource(R.drawable.wifi)
        return view
    }
}
