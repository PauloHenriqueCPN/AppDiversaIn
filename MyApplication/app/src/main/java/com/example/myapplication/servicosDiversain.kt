package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R

class servicosDiversain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_servicos_diversain)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val imageView7: ImageView = findViewById(R.id.imageView7)
        imageView7.setOnClickListener {
            val intent = Intent(this, TelaUser::class.java)
            startActivity(intent)
        }
        val imageView6 = findViewById<ImageView>(R.id.imageView6)
        imageView6.setOnClickListener {
            val intent = Intent(this, telaPrincipal::class.java)
            startActivity(intent)
        }
        val imagem2 = findViewById<ImageButton>(R.id.imageButton)
        imagem2.setOnClickListener {
            val intent = Intent(this@servicosDiversain, recrutamento_inclusivo::class.java)
            startActivity(intent)
        }
        val imagem3 = findViewById<ImageButton>(R.id.imageButton2)
        imagem3.setOnClickListener {
            val intent = Intent(this@servicosDiversain, inclusao_pratica::class.java)
            startActivity(intent)
        }
    }
}