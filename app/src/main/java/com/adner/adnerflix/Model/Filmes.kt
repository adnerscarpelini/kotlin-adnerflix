package com.adner.adnerflix.Model

import com.adner.adnerflix.R

data class Filmes(
    val capaFilme: Int
)

class FilmesBuilder {
    var capaFilme: Int = 0
    fun build(): Filmes = Filmes(capaFilme)
}

fun filmes(block: FilmesBuilder.() -> Unit): Filmes = FilmesBuilder().apply(block).build()


//Esse método retorna os filmes - no cenario real seria a API retornando os dados
fun addFilmes(): MutableList<Filmes> = mutableListOf(
    filmes {
        capaFilme = R.drawable.filme1
    },

    filmes {
        capaFilme = R.drawable.filme2
    },

    filmes {
        capaFilme = R.drawable.filme3
    },

    filmes {
        capaFilme = R.drawable.filme4
    },

    filmes {
        capaFilme = R.drawable.filme5
    },

    filmes {
        capaFilme = R.drawable.filme6
    },

    filmes {
        capaFilme = R.drawable.filme7
    },

    filmes {
        capaFilme = R.drawable.filme8
    },

    filmes {
        capaFilme = R.drawable.filme9
    },

    filmes {
        capaFilme = R.drawable.filme10
    },

    filmes {
        capaFilme = R.drawable.filme11
    },

    filmes {
        capaFilme = R.drawable.filme12
    }
)