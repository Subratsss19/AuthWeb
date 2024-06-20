package com.skillmine.skillmineauthweb

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.net.http.SslError
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.SslErrorHandler
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.skillmine.webauthsdk.WebViewActivity
import java.io.Serializable

class MainActivity : AppCompatActivity() {
    private lateinit var loginButton: Button

    private val webViewActivityResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val accessToken = result.data?.getStringExtra("access_token")
                accessToken?.let {
                   startActivity(Intent(this@MainActivity, DashBoardActivity::class.java))
                    Log.v("ACCESS_TOKEN", accessToken)
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        loginButton = findViewById<Button>(R.id.bt_login)

        loginButton.setOnClickListener {
            val intent = Intent(this@MainActivity, WebViewActivity::class.java)
            webViewActivityResultLauncher.launch(intent)
        }
    }

}
