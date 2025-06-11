package com.example.ap2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Question4Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_question4)

        val nome = intent.getStringExtra("nome")
        val idade = intent.getIntExtra("idade", 0)
        val estilo = intent.getStringExtra("estiloLuta")
        val armas = intent.getStringArrayListExtra("armas")
        val filosofias = intent.getStringArrayListExtra("filosofias")

        // Referência ao RadioGroup
        val radioGroupAmbiente = findViewById<RadioGroup>(R.id.radioGroupAmbiente)
        val btn = findViewById<Button>(R.id.proximo4)

        btn.setOnClickListener {
            val selectedRadioButtonId = radioGroupAmbiente.checkedRadioButtonId

            if (selectedRadioButtonId != -1) { // Verifica se alguma opção foi selecionada
                val ambienteSelecionadoText = findViewById<RadioButton>(selectedRadioButtonId).text.toString()
                val ambiente = arrayListOf(ambienteSelecionadoText) // Agora será uma lista com um único item

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("nome", nome)
                intent.putExtra("idade", idade)
                intent.putExtra("estiloLuta", estilo)
                intent.putStringArrayListExtra("armas", armas)
                intent.putStringArrayListExtra("filosofias", filosofias)
                intent.putStringArrayListExtra("ambiente", ambiente) // Passa a lista com o único ambiente selecionado
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor, selecione seu ambiente preferido.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}