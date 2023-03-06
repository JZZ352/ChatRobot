package com.example.chatrobot

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView

    @SuppressLint("ResourceType", "SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //将应用程序窗口标记为全屏窗口，以隐藏状态栏和其他系统UI元素
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_main)
        //设置入场动画
        val imageView = findViewById<ImageView>(R.id.animation_view)
        val animation = AnimationUtils.loadAnimation(this, R.anim.animation)
        val webView = findViewById<WebView>(R.id.webView)
        animation.duration = 5000

        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {
                imageView.visibility = View.GONE
                webView.visibility = View.VISIBLE
            }

            override fun onAnimationRepeat(animation: Animation?) {}

        })
        imageView.startAnimation(animation)
        //设置进入时需要网络，不然无法进入网址
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.settings.javaScriptEnabled = true

        webView.loadUrl("https://chat.theb.ai")
    }
}