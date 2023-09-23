package com.example.practical7_125

import android.app.Activity
import android.content.Intent
import android.content.pm.ActivityInfo
import android.media.session.MediaController
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practical7_125.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initVideoPlayer()
        binding.cloudbutton.setOnClickListener{
            Intent(this,YoutubePlayer::class.java).also { startActivity(it) }
        }
    }
    private fun initVideoPlayer(){
        val medialController = android.widget.MediaController(this)
        val uri : Uri =  Uri.parse("android.resource://"+packageName+"/"+R.raw.practical7)
        binding.videoplayer.setMediaController(medialController)
        medialController.setAnchorView(binding.videoplayer)
        binding.videoplayer.setVideoURI(uri)
        binding.videoplayer.requestFocus()
        binding.videoplayer.start()
    }

}