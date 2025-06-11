package com.example.ap2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Question2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_question2)

        val nome = intent.getStringExtra("nome")
        val idade = intent.getIntExtra("idade", 0)
        val estiloLuta = intent.getStringExtra("estiloLuta")

        // Referência ao RadioGroup
        val radioGroupArmas = findViewById<RadioGroup>(R.id.radioGroupArmas)
        val btn = findViewById<Button>(R.id.proximo2)

        btn.setOnClickListener {
            val selectedRadioButtonId = radioGroupArmas.checkedRadioButtonId

            if (selectedRadioButtonId != -1) { // Verifica se alguma opção foi selecionada
                val armaSelecionadaText = findViewById<RadioButton>(selectedRadioButtonId).text.toString()
                val armas = arrayListOf(armaSelecionadaText)

                val intent = Intent(this, Question3Activity::class.java)
                intent.putExtra("nome", nome)
                intent.putExtra("idade", idade)
                intent.putExtra("estiloLuta", estiloLuta)
                intent.putStringArrayListExtra("armas", armas) // Passa a lista com a única arma selecionada
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor, selecione sua arma preferida.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
