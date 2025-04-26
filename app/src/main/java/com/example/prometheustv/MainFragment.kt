package com.example.prometheustv

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.*
import com.bumptech.glide.Glide

class MainFragment : BrowseSupportFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ✅ Título que aparece arriba del menú izquierdo
        title = "Departamento Tortuga"

        // ✅ Fondo de la pantalla
        val backgroundDrawable = ContextCompat.getDrawable(requireContext(), R.drawable.background)
        backgroundDrawable?.let {
            view.background = it
        }

        // ✅ Adapter principal de rows
        val rowsAdapter = ArrayObjectAdapter(ListRowPresenter())

        // ✅ Agregamos un encabezado visual tipo "intro" antes de las categorías
        val headerIntro = HeaderItem(9999L, "Menu Principal")
        val emptyAdapter = ArrayObjectAdapter(CardPresenter()) // sin ítems
        rowsAdapter.add(ListRow(headerIntro, emptyAdapter))

        // ✅ Mapa de categorías a sus ítems
        val categorizedItems = mapOf(
            "Información general" to listOf(
                "Acerca de nosotros" to R.drawable.skeleton,
                "WIFI" to R.drawable.skeleton,
                "Conoce a tu host" to R.drawable.skeleton
            ),
            "Estancia" to listOf(
                "Check in & Check out" to R.drawable.skeleton,
                "Reglas de la casa" to R.drawable.skeleton,
                "CheckList de salida" to R.drawable.skeleton
            ),
            "Explora Mazatlán" to listOf(
                "Que puedo hacer en Mazatlán?" to R.drawable.skeleton,
                "Restaurantes" to R.drawable.skeleton,
                "Bares" to R.drawable.skeleton
            )
        )

        // ✅ Crear filas con tarjetas por categoría
        var headerId = 0L
        for ((category, items) in categorizedItems) {
            val listRowAdapter = ArrayObjectAdapter(CardPresenter())
            listRowAdapter.addAll(0, items)

            val header = HeaderItem(headerId++, category)
            rowsAdapter.add(ListRow(header, listRowAdapter))
        }

        adapter = rowsAdapter
    }

    // ✅ Presentador de cada tarjeta
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

            // Cargar imagen
            Glide.with(cardView.context)
                .load(imageResId)
                .into(cardView.mainImageView)

            // Click: ir a detalle
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
