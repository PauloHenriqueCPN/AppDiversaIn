package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MapaRecrutamento : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mapa_recrutamento)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imageButton9 = findViewById<ImageButton>(R.id.imageButton9)
        imageButton9.setOnClickListener {
            val intent = Intent(this@MapaRecrutamento, TelaUser::class.java)
            startActivity(intent)
        }

        val imagem1 = findViewById<ImageButton>(R.id.imageButton10)
        imagem1.setOnClickListener {
            val intent = Intent(this@MapaRecrutamento, TelaJogoMain::class.java)
            startActivity(intent)
        }

    }

    private fun showPopup() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("**** Pop-up ****")
        builder.setMessage("Teste teste teste.")
        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}



