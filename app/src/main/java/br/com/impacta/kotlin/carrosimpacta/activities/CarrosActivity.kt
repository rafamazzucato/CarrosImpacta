package br.com.impacta.kotlin.carrosimpacta.activities

import android.os.Bundle
import br.com.impacta.kotlin.carrosimpacta.R
import br.com.impacta.kotlin.carrosimpacta.enums.TipoCarro
import br.com.impacta.kotlin.carrosimpacta.extensions.setupToolbar
import br.com.impacta.kotlin.carrosimpacta.fragments.CarrosFragment

class CarrosActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carros)

        val tipo = intent.getSerializableExtra("tipo") as TipoCarro
        val title = getString(tipo.value)
        setupToolbar(R.id.toolbar, title, true)

        if(savedInstanceState == null){
            val frag = CarrosFragment()
            frag.arguments = intent.extras

            supportFragmentManager.beginTransaction().add(R.id.frameLayoutCarros, frag).commit()
        }
    }
}