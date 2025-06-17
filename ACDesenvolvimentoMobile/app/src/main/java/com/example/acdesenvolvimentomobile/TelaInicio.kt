package com.example.acdesenvolvimentomobile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TelaInicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicio)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            // Criando a intent explícita para chamar a SecondActivity
            val intent = Intent(this, TelaQuiz::class.java)
            startActivity(intent)
        }
    }
}