package br.com.impacta.kotlin.carrosimpacta.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import br.com.impacta.kotlin.carrosimpacta.R
import br.com.impacta.kotlin.carrosimpacta.enums.TipoCarro
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.include_toolbar.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    protected val context : Context get() = this

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_item_carros_classicos -> {
                startActivity<CarrosActivity>("tipo" to TipoCarro.CLASSICOS)
            }
            R.id.nav_item_carros_esportivos -> {
                startActivity<CarrosActivity>("tipo" to TipoCarro.ESPORTIVOS)
            }
            R.id.nav_item_carros_luxo -> {
                startActivity<CarrosActivity>("tipo" to TipoCarro.LUXO)
            }
            R.id.nav_item_carros_todos -> {
                toast("Todos")
            }
            R.id.nav_item_settings -> {
                toast("Configurações")
            }
            R.id.nav_item_site_livro -> {
                toast("Site Livro")
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    protected fun setupNavDrawer(){
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }
}