package com.example.ap2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnComeçar = findViewById<Button>(R.id.btnComeçar)

        btnComeçar.setOnClickListener {
            // Criando a intent explícita para chamar a Activity2
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}