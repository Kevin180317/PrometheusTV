package com.example.prometheustv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {

    private val infoMap = mapOf(
        "Acerca de nosotros" to DetailInfo(
            description = "Bienvenido a Departamento Tortuga, un espacio diseñado para tu comodidad y descanso en Mazatlán.",
            additionalInfo = "Esperamos que disfrutes tu estadía tanto como nosotros disfrutamos compartir nuestro hogar contigo.",
            imageResId = R.drawable.cardview,
        ),
        "WIFI" to DetailInfo(
            description = "Conéctate a la red para disfrutar de internet durante tu estadía.",
            additionalInfo = "Nombre de la red (SSID): Depa Tortuga Invitado\n\nContraseña: TortugaAirbnb2023\n\nTambién puedes escanear el código QR para conectarte automáticamente.",
            imageResId = R.drawable.qr,
        ),
        "Conoce a tu host" to DetailInfo(
            description = "Hola, soy Alejandro, tu anfitrión. Me encanta viajar y compartir experiencias.",
            additionalInfo = "Si necesitas ayuda o recomendaciones, estoy disponible vía Airbnb o WhatsApp.",
            imageResId = R.drawable.aside,
        ),
        "Check in & Check out" to DetailInfo(
            description = "Check-in: a partir de las 15:00\nCheck-out: hasta las 11:00",
            additionalInfo = "Recuerda dejar las llaves en la caja de seguridad al salir. Para check-out tardío, contáctanos con anticipación.",
            imageResId = R.drawable.aside,

        ),
        "Reglas de la casa" to DetailInfo(
            description = "Por favor, respeta las siguientes reglas durante tu estancia:",
            additionalInfo = "- No fumar\n- No fiestas\n- Mascotas bajo consulta\n- Respeta a los vecinos",
            imageResId = R.drawable.aside,
        ),
        "CheckList de salida" to DetailInfo(
            description = "Antes de irte, por favor revisa:",
            additionalInfo = "- Apagar luces y aire acondicionado\n- Tirar basura\n- Dejar toallas en el baño\n- Cerrar puertas y ventanas",
            imageResId = R.drawable.cardview,
        ),
        "Que puedo hacer en Mazatlán?" to DetailInfo(
            description = "Mazatlán ofrece muchas actividades:",
            additionalInfo = "- Paseo por el malecón\n- Visita al Faro\n- Tour en catamarán\n- Isla de la Piedra\n\nPregunta por nuestros descuentos en tours.",
            imageResId = R.drawable.aside,
        ),
        "Restaurantes" to DetailInfo(
            description = "Nuestros recomendados cercanos:",
            additionalInfo = "- Panamá\n- El Muchacho Alegre\n- Hector’s Bistro\n- Mariscos El Torito",
            imageResId = R.drawable.aside,
        ),
        "Bares" to DetailInfo(
            description = "Lugares con buen ambiente nocturno:",
            additionalInfo = "- Bora Bora\n- Joe's Oyster Bar\n- Rico's\n- Cotorritos",
            imageResId = R.drawable.aside,
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        val title = arguments?.getString("TITLE")

        val detailTitle: TextView = view.findViewById(R.id.detail_title)
        val detailImage: ImageView = view.findViewById(R.id.detail_image)
        val detailInfo: TextView = view.findViewById(R.id.detail_info)
        val detailAdditionalImage: ImageView = view.findViewById(R.id.detail_additional_image)
        val extraImageView1: ImageView = view.findViewById(R.id.extra_image_1)
        val extraImageView2: ImageView = view.findViewById(R.id.extra_image_2)
        val extraNotesText: TextView = view.findViewById(R.id.extra_notes)

        detailTitle.text = title

        val detail = infoMap[title]
        if (detail != null) {
            detailInfo.text = "${detail.description}\n\n${detail.additionalInfo}"
            detailImage.setImageResource(detail.imageResId)

            if (detail.additionalImageResId != null) {
                detailAdditionalImage.setImageResource(detail.additionalImageResId)
            } else {
                detailAdditionalImage.visibility = View.GONE
            }
            // Handle extra images if available
            if (detail.extraImageResId1 != null) {
                extraImageView1.setImageResource(detail.extraImageResId1)
                extraImageView1.visibility = View.VISIBLE
            } else {
                extraImageView1.visibility = View.GONE
            }

            if (detail.extraImageResId2 != null) {
                extraImageView2.setImageResource(detail.extraImageResId2)
                extraImageView2.visibility = View.VISIBLE
            } else {
                extraImageView2.visibility = View.GONE
            }

            // Handle extra notes
            extraNotesText.text = detail.extraNotes ?: ""
        } else {
            detailInfo.text = "Información no disponible."
        }

        return view
    }
}