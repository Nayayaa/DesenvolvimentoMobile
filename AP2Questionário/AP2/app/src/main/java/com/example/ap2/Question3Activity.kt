package com.example.ap2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Question3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_question3)

        val nome = intent.getStringExtra("nome")
        val idade = intent.getIntExtra("idade", 0)
        val estiloLuta = intent.getStringExtra("estiloLuta")
        val armas = intent.getStringArrayListExtra("armas")

        // Referência ao RadioGroup
        val radioGroupFilosofias = findViewById<RadioGroup>(R.id.radioGroupFilosofias)
        val btn = findViewById<Button>(R.id.proximo3)

        btn.setOnClickListener {
            val selectedRadioButtonId = radioGroupFilosofias.checkedRadioButtonId

            if (selectedRadioButtonId != -1) { // Verifica se alguma opção foi selecionada
                val filosofiaSelecionadaText = findViewById<RadioButton>(selectedRadioButtonId).text.toString()
                val filosofias = arrayListOf(filosofiaSelecionadaText) // Agora será uma lista com um único item

                val intent = Intent(this, Question4Activity::class.java)
                intent.putExtra("nome", nome)
                intent.putExtra("idade", idade)
                intent.putExtra("estiloLuta", estiloLuta)
                intent.putStringArrayListExtra("armas", armas)
                intent.putStringArrayListExtra("filosofias", filosofias) // Passa a lista com a única filosofia selecionada
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor, selecione sua filosofia de vida.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}