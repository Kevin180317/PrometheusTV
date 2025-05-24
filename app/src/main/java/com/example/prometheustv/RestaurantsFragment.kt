package com.example.prometheustv

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

class RestaurantsFragment : Fragment() {

    private val restaurantsData = listOf(
        Triple("El Muchacho Alegre", R.drawable.muchacho_alegre, 3),
        Triple("La Jaiba Pata Salada", R.drawable.la_jaiba, 3),
        Triple("Panamá Restaurante y Pastelería", R.drawable.panama, 3),
        Triple("Cafferium", R.drawable.cafferium, 3),
        Triple("La Marea", R.drawable.la_marea, 3),
        Triple("Gusto al Gusto Cantina de Playa", R.drawable.gusto, 3),
        Triple("Barrio Olas Altas (Shrimp Bucket)", R.drawable.olas, 2),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_restaurant, container, false)

        val title = view.findViewById<TextView>(R.id.about_title)
        val container = view.findViewById<LinearLayout>(R.id.restaurants_container)

        title.text = "Restaurantes"

        val restaurantDescriptions = listOf(
            "Lugar para comer mariscos y escuchar la banda con una hermosa vista al mar.",
            "Cerveza y platos de marisco de estilo familiar servidos en una sencilla cafetería al aire libre en la playa. Lugar para escuchar música de banda en vivo.",
            "Todo tipo de comida, lugar familiar, para disfrutar de un delicioso platillo.",
            "Una gran experiencia en café, desayunos y comidas.",
            "Deliciosos platillos, espectaculares bebidas y un servicio único con una de las mejores vistas al mar.",
            "Concepto para disfrutar Mazatlán de una manera diferente. Sushis, mariscos, cortes, cerveza y mixología, juntos en un lugar emblemático frente al mar.",
            "Marisquería inspirada en Mazatlán y su tan conocida zona turística de Olas Altas."
        )

        // Crear cada restaurante dinámicamente
        restaurantsData.forEachIndexed { index, (name, imageResId, rating) ->
            val restaurantView = createRestaurantView(
                name,
                restaurantDescriptions[index],
                imageResId,
                rating
            )
            container.addView(restaurantView)
        }

        return view
    }

    private fun createRestaurantView(name: String, description: String, imageResId: Int, rating: Int): View {
        val context = requireContext()

        // Container principal para cada restaurante
        val restaurantContainer = LinearLayout(context).apply {
            orientation = LinearLayout.HORIZONTAL
            setPadding(0, 0, 0, 32)
        }

        // ImageView para la foto
        val imageView = ImageView(context).apply {
            layoutParams = LinearLayout.LayoutParams(400, 350).apply {
                setMargins(0, 0, 24, 0)
            }
            scaleType = ImageView.ScaleType.CENTER_CROP
        }

        // Container para el texto
        val textContainer = LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
        }

        // Título del restaurante
        val nameTextView = TextView(context).apply {
            text = name
            textSize = 18f
            setTypeface(null, android.graphics.Typeface.BOLD)
            setTextColor(android.graphics.Color.BLACK)
            setPadding(0, 0, 0, 8)
        }

        // Container para las estrellas
        val starsContainer = LinearLayout(context).apply {
            orientation = LinearLayout.HORIZONTAL
            setPadding(0, 0, 0, 8)
        }

        // Crear estrellas
        for (i in 1..5) {
            val star = TextView(context).apply {
                text = if (i <= rating) "★" else "☆"
                textSize = 16f
                setTextColor(
                    if (i <= rating)
                        android.graphics.Color.parseColor("#FFD700") // Dorado para estrellas llenas
                    else
                        android.graphics.Color.parseColor("#CCCCCC") // Gris para estrellas vacías
                )
                setPadding(0, 0, 4, 0)
            }
            starsContainer.addView(star)
        }

        // Descripción del restaurante
        val descriptionTextView = TextView(context).apply {
            text = description
            textSize = 14f
            setTextColor(android.graphics.Color.parseColor("#666666"))
        }

        // Cargar imagen con Glide
        Glide.with(this)
            .load(imageResId)
            .placeholder(android.R.drawable.ic_menu_gallery)
            .error(android.R.drawable.ic_menu_close_clear_cancel)
            .transform(RoundedCorners(64))
            .into(imageView)

        // Ensamblar la vista
        textContainer.addView(nameTextView)
        textContainer.addView(starsContainer)
        textContainer.addView(descriptionTextView)

        restaurantContainer.addView(imageView)
        restaurantContainer.addView(textContainer)

        return restaurantContainer
    }
}