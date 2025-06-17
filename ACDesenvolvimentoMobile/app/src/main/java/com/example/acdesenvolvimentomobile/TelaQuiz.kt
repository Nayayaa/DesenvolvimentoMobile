package com.example.acdesenvolvimentomobile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TelaQuiz : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela_quiz)


        val radioButton2 = findViewById<RadioButton>(R.id.radioButton2)
        radioButton2.setOnClickListener {
            if (radioButton2.isChecked) {
                val intent = Intent(this, Resultado::class.java)
                intent.putExtra("texto", "Você é como o Thor!")
                intent.putExtra("imagem", "thor")
                startActivity(intent)
            }
        }


        val radioButton = findViewById<RadioButton>(R.id.radioButton)
        radioButton.setOnClickListener {
            if (radioButton.isChecked) {
                val intent = Intent(this, Resultado::class.java)
                intent.putExtra("texto", "Você é como o Hulk!")
                intent.putExtra("imagem", "hulk")
                startActivity(intent)
            }
        }


        val radioButton3 = findViewById<RadioButton>(R.id.radioButton3)
        radioButton3.setOnClickListener {
            if (radioButton3.isChecked) {
                val intent = Intent(this, Resultado::class.java)
                intent.putExtra("texto", "Você é como o Homem-Aranha!")
                intent.putExtra("imagem", "aranha")
                startActivity(intent)
            }
        }

        val radioButton4 = findViewById<RadioButton>(R.id.radioButton4)
        radioButton4.setOnClickListener {
            if (radioButton4.isChecked) {
                val intent = Intent(this, Resultado::class.java)
                intent.putExtra("texto", "Você é como o Demolidor!")
                intent.putExtra("imagem", "demolidor")
                startActivity(intent)
            }
        }
    }
    override fun onResume() {
        super.onResume()

        // Isso limpa a seleção dos RadioButtons quando a tela volta
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        radioGroup.clearCheck()
    }
}