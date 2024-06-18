package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class tela_da_loja : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela_da_loja)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imageView16: ImageView = findViewById(R.id.imageView16)
        imageView16.setOnClickListener {
            val intent = Intent(this, telaPrincipal::class.java)
            startActivity(intent)
        }
        val imageView32: ImageView = findViewById(R.id.imageView32)
        imageView32.setOnClickListener {
            val intent = Intent(this, TelaUser::class.java)
            startActivity(intent)
        }
    }
}