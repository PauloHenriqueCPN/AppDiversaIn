package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.firestore.FirebaseFirestore

class FormCadastroU : AppCompatActivity() {

    private lateinit var edit_nome: EditText
    private lateinit var edit_email: EditText
    private lateinit var edit_senha: EditText
    private lateinit var bt_cadastrar: Button
    private val mensagens = arrayOf("Preencha todos os campos", "Cadastro realizado com sucesso")
    lateinit var usuarioID: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_cadastro_u)

        IniciarComponentes()

        bt_cadastrar.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val nome = edit_nome.text.toString()
                val email = edit_email.text.toString()
                val senha = edit_senha.text.toString()

                if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                    val snackbar = Snackbar.make(v!!, mensagens[0], Snackbar.LENGTH_SHORT)
                    snackbar.setBackgroundTint(Color.WHITE)
                    snackbar.setTextColor(Color.BLACK)
                    snackbar.show()
                } else {
                    CadastrarUser(v)
                }
            }
        })
    }

    private fun CadastrarUser(v: View?){

        val email = edit_email.text.toString()
        val senha = edit_senha.text.toString()

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {

                    SalvarDadosUser()

                    val snackbar = Snackbar.make(v!!, mensagens[1], Snackbar.LENGTH_SHORT)
                    snackbar.setBackgroundTint(Color.WHITE)
                    snackbar.setTextColor(Color.BLACK)
                    snackbar.show()

                    // Redirecionar para a tela de login
                    val intent = Intent(this@FormCadastroU, formLogin::class.java)
                    startActivity(intent)
                    finish() // Finaliza a atividade atual para que o usuário não possa voltar para ela pressionando o botão "Voltar"
                } else {
                    var erro: String
                    try {
                        throw task.exception!!
                    } catch (e: FirebaseAuthWeakPasswordException) {
                        erro = "Digite uma senha com no mínimo 6 caracteres:"
                    } catch (e: FirebaseAuthUserCollisionException) {
                        erro = "Esta conta já foi cadastrada:"
                    } catch (e: FirebaseAuthInvalidCredentialsException) {
                        erro = "Email inválido:"
                    } catch (e: Exception) {
                        erro = "Erro ao cadastrar usuário:"
                    }

                    val snackbar = Snackbar.make(v!!, erro, Snackbar.LENGTH_SHORT)
                    snackbar.setBackgroundTint(Color.WHITE)
                    snackbar.setTextColor(Color.BLACK)
                    snackbar.show()
                }
            }

    }

    private fun SalvarDadosUser() {
        val nome = edit_nome.text.toString()

        val db = FirebaseFirestore.getInstance()

        val usuarios = HashMap<String, Any>()
        usuarios["nome"] = nome

        usuarioID = FirebaseAuth.getInstance().currentUser?.uid!!

        val documentReference = db.collection("Usuarios").document(usuarioID)
        documentReference.set(usuarios)
            .addOnSuccessListener {
                Log.d("db", "Sucesso ao salvar os dados")
            }
            .addOnFailureListener { e ->
                Log.d("db_error", "Erro ao salvar os dados" + e.toString())
            }
    }

    private fun IniciarComponentes() {
        edit_nome = findViewById(R.id.edit_nome)
        edit_email = findViewById(R.id.edit_email)
        edit_senha = findViewById(R.id.edit_senha)
        bt_cadastrar = findViewById(R.id.bt_cadastrar)
    }
}
