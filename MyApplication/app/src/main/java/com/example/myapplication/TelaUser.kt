package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore

class TelaUser : AppCompatActivity() {

    private lateinit var nomeUser: TextView
    private lateinit var emailUser: TextView
    private lateinit var bt_deslogar: Button
    val db = FirebaseFirestore.getInstance()
    lateinit var usuarioID: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_user)

        IniciarComponentes()

        val voltar: ImageView = findViewById(R.id.voltar)
        voltar.setOnClickListener {
            val intent = Intent(this, telaPrincipal::class.java)
            startActivity(intent)
        }

        bt_deslogar.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this, formLogin::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onStart() {
        super.onStart()

        // Obtém o email do usuário atual logado
        val email = FirebaseAuth.getInstance().currentUser?.email
        // Obtém o ID do usuário atual logado
        val usuarioID = FirebaseAuth.getInstance().currentUser?.uid ?: return

        // Referência ao documento do usuário no Firestore
        val documentReference = FirebaseFirestore.getInstance().collection("Usuarios").document(usuarioID)
        documentReference.addSnapshotListener { snapshot, e ->
            if (e != null) {
                // Trate o erro caso ocorra
                Log.w("FirestoreError", "Listen failed.", e)
                return@addSnapshotListener
            }

            if (snapshot != null && snapshot.exists()) {
                // Atualiza os campos de texto com os dados do snapshot
                nomeUser.setText(snapshot.getString("nome"))
                emailUser.setText(email)
            } else {
                Log.d("Firestore", "Current data: null")
            }
        }
    }


    private fun IniciarComponentes(){
        nomeUser = findViewById(R.id.textNomeUser)
        emailUser = findViewById(R.id.textEmailUser)
        bt_deslogar = findViewById(R.id.bt_deslogar)
    }
}