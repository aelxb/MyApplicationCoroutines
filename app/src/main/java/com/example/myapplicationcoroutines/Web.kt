package com.example.myapplicationcoroutines

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class Web : AppCompatActivity(){
    var progbar: ProgressBar? = null
    lateinit var web: WebView
    var url  = "https://yandex.ru/"
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        progbar = findViewById<ProgressBar>(R.id.progressBar)
        web = findViewById<WebView>(R.id.WebView)
        web.webViewClient = myWebClient()
        web.loadUrl(url.toString())
        web.settings?.javaScriptEnabled = true
    }
    inner class myWebClient: WebViewClient(){
        override fun shouldOverrideUrlLoading(view: WebView, url:String): Boolean{
            progbar!!.visibility = View.VISIBLE
            CoroutineScope(Dispatchers.IO).launch {
                view.loadUrl(url)
            }
            return true
        }
        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?){
            progbar!!.visibility = View.VISIBLE
            super.onPageStarted(view, url, favicon)
        }
        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            progbar!!.visibility = View.GONE
        }
    }
}
