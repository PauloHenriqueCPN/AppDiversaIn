package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TelaJogoMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela_jogo_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imageButton9 = findViewById<ImageButton>(R.id.imageButton9)
        imageButton9.setOnClickListener {
            val intent = Intent(this@TelaJogoMain, TelaUser::class.java)
            startActivity(intent)
        }

        val imageButton10 = findViewById<ImageButton>(R.id.imageButton10)
        imageButton10.setOnClickListener {
            val intent = Intent(this@TelaJogoMain, telaPrincipal::class.java)
            startActivity(intent)
        }

        val imagem1 = findViewById<ImageButton>(R.id.imageButton)
        imagem1.setOnClickListener {
            val intent = Intent(this@TelaJogoMain, MapaRecrutamento::class.java)
            startActivity(intent)
        }

        val imagem2 = findViewById<ImageButton>(R.id.imageButton2)
        imagem2.setOnClickListener {
            val intent = Intent(this@TelaJogoMain, InclusaoPraticaMa::class.java)
            startActivity(intent)
        }

        val imagem5 = findViewById<ImageButton>(R.id.imageButton5)
        imagem5.setOnClickListener {
            val intent = Intent(this@TelaJogoMain, CulturaInclusiva::class.java)
            startActivity(intent)
        }

        val imagem6 = findViewById<ImageButton>(R.id.imageButton6)
        imagem6.setOnClickListener {
            val intent = Intent(this@TelaJogoMain, ComunicacaoInclusiva::class.java)
            startActivity(intent)
        }
    }
}