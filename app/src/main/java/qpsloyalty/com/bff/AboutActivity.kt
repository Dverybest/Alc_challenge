package qpsloyalty.com.bff

import android.annotation.SuppressLint
import android.net.http.SslError
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.*
import android.widget.ProgressBar
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        supportActionBar!!.setHomeButtonEnabled(true);
        webView.loadUrl("https://www.andela.com/alc/")
        webView.webViewClient = object : WebViewClient(){
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                progressBar.visibility =View.GONE
            }

            override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
                super.onReceivedSslError(view, handler, error)
                handler!!.proceed()
            }

            override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
                super.onReceivedError(view, request, error)
                Log.e("h",error.toString())
            }

            override fun onLoadResource(view: WebView?, url: String?) {
                super.onLoadResource(view, url)
                progressBar.visibility =View.VISIBLE
            }
        }
        webView.settings.javaScriptEnabled = true

    }

    override fun onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack()
            return
        }
        super.onBackPressed()
    }

}
