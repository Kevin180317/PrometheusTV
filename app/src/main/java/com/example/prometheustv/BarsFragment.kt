package com.example.prometheustv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

class BarsFragment : Fragment() {

    private val barsData = listOf(
        Triple("Ruiseñor Bar", R.drawable.ruise, 3),
        Triple("La Querencia", R.drawable.querencia, 3),
        Triple("La Barra", R.drawable.la_barra, 2),
        Triple("Bar 15", R.drawable.barra_15, 3),
        Triple("Micheladas del Belmar", R.drawable.micheladas, 3),
        Triple("Onaki", R.drawable.onaki, 3),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bars, container, false)

        val title = view.findViewById<TextView>(R.id.about_title)
        val container = view.findViewById<LinearLayout>(R.id.bars_container)

        title.text = "Bares"

        val barDescriptions = listOf(
            "Ubicado en el centro histórico, este bar ofrece mixología vanguardista en un ambiente relajado que combina lo rústico con lo moderno.",
            "Tras visitar Plaza Machado, este bar del centro histórico es perfecto para pasar un momento agradable tomando una bebida preparada.",
            "En el hotel \"La Siesta\", ubicado en Olas Altas, ideal para disfrutar el ambiente costero.",
            "Disfruta de deliciosos platillos como pizza y laing casero. Si deseas degustar una buena ginebra, este bar es una excelente opción.",
            "Micheladas y salceados, considerados por muchos como los mejores de Mazatlán.",
            "Antro ideal para ir de fiesta con amigos, con una gran vista al mar."
        )

        // Crear cada bar dinámicamente
        barsData.forEachIndexed { index, (name, imageResId, rating) ->
            val barView = createBarView(
                name,
                barDescriptions[index],
                imageResId,
                rating
            )
            container.addView(barView)
        }

        return view
    }

    private fun createBarView(name: String, description: String, imageResId: Int, rating: Int): View {
        val context = requireContext()

        // Container principal para cada bar
        val barContainer = LinearLayout(context).apply {
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

        // Título del bar
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

        // Descripción del bar
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

        barContainer.addView(imageView)
        barContainer.addView(textContainer)

        return barContainer
    }
}