package com.adner.adnerflix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.adner.adnerflix.Adapter.FilmesAdapter
import com.adner.adnerflix.Model.addFilmes
import com.adner.adnerflix.databinding.ActivityFormDetalhesFilmeBinding
import com.adner.adnerflix.databinding.ListaFilmesBinding

class FormDetalhesFilme : AppCompatActivity() {

    private lateinit var binding: ActivityFormDetalhesFilmeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormDetalhesFilmeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Tirar a barra de ação padrão
        supportActionBar!!.hide()
        GerarToolBar()

        //Adiciona os filmes no RecyclerView
        val recycler_outrosfilmes = binding.recyclerOutrosFilmes
        recycler_outrosfilmes.adapter = FilmesAdapter(addFilmes())
        recycler_outrosfilmes.layoutManager =
            GridLayoutManager(applicationContext, 3) //Grade com 3 colunas


    }

    private fun GerarToolBar() {
        val toolbar_detalhes = binding.toolbarDetalhes
        toolbar_detalhes.setNavigationIcon(getDrawable(R.drawable.ic_voltar))
        toolbar_detalhes.setNavigationOnClickListener {
            val intent = Intent(this, FormListaFilmes::class.java)
            startActivity(intent)
            finish()
        }

    }
}