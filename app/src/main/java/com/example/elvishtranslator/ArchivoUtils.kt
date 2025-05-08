package com.example.elvishtranslator

import android.content.Context

object ArchivoUtils {
    fun cargarPalabrasDesdeRaw(context: Context, archivoId: Int): List<Palabra> {
        val palabras = mutableListOf<Palabra>()
        val inputStream = context.resources.openRawResource(archivoId)
        inputStream.bufferedReader().useLines { lines ->
            lines.forEach { line ->
                val partes = line.split("|")
                if (partes.size == 4) {
                    val esp = partes[0].trim()
                    val elf = partes[1].trim()
                    val imgName = partes[2].trim().replace(".png", "")
                    val playName = partes[3].trim().replace(".png", "")

                    val imgId = context.resources.getIdentifier(imgName, "drawable", context.packageName)
                    val finalImgId = if (imgId != 0) imgId else R.drawable.frase

                    val playId = context.resources.getIdentifier(playName, "drawable", context.packageName)
                    val finalPlayId = if (playId != 0) playId else R.drawable.play

                    palabras.add(Palabra(finalImgId, esp, elf, finalPlayId))

                }
            }
        }
        return palabras
    }
}
