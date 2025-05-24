package com.example.prometheustv

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class RestaurantsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_restaurant, container, false)

        val title = view.findViewById<TextView>(R.id.about_title)
        val description = view.findViewById<TextView>(R.id.about_description)

        title.text = "Restaurantes"

        val htmlContent = """
            <b>El Muchacho Alegre</b><br>
            Lugar para comer mariscos y escuchar la banda con una hermosa vista al mar.<br><br>

            <b>La Jaiba Pata Salada</b><br>
            Cerveza y platos de marisco de estilo familiar servidos en una sencilla cafetería al aire libre en la playa. Lugar para escuchar música de banda en vivo.<br><br>

            <b>Panamá Restaurante y Pastelería</b><br>
            Todo tipo de comida, lugar familiar, para disfrutar de un delicioso platillo.<br><br>

            <b>Cafferium</b><br>
            Una gran experiencia en café, desayunos y comidas.<br><br>

            <b>La Marea</b><br>
            Deliciosos platillos, espectaculares bebidas y un servicio único con una de las mejores vistas al mar.<br><br>

            <b>Gusto al Gusto Cantina de Playa</b><br>
            Concepto para disfrutar Mazatlán de una manera diferente. Sushis, mariscos, cortes, cerveza y mixología, juntos en un lugar emblemático frente al mar.<br><br>

            <b>Barrio Olas Altas (Shrimp Bucket)</b><br>
            Marisquería inspirada en Mazatlán y su tan conocida zona turística de Olas Altas.
        """.trimIndent()

        description.text = Html.fromHtml(htmlContent, Html.FROM_HTML_MODE_LEGACY)

        return view
    }
}
