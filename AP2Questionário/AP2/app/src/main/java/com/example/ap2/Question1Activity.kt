package com.example.ap2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class Question1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_question1)

        val nome = intent.getStringExtra("nome")
        val idade = intent.getIntExtra("idade", 0)

        val rg = findViewById<RadioGroup>(R.id.questionário1)
        val btn = findViewById<Button>(R.id.proximo1)

        btn.setOnClickListener {
            val selecionado = rg.checkedRadioButtonId

            if (selecionado != -1) {
                val estilo = findViewById<RadioButton>(selecionado).text.toString()
                val intent = Intent(this, Question2Activity::class.java)
                intent.putExtra("nome", nome)         // Repassando nome
                intent.putExtra("idade", idade)
                intent.putExtra("estiloLuta", estilo)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor, selecione seu estilo de combate.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

