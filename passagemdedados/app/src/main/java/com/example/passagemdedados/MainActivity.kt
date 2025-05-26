package com.example.passagemdedados

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val etNome = findViewById<EditText>(R.id.editTextText)
        val btAvancar = findViewById<Button>(R.id.button)

        btAvancar.setOnClickListener {
            val nome = etNome.text.toString()
            val intent = Intent(this, Activity2::class.java)
            intent.putExtra("Nome", nome) // É um metodo que anexar conteudo a intent para passar de uma activity para outra.
            startActivity(intent)
        }
    }
}