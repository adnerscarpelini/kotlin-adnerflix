package com.adner.adnerflix

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import com.adner.adnerflix.databinding.ActivityFormDetalhesFilmeBinding
import com.adner.adnerflix.databinding.ActivityFormVideoBinding

class FormVideo : AppCompatActivity() {

    private lateinit var binding: ActivityFormVideoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormVideoBinding.inflate(layoutInflater)

        setContentView(binding.root)

        supportActionBar!!.hide()

        //Pegar o video do FirebaseStorage
        val videoUrl =
            Uri.parse("https://firebasestorage.googleapis.com/v0/b/adnerflix.appspot.com/o/THE%20WITCHER%20_%20TRAILER%20FINAL%20_%20NETFLIX.mp4?alt=media&token=958f1b38-c2a5-4b4c-86ff-bceb714b1c97")

        val video = binding.video
        video.setMediaController(MediaController(this)) //Colocar os controles do video
        video.setVideoURI(videoUrl)
        video.requestFocus()
        video.start()
    }
}