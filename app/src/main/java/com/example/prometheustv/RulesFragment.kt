package com.example.prometheustv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class RulesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_rules, container, false)

        val title = view.findViewById<TextView>(R.id.about_title)
        val description = view.findViewById<TextView>(R.id.about_description)
        val image = view.findViewById<ImageView>(R.id.about_image)

        title.text = "Reglas de la casa"
        description.text = "Estas son tus reglas"
        image.setImageResource(R.drawable.cardview)

        return view
    }
}
