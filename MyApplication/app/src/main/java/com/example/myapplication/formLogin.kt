package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class formLogin : AppCompatActivity() {
    private lateinit var text_tela_cadastro: TextView
    private lateinit var edit_email: EditText
    private lateinit var edit_senha: EditText
    private lateinit var bt_entrar: Button
    private lateinit var progressBar: ProgressBar
    private val mensagens = arrayOf("Preencha todos os campos")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_login)
        IniciarComponentes()

        text_tela_cadastro.setOnClickListener {
            val intent = Intent(this, FormCadastroU::class.java)
            startActivity(intent)
        }

        bt_entrar.setOnClickListener {
            val email = edit_email.text.toString()
            val senha = edit_senha.text.toString()

            if (email.isEmpty() || senha.isEmpty()){
                val snackbar = Snackbar.make(bt_entrar, mensagens[0], Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.WHITE)
                snackbar.setTextColor(Color.BLACK)
                snackbar.show()
            } else {
                AutenticarUsuario()
            }
        }
    }


    private fun AutenticarUsuario() {
        val email = edit_email.text.toString()
        val senha = edit_senha.text.toString()

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, senha)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    progressBar.visibility = View.VISIBLE

                    Handler().postDelayed({
                        TelaUser()
                    }, 3000)
                } else {
                    var erro: String
                    try {
                        throw task.exception!!
                    }catch (e: Exception){
                        erro = "Erro ao logar usuário!"
                    }
                    val snackbar = Snackbar.make(bt_entrar, erro, Snackbar.LENGTH_SHORT)
                    snackbar.setBackgroundTint(Color.WHITE)
                    snackbar.setTextColor(Color.BLACK)
                    snackbar.show()
                }
            }
    }

    override fun onStart() {
        super.onStart()

        val usuarioAtual = FirebaseAuth.getInstance().currentUser

        if (usuarioAtual != null){
            TelaUser()
        }

    }

    private fun TelaUser() {
        val intent = Intent(this, telaPrincipal::class.java)
        startActivity(intent)
        finish()
    }

    private fun IniciarComponentes() {
        text_tela_cadastro = findViewById(R.id.text_cadastro)
        edit_email = findViewById(R.id.edit_email)
        edit_senha = findViewById(R.id.edit_senha)
        bt_entrar = findViewById(R.id.bt_entrar)
        progressBar = findViewById(R.id.progressBar)
    }
}