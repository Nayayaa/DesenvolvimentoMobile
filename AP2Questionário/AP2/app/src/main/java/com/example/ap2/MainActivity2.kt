package com.example.ap2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        val nomeInput = findViewById<EditText>(R.id.nomeInput)
        val idadeInput = findViewById<EditText>(R.id.idadeInput)
        val avancar = findViewById<Button>(R.id.btnAvancar)

        avancar.setOnClickListener {
            val nome = nomeInput.text.toString().trim()
            val idadeString = idadeInput.text.toString().trim()

            if (nome.isEmpty()) {
                Toast.makeText(this, "Por favor, digite seu nome.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (!nome.matches("[a-zA-Z\\s]+".toRegex())) { // Adicionado esta validação
                Toast.makeText(this, "Nome não deve conter números ou caracteres especiais.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val idade = idadeString.toIntOrNull()
            if (idade == null || idade <= 0) {
                Toast.makeText(this, "Por favor, digite uma idade válida.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, Question1Activity::class.java)
            intent.putExtra("nome", nome)
            intent.putExtra("idade", idade)
            startActivity(intent)
        }
    }
}