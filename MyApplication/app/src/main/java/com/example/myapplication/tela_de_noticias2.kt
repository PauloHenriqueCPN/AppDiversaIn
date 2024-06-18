package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class tela_de_noticias2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela_de_noticias2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imageView21: ImageView = findViewById(R.id.imageView21)
        imageView21.setOnClickListener {
            val intent = Intent(this, telaPrincipal::class.java)
            startActivity(intent)
        }
        val imageView34: ImageView = findViewById(R.id.imageView34)
        imageView34.setOnClickListener {
            val intent = Intent(this, TelaUser::class.java)
            startActivity(intent)
        }
    }
}