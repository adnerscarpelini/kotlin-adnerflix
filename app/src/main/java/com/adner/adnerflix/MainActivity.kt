package com.adner.adnerflix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Esconder a barra de ação
        supportActionBar!!.hide()

        //Depois de 2 segundos de splash chama a tela de login
        Handler(Looper.getMainLooper()).postDelayed({
            abrirTelaLogin()
        }, 2000)
    }

    private fun abrirTelaLogin(){
        val intent = Intent(this,FormLogin::class.java)
        startActivity(intent)
        finish()
    }
}