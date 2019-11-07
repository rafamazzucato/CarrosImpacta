package br.com.impacta.kotlin.carrosimpacta.extensions


import android.app.Activity
import android.view.View
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

fun Activity.onClick(@IdRes viewId : Int, onClick : (v : View?) -> Unit){
    val view = findViewById<View>(viewId)
    view.setOnClickListener{ onClick(it)}
}

fun AppCompatActivity.setupToolbar(@IdRes viewId : Int, title : String? = null, upNavigationBar : Boolean = false) : ActionBar {
    val toolbar = findViewById<Toolbar>(viewId)
    setSupportActionBar(toolbar)

    if(title != null){
        supportActionBar?.title = title
    }

    supportActionBar?.setDisplayHomeAsUpEnabled(upNavigationBar)
    return supportActionBar!!
}

fun AppCompatActivity.addFragment(@IdRes layoutId : Int, fragment : Fragment){
    fragment.arguments = intent.extras
    val ft = supportFragmentManager.beginTransaction()
    ft.add(layoutId, fragment)
    ft.commit()
}
