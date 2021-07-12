package com.adner.adnerflix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.adner.adnerflix.Adapter.FilmesAdapter
import com.adner.adnerflix.Model.addFilmes
import com.adner.adnerflix.databinding.ActivityFormDetalhesFilmeBinding
import com.adner.adnerflix.databinding.ListaFilmesBinding
import com.squareup.picasso.Picasso

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


        //Pegar imagem do firebase storage
        val capaTheWitcher =
            "https://firebasestorage.googleapis.com/v0/b/adnerflix.appspot.com/o/video.jpg?alt=media&token=6057f111-54fd-47e4-9552-7c08a5cab1f7"

        //Usar a biblioteca Picasso para recuperar a imagem e carregar no imageview
        Picasso.get().load(capaTheWitcher).fit().into(binding.imgCapa)

        binding.imgPlayVideo.setOnClickListener {
            val intent = Intent(this, FormVideo::class.java)
            startActivity(intent)

        }

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