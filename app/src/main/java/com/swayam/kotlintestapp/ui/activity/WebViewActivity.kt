package com.swayam.kotlintestapp.ui.activity

class WebViewActivity : android.support.v7.app.AppCompatActivity() {

    var webView : android.webkit.WebView? = null
    var etURL : android.widget.EditText? = null

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.swayam.kotlintestapp.R.layout.activity_web_view)

        etURL = findViewById(com.swayam.kotlintestapp.R.id.etURL) as android.widget.EditText

        webView = findViewById(com.swayam.kotlintestapp.R.id.webView) as android.webkit.WebView
        webView!!.setWebViewClient(com.swayam.kotlintestapp.ui.activity.WebViewActivity.Browser())
    }

    fun load(view : android.view.View) {

        val url = etURL!!.text.toString().trim()

        if (!android.text.TextUtils.isEmpty(url))
            webView!!.settings.loadsImagesAutomatically = true
            webView!!.settings.javaScriptEnabled = true
            webView!!.loadUrl(url)

    }

    @Suppress("DEPRECATION", "OverridingDeprecatedMember")
    class Browser : android.webkit.WebViewClient() {

        override fun shouldOverrideUrlLoading(view: android.webkit.WebView?, url: String?): Boolean {
            view!!.loadUrl(url)
            return true
        }
    }
}
