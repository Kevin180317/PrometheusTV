package com.example.prometheustv

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class RulesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_rules, container, false)

        // Obtener los TextViews del XML
        val rulesTitle = view.findViewById<TextView>(R.id.rules_title)
        val rulesList = view.findViewById<TextView>(R.id.rules_list)

        // Asignar el título para las reglas
        rulesTitle.text = "Reglas de la Casa"

        // HTML para las reglas de la casa
        val rulesHtml = """
            <b>Prohibido fumar, ni vapear.</b> <font color='#FF0000'>Penalidad $300</font><br>
            <b>No Fiestas, ni hacer ruidos excesivos.</b> <font color='#FF0000'>Penalidad $300</font><br>
            <b>Respetar el número de huéspedes asignados en la plataforma.</b> <font color='#FF0000'>Penalidad $200 por huésped.</font><br>
            <b>No se admiten mascotas.</b> <font color='#FF0000'>Penalidad $200</font><br>
            <b>No botar toallitas húmedas en los inodoros.</b><br>
            <b>Las toallas y ropa de cama son blancas y de uso exclusivo para los huéspedes.</b> <font color='#FF0000'>En caso de mancharlas su valor será solicitado por la App.</font><br>
            <b>Al reservar el área común y no poder asistir deberá avisar con 1 hora de anticipación para cancelar la reserva;</b> <font color='#FF0000'>en caso contrario deberá pagar una penalidad de $30 al edificio.</font><br>
            <b>Se prohíbe lanzar papeles, basura, desperdicios, colillas de cigarro</b> en áreas comunes. <font color='#FF0000'>Penalidad $300</font><br>
            <b>Si sale después de la hora de check-out sin previo acuerdo</b> <font color='#FF0000'>se cobrará la noche completa</font><br>
            <b>Todos los accesorios de playa disponibles dentro del departamento</b> <font color='#FF0000'>deberán ser devueltos al departamento en buen estado.</font><br>
            <b>Cualquier daño a la propiedad debe ser notificado antes del check-out</b> <font color='#FF0000'>y su valor será solicitado por la App.</font><br>
            <b>En caso de no hacerlo se penalizará con</b> <font color='#FF0000'>500 + el valor del daño.</font><br>
        """.trimIndent()

        // Asignar las reglas con HTML al TextView
        rulesList.text = Html.fromHtml(rulesHtml, Html.FROM_HTML_MODE_LEGACY)

        return view
    }
}
