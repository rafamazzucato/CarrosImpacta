package br.com.impacta.kotlin.carrosimpacta.extensions

import android.app.Activity
import android.view.View
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

fun Activity.onClick(@IdRes viewId : Int, onClick : (v : View?) -> Unit){
    val view = findViewById<View>(viewId)
    view.setOnClickListener{ onClick(it)}
}

fun Activity.toast(message : CharSequence, length : Int = Toast.LENGTH_SHORT){
    Toast.makeText(this, message, length).show()
}

fun Activity.toast(@StringRes message: Int, length : Int = Toast.LENGTH_SHORT){
    Toast.makeText(this, message, length).show()
}

fun AppCompatActivity.setupToolbar(@IdRes viewId : Int, title : String? = null, upNavigationBar : Boolean = false) : Toolbar {
    val toolbar = findViewById<Toolbar>(viewId)
    setSupportActionBar(toolbar)

    if(title != null){
        supportActionBar?.title = title
    }

    supportActionBar?.setDisplayHomeAsUpEnabled(upNavigationBar)
    return toolbar
}

fun AppCompatActivity.addFragment(@IdRes layoutId : Int, fragment : Fragment){
    fragment.arguments = intent.extras
    val ft = supportFragmentManager.beginTransaction()
    ft.add(layoutId, fragment)
    ft.commit()
}
