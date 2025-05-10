package com.example.prometheustv

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class AboutFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_about, container, false)

        val title = view.findViewById<TextView>(R.id.about_title)
        val description = view.findViewById<TextView>(R.id.about_description)
        val image = view.findViewById<ImageView>(R.id.about_image)
        val asidetext = view.findViewById<TextView>(R.id.aside_text)
        title.text = "Departamento \"Tortuga\" a 4 cuadras " +
                "del malecon"
        description.text = "Acogedor departamento cerca del malecón, tan cerca que podrás disfrutar de la brisa del mar. El departamento cuenta con una hermosa vista parcial al mar, ideal para relajarse y disfrutar de un hermoso atardecer en compañía de tu pareja, familia o amigos. Ubicado en una zona céntrica y tranquila; a solo cuatro cuadras caminando se encuentra el malecón, el Monumento al Pescador, la torre M y el famoso restaurante 'El Muchacho Alegre'. \n\n Está equipado con una habitación principal con cama Queen size y un cuarto secundario con dos camas individuales, que pueden unirse para formar una King size. Además, cuenta con una terraza con vista al mar, jacuzzi hidromasaje y parrilla para carnes asadas, disponibles bajo reserva y según disponibilidad."
        asidetext.text = Html.fromHtml(
            "<b>Acerca de nosotros</b><br><br>" +
                    "<b>Ubicación:</b><br><font color='#00796B'>Mazatlán, Sinaloa, México</font><br><br>" +
                    "<b># de cuartos:</b><br>Dos recámaras<br><br>" +
                    "<b># de baños:</b><br>Uno completo<br><br>" +
                    "<b>Más:</b><br><font color='#00796B'>Terraza con vista al mar,</font><br>" +
                    "Jacuzzi con hidromasaje,<br>" +
                    "Cocina completamente equipada",
            Html.FROM_HTML_MODE_LEGACY
        )

        image.setImageResource(R.drawable.about_banner)

        return view
    }
}
