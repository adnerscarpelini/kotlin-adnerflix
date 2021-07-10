package com.adner.adnerflix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.adner.adnerflix.databinding.ActivityFormCadastroBinding
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException

class FormCadastro : AppCompatActivity() {

    private lateinit var binding: ActivityFormCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        gerarToolBar()

        binding.btnCadastrar.setOnClickListener {
            val email = binding.txtEmail.text.toString()
            val senha = binding.txtSenha.text.toString()
            val mensagem_erro = binding.lblMensagemErro

            if (email.isEmpty() || senha.isEmpty()) {
                mensagem_erro.setText("Preencha todos os campos!")
            } else {
                mensagem_erro.setText("")
                cadastrarUsuario()
            }
        }

    }

    private fun gerarToolBar() {
        //Esconder a barra de ação padrão
        supportActionBar!!.hide()

        //Personaliza a toolbar criada com a cor e imagem
        val toolbar = binding.toolbarCadastro
        toolbar.setBackgroundColor(getColor(R.color.white))
        toolbar.navigationIcon = getDrawable(R.drawable.ic_logo_svg)
    }


    private fun cadastrarUsuario() {
        val email = binding.txtEmail.text.toString()
        val senha = binding.txtSenha.text.toString()
        val mensagem_erro = binding.lblMensagemErro

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha)
            .addOnCompleteListener {
                //Se deu certo
                if (it.isSuccessful) {
                    Toast.makeText(this, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT)
                        .show()
                    binding.txtEmail.setText("")
                    binding.txtSenha.setText("")
                }
            }.addOnFailureListener {
            //Se deu erro
            var erro = it

            when {
                erro is FirebaseAuthWeakPasswordException -> mensagem_erro.setText("Digite uma senha com no mínimo 6 dígitos")
                erro is FirebaseAuthUserCollisionException -> mensagem_erro.setText("E-mail já cadastrado")
                erro is FirebaseNetworkException -> mensagem_erro.setText("Sem conexão com a internet")
                else -> mensagem_erro.setText("Erro ao cadastrar usuário")
            }

        }
        ;
    }
}