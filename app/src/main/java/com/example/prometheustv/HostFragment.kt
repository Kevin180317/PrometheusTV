package com.example.prometheustv

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class HostFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_host, container, false)

        val title = view.findViewById<TextView>(R.id.host_title)
        val lefttext = view.findViewById<TextView>(R.id.left_text)
        val righttext = view.findViewById<TextView>(R.id.right_text)
        val righttext2 = view.findViewById<TextView>(R.id.right_text2)
        val image = view.findViewById<ImageView>(R.id.host_image)

        title.text = Html.fromHtml(
            "<h2><font color='#00796B'><b>Soy tu Host</b></font></h2>",
            Html.FROM_HTML_MODE_LEGACY
        )

        lefttext.text = Html.fromHtml(
            "<p>Somos una pareja que decidió emprender este nuevo proyecto como " +
                    "<b><font color='#00796B'>Hosts en Mazatlán</font></b>, ya que es uno de nuestros destinos favoritos. " +
                    "Nos gusta disfrutar de su playa, la banda y sus hermosos atardeceres.</p>" +

                    "<p>Nos encanta viajar y conocer gente de diferentes partes del mundo y esperamos conectarnos contigo como anfitrión o viajero.</p>" +

                    "<p><b>¡Haremos todo lo posible para que tu estadía sea lo más cómoda posible!</b></p>" +

                    "<p><i>¡Muchas gracias por elegirnos y esperamos darte la bienvenida pronto!</i></p>" +

                    "<br><u><b>Información de emergencia:</b></u><br><br>" +
                    "<b>• Número de emergencias:</b> 911<br>" +
                    "<b>• Cruz Roja Mexicana:</b> Juan Luis Vives #200, Centro, Polanco I Secc, 11510, Sin.<br><br>" +

                    "<b>Hospitales Privados:</b><br>" +
                    "• Sharp Hospital Mazatlán – Milpa 57, Hacienda las Cruces, 82126 Mazatlán, Sin.<br>" +
                    "• Hospital Marina Mazatlán – Av. Dr. Carlos Canseco 6048, La Marina, 82103",
            Html.FROM_HTML_MODE_LEGACY
        )

        righttext.text = Html.fromHtml(
            "<b><u>Contacto:</u></b><br><br>" +
                    "<b>Teléfono:</b> +52 664 572 0731",
            Html.FROM_HTML_MODE_LEGACY
        )

        righttext2.text = Html.fromHtml(
            "<b>Abigail & Fidel</b><br><br>" +
                    "<i>Anfitriones</i><br>" +
                    "Idiomas: Español e Inglés<br>" +
                    "Tiempo de respuesta: <b>1 hora</b><br>" +
                    "Verificado<br>" +
                    "Tasa de respuesta: <b>100%</b>",
            Html.FROM_HTML_MODE_LEGACY
        )

        image.setImageResource(R.drawable.host)

        return view
    }
}
