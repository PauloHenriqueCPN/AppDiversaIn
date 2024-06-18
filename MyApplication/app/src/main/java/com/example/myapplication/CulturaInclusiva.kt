package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CulturaInclusiva : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cultura_inclusiva)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imageButton9 = findViewById<ImageButton>(R.id.imageButton9)
        imageButton9.setOnClickListener {
            val intent = Intent(this@CulturaInclusiva, TelaUser::class.java)
            startActivity(intent)
        }

        val imagem1 = findViewById<ImageButton>(R.id.imageButton10)
        imagem1.setOnClickListener {
            val intent = Intent(this@CulturaInclusiva, TelaJogoMain::class.java)
            startActivity(intent)
        }
    }
}