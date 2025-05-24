package com.example.prometheustv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.text.Html
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class ChecklistFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_checklist, container, false)

        val title = view.findViewById<TextView>(R.id.checklist_title)
        val description = view.findViewById<TextView>(R.id.checklist_description)
        val content = view.findViewById<TextView>(R.id.checklist_text)
        val image = view.findViewById<ImageView>(R.id.checklist_image)
        title.text = Html.fromHtml(
            "<h2><font color='#00796B'><b>Check list de salida</b></font></h2>",
            Html.FROM_HTML_MODE_LEGACY
        )
        description.text = Html.fromHtml(
            "<b>Lo que debes de hacer antes de salir:</b><br>",
            Html.FROM_HTML_MODE_LEGACY
        )
        content.text = Html.fromHtml(
            "<b>1. Colocar las toallas en Cesto de ropa sucia.\n" + "</b><br>" +
                "<b>2. Sacar la basura y tirarla en el bote negro, colocado en\n" + "el pasillo al entrar al departamento.</b><br>" +
                "<b>3. Apagar las luces y los aparatos.\n" + "</b><br>" +
                "<b>4. Cerrar con llave.\n" + "</b><br>" +
                "<b>5. Devolver las llaves a la caja lockbox\n</b><br>"
            , Html.FROM_HTML_MODE_LEGACY)

        image.setImageResource(R.drawable.checklist)
        return view
    }
}
