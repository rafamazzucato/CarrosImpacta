package br.com.impacta.kotlin.carrosimpacta.activities

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import br.com.impacta.kotlin.carrosimpacta.R
import br.com.impacta.kotlin.carrosimpacta.activities.dialogs.SobreDialog
import br.com.impacta.kotlin.carrosimpacta.extensions.setupToolbar
import kotlinx.android.synthetic.main.activity_site_livro.*

class SiteLivroActivity : BaseActivity() {

    private val URL_SOBRE = "http://www.livroandroid.com.br/sobre.htm"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_site_livro)
        setupToolbar(R.id.toolbar, "Sobre o Livro", true)
        setWebViewClient()

        swipeToRefreshSite.setOnRefreshListener {
            webViewSiteLivros.reload()
        }

        swipeToRefreshSite.setColorSchemeResources(
            R.color.refresh_progress_1,
            R.color.refresh_progress_2,
            R.color.refresh_progress_3)
    }

    private fun setWebViewClient(){
        webViewSiteLivros.webViewClient = object : WebViewClient(){
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                progressBarSiteLivros.visibility = View.VISIBLE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                progressBarSiteLivros.visibility = View.GONE
                swipeToRefreshSite.isRefreshing = false
            }

            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                val url = request?.url.toString()

                if(url.endsWith("sobre.htm")){
                    SobreDialog.showSobre(supportFragmentManager)
                    return true
                }

                return super.shouldOverrideUrlLoading(view, request)
            }
        }

        webViewSiteLivros.loadUrl(URL_SOBRE)
    }
}