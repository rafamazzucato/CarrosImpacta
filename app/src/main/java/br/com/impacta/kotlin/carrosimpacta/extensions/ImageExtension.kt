package br.com.impacta.kotlin.carrosimpacta.extensions

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

fun ImageView.loadUrl(url : String, progressBar: ProgressBar? = null){
    if(progressBar == null){
        Picasso.get().load(url).fit().into(this)
    }else{
        Picasso.get().load(url).fit().into(this, object : Callback {
            override fun onSuccess() {
                progressBar.visibility = View.GONE
            }

            override fun onError(e: Exception?) {
                progressBar.visibility = View.GONE
            }
        })
    }
}