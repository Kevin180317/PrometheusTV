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

class ActivitiesFragment : Fragment() {

    private val activitiesData = listOf(
        Triple("Acuario Mazatlán", "Visita el acuario y vive una experiencia inolvidable, conociendo el mundo marino.", R.drawable.acuario),
        Triple("Faro", "Si te gusta hacer deporte esta es tu opción. Donde podrás disfrutar de una maravillosa vista y tomarte una foto en el puente de cristal.", R.drawable.faro),
        Triple("Observatorio", "Parque turístico que ofrece historia, naturaleza, cultura e inigualables vistas.", R.drawable.observatorio),
        Triple("Isla de la Piedra", "Se va en lancha y encontrarás muchos restaurantes a la orilla de playa y diversas actividades.", R.drawable.piedra),
        Triple("Centro de Mazatlán", "Visita la catedral y las famosas nieves de garrafa al costado.", R.drawable.centro),
        Triple("Plaza Machado", "Lugar familiar con música en vivo los fines de semana y restaurantes.", R.drawable.plaza),
        Triple("Letras de Mazatlán", "Ubicadas a un costado del Valentinos, ideal para una foto en familia.", R.drawable.letras),
        Triple("Malecón", "Camina por el malecón al atardecer, vistas impresionantes.", R.drawable.malecon),
        Triple("Clavadista", "Ve al clavadista tirarse al mar y prueba comida callejera local.", R.drawable.clavado)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_mazatlan, container, false)

        val title = view.findViewById<TextView>(R.id.about_title)
        val containerLayout = view.findViewById<LinearLayout>(R.id.activities_container)

        title.text = "Qué hacer en Mazatlán"

        activitiesData.forEach { (name, description, imageResId) ->
            val activityView = createActivityView(name, description, imageResId)
            containerLayout.addView(activityView)
        }

        return view
    }

    private fun createActivityView(name: String, description: String, imageResId: Int): View {
        val context = requireContext()

        val itemContainer = LinearLayout(context).apply {
            orientation = LinearLayout.HORIZONTAL
            setPadding(0, 0, 0, 32)
        }

        val imageView = ImageView(context).apply {
            layoutParams = LinearLayout.LayoutParams(400, 350).apply {
                setMargins(0, 0, 24, 0)
            }
            scaleType = ImageView.ScaleType.CENTER_CROP
        }

        val textContainer = LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
        }

        val titleView = TextView(context).apply {
            text = name
            textSize = 18f
            setTypeface(null, android.graphics.Typeface.BOLD)
            setTextColor(android.graphics.Color.BLACK)
            setPadding(0, 0, 0, 8)
        }

        val descriptionView = TextView(context).apply {
            text = description
            textSize = 14f
            setTextColor(android.graphics.Color.parseColor("#666666"))
        }

        Glide.with(this)
            .load(imageResId)
            .placeholder(android.R.drawable.ic_menu_gallery)
            .error(android.R.drawable.ic_menu_close_clear_cancel)
            .transform(RoundedCorners(64))
            .into(imageView)

        textContainer.addView(titleView)
        textContainer.addView(descriptionView)
        itemContainer.addView(imageView)
        itemContainer.addView(textContainer)

        return itemContainer
    }
}
