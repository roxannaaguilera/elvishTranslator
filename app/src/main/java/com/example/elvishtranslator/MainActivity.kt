package com.example.elvishtranslator

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class   MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

    }

    fun onClickNumeros(view: View) {

        val intent= Intent(this, List_view::class.java)
        intent.putExtra("archivo_txt", R.raw.numeros)
        intent.putExtra("titulo","Números")
        startActivity(intent)
    }

    fun onClickFamilias(view: View) {
        val intent = Intent(this, List_view::class.java)
        intent.putExtra("archivo_txt", R.raw.familia)
        intent.putExtra("titulo", "Familia")
        startActivity(intent)
    }

    fun onClickColores(view: View) {
        val intent = Intent(this, List_view::class.java)
        intent.putExtra("archivo_txt", R.raw.colores)
        intent.putExtra("titulo", "Colores")
        startActivity(intent)
    }

    fun onClickFrases(view: View) {
        val intent = Intent(this, List_view::class.java)
        intent.putExtra("archivo_txt", R.raw.frases)
        intent.putExtra("titulo", "Frases")
        startActivity(intent)
    }
}



