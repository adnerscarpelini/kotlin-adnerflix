package com.adner.adnerflix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adner.adnerflix.databinding.ActivityFormCadastroBinding

class FormCadastro : AppCompatActivity() {

    private lateinit var binding: ActivityFormCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Esconder a barra de ação padrão
        supportActionBar!!.hide()

        //Personaliza a toolbar criada com a cor e imagem
        val toolbar = binding.toolbarCadastro
        toolbar.setBackgroundColor(getColor(R.color.white))
        toolbar.setNavigationIcon(getDrawable(R.drawable.ic_logo_svg))

        
    }
}