package com.example.prometheustv

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.*
import com.bumptech.glide.Glide

class MainFragment : BrowseSupportFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Título
        title = "Departamento Tortuga"

        // Fondo de la pantalla
        view.setBackgroundColor(Color.parseColor("#4b5949"))

        // Fondo del menú lateral
        brandColor = Color.parseColor("#687368")

        headersState = HEADERS_ENABLED

        // Color textos Menu Lateral y Title
        view.post {
            fun setHeaderColors(v: View) {
                if (v is TextView) {
                    // Detecta si es el título por tamaño de texto o contenido
                    if (v.text == title) {
                        v.setTextColor(Color.WHITE)  // título en blanco
                        v.setTypeface(v.typeface, Typeface.BOLD) //
                    } else {
                        v.setTextColor(Color.WHITE)  // headers en negro
                        v.setTypeface(v.typeface, Typeface.BOLD) //
                    }
                } else if (v is ViewGroup) {
                    for (i in 0 until v.childCount) {
                        setHeaderColors(v.getChildAt(i))
                    }
                }
            }
            setHeaderColors(view)
        }

        // Adapter principal de rows
        val rowsAdapter = ArrayObjectAdapter(ListRowPresenter())

        // Encabezado visual tipo "intro"
        val headerIntro = HeaderItem(9999L, "Menu Principal")
        val emptyAdapter = ArrayObjectAdapter(CardPresenter())
        rowsAdapter.add(ListRow(headerIntro, emptyAdapter))

        // Categorías y sus items
        val categorizedItems = mapOf(
            "Información general" to listOf(
                "Acerca de nosotros" to R.drawable.dt_acerca,
                "WIFI" to R.drawable.dt_host,
                "Conoce a tu host" to R.drawable.dt_wifi
            ),
            "Estancia" to listOf(
                "Check in & Check out" to R.drawable.dt_checkin,
                "Reglas de la casa" to R.drawable.dt_reglas,
                "CheckList de salida" to R.drawable.dt_checklist
            ),
            "Explora Mazatlán" to listOf(
                "Que hacer en Mazatlán?" to R.drawable.dt_que_hacer,
                "Restaurantes" to R.drawable.dt_restaurante,
                "Bares" to R.drawable.dt_bares
            )
        )

        // Crear filas
        var headerId = 0L
        for ((category, items) in categorizedItems) {
            val listRowAdapter = ArrayObjectAdapter(CardPresenter())
            listRowAdapter.addAll(0, items)
            val header = HeaderItem(headerId++, category)
            rowsAdapter.add(ListRow(header, listRowAdapter))
        }

        adapter = rowsAdapter
    }

    class CardPresenter : Presenter() {
        override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
            val cardView = ImageCardView(parent.context)
            cardView.isFocusable = true
            cardView.isFocusableInTouchMode = true
            return ViewHolder(cardView)
        }

        override fun onBindViewHolder(viewHolder: ViewHolder, item: Any?) {
            val (title, imageResId) = item as Pair<String, Int>
            val cardView = viewHolder.view as ImageCardView
            cardView.titleText = title
            cardView.setMainImageDimensions(376, 390)
            cardView.setInfoAreaBackgroundColor(Color.parseColor("#89958d"))

            Glide.with(cardView.context)
                .load(imageResId)
                .into(cardView.mainImageView)

            cardView.setOnClickListener {
                val context = cardView.context as FragmentActivity
                val fragment = DetailFragment().apply {
                    arguments = Bundle().apply {
                        putString("TITLE", title)
                        putInt("IMAGE", imageResId)
                    }
                }
                context.supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit()
            }
        }

        override fun onUnbindViewHolder(viewHolder: ViewHolder) {
            val cardView = viewHolder.view as ImageCardView
            Glide.with(cardView.context).clear(cardView.mainImageView)
        }
    }
}
