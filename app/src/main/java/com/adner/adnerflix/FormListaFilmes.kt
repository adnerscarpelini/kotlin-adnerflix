package com.adner.adnerflix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.adner.adnerflix.databinding.ActivityFormCadastroBinding
import com.adner.adnerflix.databinding.ActivityFormListaFilmesBinding
import com.google.firebase.auth.FirebaseAuth

class FormListaFilmes : AppCompatActivity() {

    private lateinit var binding: ActivityFormListaFilmesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormListaFilmesBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    //Sobrescrever o menu da Activity com o menu personalizado criado no res/menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.menu_principal, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            //Efetuar Logout
            R.id.mnuSair -> {
                FirebaseAuth.getInstance().signOut()
                ChamarTelaLogin()
            }

        }

        return super.onOptionsItemSelected(item)
    }

    private fun ChamarTelaLogin() {
        val intent = Intent(this, FormLogin::class.java)
        startActivity(intent)
        finish()
    }
}