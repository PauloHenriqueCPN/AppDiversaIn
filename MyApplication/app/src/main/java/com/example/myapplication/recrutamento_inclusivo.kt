package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R

class recrutamento_inclusivo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recrutamento_inclusivo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val imageView3: ImageView = findViewById(R.id.imageView9)
        imageView3.setOnClickListener {
            val intent = Intent(this, TelaUser::class.java)
            startActivity(intent)
        }
        val imageView2 = findViewById<ImageView>(R.id.imageView10)
        imageView2.setOnClickListener {
            val intent = Intent(this, servicosDiversain::class.java)
            startActivity(intent)
        }

        val botaoInclusivo = findViewById<Button>(R.id.buttonInclusivoSite)
        botaoInclusivo.setOnClickListener {
            val url = "https://diversain.com.br/produto/recrutamento-inclusivo/"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
    }
}