package com.example.acdesenvolvimentomobile

import android.content.Intent
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Resultado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)

        val textoEscolhido = intent.getStringExtra("texto")
        val imagemEscolhida = intent.getStringExtra("imagem")

        // Pegando todas as imagens
        val imageThor = findViewById<ImageView>(R.id.imageView9)
        val imageHulk = findViewById<ImageView>(R.id.imageView8)
        val imageAranha = findViewById<ImageView>(R.id.imageView5)
        val imageDemolidor = findViewById<ImageView>(R.id.imageView3)

        // Pegando todos os textos
        val textThor = findViewById<TextView>(R.id.textView5)
        val textHulk = findViewById<TextView>(R.id.textView6)
        val textAranha = findViewById<TextView>(R.id.textView7)
        val textDemolidor = findViewById<TextView>(R.id.textView8)

        // Esconder tudo primeiro
        imageThor.visibility = View.GONE
        imageHulk.visibility = View.GONE
        imageAranha.visibility = View.GONE
        imageDemolidor.visibility = View.GONE

        textThor.visibility = View.GONE
        textHulk.visibility = View.GONE
        textAranha.visibility = View.GONE
        textDemolidor.visibility = View.GONE

        // Mostrar apenas o selecionado
        when (imagemEscolhida) {
            "thor" -> {
                imageThor.visibility = View.VISIBLE
                textThor.visibility = View.VISIBLE
            }
            "hulk" -> {
                imageHulk.visibility = View.VISIBLE
                textHulk.visibility = View.VISIBLE
            }
            "aranha" -> {
                imageAranha.visibility = View.VISIBLE
                textAranha.visibility = View.VISIBLE
            }
            "demolidor" -> {
                imageDemolidor.visibility = View.VISIBLE
                textDemolidor.visibility = View.VISIBLE
            }
        }
    }
}

