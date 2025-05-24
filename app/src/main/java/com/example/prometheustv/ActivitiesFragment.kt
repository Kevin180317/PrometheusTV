package com.example.prometheustv

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ActivitiesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_mazatlan, container, false)

        val title = view.findViewById<TextView>(R.id.about_title)
        val description = view.findViewById<TextView>(R.id.about_description)

        title.text = "Qué hacer en Mazatlán"

        val htmlContent = """
            <b>Acuario Mazatlán</b><br>
            Visita el acuario y vive una experiencia inolvidable, conociendo el mundo marino.<br><br>

            <b>Faro</b><br>
            Si te gusta hacer deporte esta es tu opción. Donde podrás disfrutar de una maravillosa vista y tomarte una foto instagramiable en el puente de cristal.<br><br>

            <b>Observatorio</b><br>
            Parque turístico el cual te ofrece historia, naturaleza, cultura e inigualables vistas.<br><br>

            <b>Isla de la Piedra</b><br>
            Se va en lancha a la isla de la piedra, donde encontrarás muchos restaurantes a la orilla de playa, y diversas actividades.<br><br>

            <b>Centro de Mazatlán</b><br>
            Visita la catedral y las famosas nieves de garrafa que están a un costado de la catedral.<br><br>

            <b>Plaza Machado</b><br>
            Lugar para pasear en familia, donde podrás encontrar música en vivo los fines de semana y gran variedad de restaurantes.<br><br>

            <b>Letras de Mazatlán</b><br>
            Ubicadas a un costado del Valentinos, lugar ideal para tomarte la foto en familia.<br><br>

            <b>Malecón</b><br>
            Camina por el malecón de Mazatlán por la tarde, te agradará ver los hermosos atardeceres.<br><br>

            <b>Clavadista</b><br>
            Lugar para ir a caminar y ver al clavadista tirarse al mar. También encontrarás diferentes puestos de comida callejera.
        """.trimIndent()

        description.text = Html.fromHtml(htmlContent, Html.FROM_HTML_MODE_LEGACY)

        return view
    }
}
