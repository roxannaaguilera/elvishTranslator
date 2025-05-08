package com.example.elvishtranslator
import android.content.Context
import android.os.Bundle
import android.graphics.drawable.ColorDrawable
import android.speech.tts.TextToSpeech
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.RemoteViews.RemoteCollectionItems
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class List_view : AppCompatActivity() {
    private lateinit var tts: TextToSpeech
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        tts = TextToSpeech(this) { status ->
            if (status == TextToSpeech.SUCCESS) {
                tts.language = Locale("es")
            }
        }


        val titulo = intent.getStringExtra("titulo") ?: "Elvish Translator"
        supportActionBar?.title = titulo
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val color = ContextCompat.getColor(this, R.color.amarillo)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(color))

        val listView = findViewById<ListView>(R.id.list_items)
        val archivoId = intent.getIntExtra("archivo_txt", -1)

        if (archivoId != -1) {
            val palabras = ArchivoUtils.cargarPalabrasDesdeRaw(this, archivoId)
            mostrarListaPalabras(this, listView, palabras)

            setItemClickListener(listView, palabras) { palabra ->
                tts.speak(palabra.elfico, TextToSpeech.QUEUE_FLUSH, null, null)
            }

        } else {
            listView.adapter = null
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }

    fun mostrarListaPalabras(context: Context, listView: ListView, palabras: List<Palabra>) {
        val adapter = PalabraAdapter(context, palabras)
        listView.adapter = adapter
    }

    fun setItemClickListener(listView: ListView, palabras: List<Palabra>, listener: OnClickListener) {
        listView.setOnItemClickListener { _, _, position, _ ->
            listener.onClickListener(palabras[position])
        }
    }
    override fun onDestroy() {
        if (::tts.isInitialized) {
            tts.stop()
            tts.shutdown()
        }
        super.onDestroy()
    }
}