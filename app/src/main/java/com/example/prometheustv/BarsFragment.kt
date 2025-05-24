package com.example.prometheustv

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class BarsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bars, container, false)

        val title = view.findViewById<TextView>(R.id.about_title)
        val description = view.findViewById<TextView>(R.id.about_description)

        title.text = "Bares"

        val htmlContent = """
            <b>Ruiseñor Bar</b><br>
            Ubicado en el centro histórico, este bar ofrece mixología vanguardista en un ambiente relajado que combina lo rústico con lo moderno.<br><br>

            <b>La Querencia</b><br>
            Tras visitar Plaza Machado, este bar del centro histórico es perfecto para pasar un momento agradable tomando una bebida preparada.<br><br>

            <b>La Barra</b><br>
            En el hotel “La Siesta”, ubicado en Olas Altas, ideal para disfrutar el ambiente costero.<br><br>

            <b>Bar 15</b><br>
            Disfruta de deliciosos platillos como pizza y laing casero. Si deseas degustar una buena ginebra, este bar es una excelente opción.<br><br>

            <b>Micheladas del Belmar</b><br>
            Micheladas y salceados, considerados por muchos como los mejores de Mazatlán.<br><br>

            <b>Onaki</b><br>
            Antro ideal para ir de fiesta con amigos, con una gran vista al mar.
        """.trimIndent()

        description.text = Html.fromHtml(htmlContent, Html.FROM_HTML_MODE_LEGACY)

        return view
    }
}
