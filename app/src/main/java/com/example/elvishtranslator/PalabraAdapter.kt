package com.example.elvishtranslator
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class PalabraAdapter( context: Context, private val lista: List<Palabra>) : ArrayAdapter<Palabra>(context, 0, lista) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val itemView = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_palabra, parent, false)

        val palabra = lista[position]

        val imagen = itemView.findViewById<ImageView>(R.id.imagen_palabra)
        val textoEspanol = itemView.findViewById<TextView>(R.id.texto_espanol)
        val textoElfico = itemView.findViewById<TextView>(R.id.texto_elfico)
        val play = itemView.findViewById<ImageView>(R.id.imagen_play)

        imagen.setImageResource(palabra.imagen)
        textoEspanol.text = palabra.espanol
        textoElfico.text = palabra.elfico
        play.setImageResource(palabra.play)

        return itemView
    }
}