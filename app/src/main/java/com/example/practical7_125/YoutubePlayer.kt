package com.example.practical7_125

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebViewClient
import com.example.practical7_125.databinding.ActivityMainBinding
import com.example.practical7_125.databinding.ActivityYoutubePlayerBinding

class YoutubePlayer : AppCompatActivity() {
    private lateinit var binding: ActivityYoutubePlayerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtube_player)
        binding = ActivityYoutubePlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        youtubeplay()
        binding.play1.setOnClickListener{
            Intent(this,MainActivity::class.java).also { startActivity(it) }
        }
    }
    private fun youtubeplay(){
        val youtubeId = "MlJfixx2dAM"
        val webSettings: WebSettings = binding.webview1.settings
        webSettings.javaScriptEnabled = true
        webSettings.loadWithOverviewMode = true
        webSettings.useWideViewPort = true
        binding.webview1.webViewClient = WebViewClient()
        binding.webview1.loadUrl("https://www.youtube.com/embed/$youtubeId")
    }
}