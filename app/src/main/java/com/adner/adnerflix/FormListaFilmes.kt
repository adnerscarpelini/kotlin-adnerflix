package com.adner.adnerflix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.adner.adnerflix.Adapter.FilmesAdapter
import com.adner.adnerflix.Model.addFilmes
import com.adner.adnerflix.OnClick.OnItemClickListener
import com.adner.adnerflix.OnClick.addOnItemClickListener
import com.adner.adnerflix.databinding.ActivityFormCadastroBinding
import com.adner.adnerflix.databinding.ActivityFormListaFilmesBinding
import com.google.firebase.auth.FirebaseAuth

class FormListaFilmes : AppCompatActivity() {

    private lateinit var binding: ActivityFormListaFilmesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormListaFilmesBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //O RecyclerView cria uma lista dinamica
        //O Dataset é o objeto que repete na lista, nesse caso a capa do filme
        val recycler_filmes = binding.recyclerView
        recycler_filmes.adapter = FilmesAdapter(addFilmes())
        //Informa que a lista deve ser renderizada em 3 colunas
        recycler_filmes.layoutManager = GridLayoutManager(applicationContext, 3)


        //Evento de Clique na lista
        recycler_filmes.addOnItemClickListener(object : OnItemClickListener {
            override fun onItemClicked(position: Int, view: View) {

                when {
                    position == 0 -> DetalhesFilme()
                }
            }
        })
    }

    private fun DetalhesFilme() {
        val intent = Intent(this, FormDetalhesFilme::class.java)
        startActivity(intent)
        
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