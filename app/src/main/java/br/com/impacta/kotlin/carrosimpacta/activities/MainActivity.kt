package br.com.impacta.kotlin.carrosimpacta.activities

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import android.view.MenuItem
import android.view.Menu
import androidx.core.content.ContextCompat
import br.com.impacta.kotlin.carrosimpacta.R
import br.com.impacta.kotlin.carrosimpacta.adapters.TabAdapter
import br.com.impacta.kotlin.carrosimpacta.extensions.setupToolbar
import kotlinx.android.synthetic.main.app_bar_main.*


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupToolbar(R.id.toolbar)
        setupNavDrawer()
        setupViewPagerTabs()

        fab.setOnClickListener {
            val snack = Snackbar.make(it, "Cliclou no botão Float", Snackbar.LENGTH_LONG)
            snack.show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setupViewPagerTabs(){
        viewPager.offscreenPageLimit = 2
        viewPager.adapter = TabAdapter(context, supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
        val cor = ContextCompat.getColor(context, R.color.white)
        tabLayout.setTabTextColors(cor, cor)
    }
}
