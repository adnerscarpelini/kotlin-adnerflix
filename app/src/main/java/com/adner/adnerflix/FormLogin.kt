package com.adner.adnerflix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.adner.adnerflix.databinding.ActivityFormLoginBinding
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException

class FormLogin : AppCompatActivity() {

    private lateinit var binding: ActivityFormLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFormLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Remover a barra de status
        supportActionBar!!.hide()

        //Se tiver usuario ja logado, ja chama a tela de filmes
        VerificarUsuarioLogado()

        binding.txtTelaCadastro.setOnClickListener {
            val intent = Intent(this, FormCadastro::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnEntrar.setOnClickListener {
            val email = binding.txtEmail.text.toString()
            val senha = binding.txtSenha.text.toString()
            val mensagem_erro = binding.txtErro

            if (email.isEmpty() || senha.isEmpty()) {
                mensagem_erro.setText("Informe o E-mail e Senha")
            } else {
                AutenticarUsuario()
            }
        }
    }

    private fun AutenticarUsuario() {
        val email = binding.txtEmail.text.toString()
        val senha = binding.txtSenha.text.toString()
        val mensagem_erro = binding.txtErro

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, senha).addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(this, "Login efetuado com sucesso!", Toast.LENGTH_SHORT).show()
                ChamarTelaFilmes()
            }
        }.addOnFailureListener {

            var erro = it

            when {
                erro is FirebaseAuthInvalidCredentialsException -> mensagem_erro.setText("E-mail ou Senha inválidos")
                erro is FirebaseNetworkException -> mensagem_erro.setText("Sem conexão com a internet")
                else -> mensagem_erro.setText("Erro ao efetuar LogIn")
            }

        }
    }

    private fun VerificarUsuarioLogado(){
        //Obter o usuário logado no firebase
        val usuarioLogado = FirebaseAuth.getInstance().currentUser

        if (usuarioLogado != null){
            ChamarTelaFilmes()
        }
    }

    private fun ChamarTelaFilmes() {
        val intent = Intent(this, FormListaFilmes::class.java)
        startActivity(intent)
        finish()
    }
}