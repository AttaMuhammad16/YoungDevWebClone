package com.atta.youngdevwebclone

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.atta.youngdevwebclone.ui.theme.YoungDevWebCloneTheme

class MainActivity : ComponentActivity() {
    lateinit var webVie:WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            YoungDevWebCloneTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    WebViewScreen(innerPadding)
                }
            }
        }
    }


    @SuppressLint("SetJavaScriptEnabled")
    @Composable
    fun WebViewScreen(innerPadding:PaddingValues) {
        AndroidView(
            factory = { context ->
                WebView(context).apply {
                    settings.javaScriptEnabled = true
                    webViewClient = WebViewClient()

                    settings.loadWithOverviewMode = true
                    settings.useWideViewPort = true
                    settings.setSupportZoom(true)
                }
            },
            update = { webView ->
                webView.loadUrl("https://young-dev-interns.github.io/Devinterns")
                webVie=webView
            },
        )
    }

    override fun onBackPressed() {
        if (webVie.canGoBack()){
            webVie.goBack()
        }else{
            super.onBackPressed()
        }
    }


}



