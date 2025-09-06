package com.example.prometheustv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment

class ActivitiesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_mazatlan, container, false)

        val image = view.findViewById<ImageView>(R.id.mazatlan_image)
        image.setImageResource(R.drawable.dt_que_hacer_inside)

        return view
    }
}
