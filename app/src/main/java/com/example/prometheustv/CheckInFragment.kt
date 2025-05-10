package com.example.prometheustv

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class CheckInFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_checkin, container, false)

        val checkinTitle = view.findViewById<TextView>(R.id.checkin_title)
        val checkinTime = view.findViewById<TextView>(R.id.checkin_time)
        val checkinCheckout = view.findViewById<TextView>(R.id.checkin_checkout)
        val checkinDirections = view.findViewById<TextView>(R.id.checkin_directions)

        checkinTitle.text = Html.fromHtml(
            "<h2><font color='#00796B'><b>Check in and out</b></font></h2>",
            Html.FROM_HTML_MODE_LEGACY
        )

        checkinTime.text = Html.fromHtml(
            "<b>Check in:</b><br>El check in es a partir de las <font color='#00796B'>3:00 PM</font>",
            Html.FROM_HTML_MODE_LEGACY
        )

        checkinCheckout.text = Html.fromHtml(
            "<b>Check out:</b><br>El check out es a las <font color='#00796B'>12:00 PM</font>.<br>" +
                    "Si sale después de la hora de check-out sin previo acuerdo se cobrará la noche completa.",
            Html.FROM_HTML_MODE_LEGACY
        )

        checkinDirections.text = Html.fromHtml(
            "<b>Direcciones/otros:</b><br>" +
                    "Departamento \"Tortuga\" está ubicado en un lugar céntrico y seguro, a tan solo " +
                    "5 minutos caminando al malecón y monumento al pescador, donde podrás encontrar gran " +
                    "variedad de restaurantes a pie de playa, como el famoso restaurante “El muchacho alegre”; " +
                    "4 minutos en automóvil al centro de la ciudad, plaza Machado y varios puntos turísticos. " +
                    "Sin mencionar que podrás contemplar unos hermosos atardeceres desde la ventana de nuestra " +
                    "cocina o en el rooftop de uso compartido.<br><br>" +
                    "Muchas gracias por elegirnos y esperamos darle la bienvenida de vuelta pronto.",
            Html.FROM_HTML_MODE_LEGACY
        )

        return view
    }
}
