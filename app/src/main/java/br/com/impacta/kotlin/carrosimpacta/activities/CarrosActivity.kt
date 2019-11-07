package br.com.impacta.kotlin.carrosimpacta.activities

import android.os.Bundle
import br.com.impacta.kotlin.carrosimpacta.R
import br.com.impacta.kotlin.carrosimpacta.enums.TipoCarro
import br.com.impacta.kotlin.carrosimpacta.extensions.setupToolbar
import kotlinx.android.synthetic.main.activity_carros.*

class CarrosActivity : BaseActivity() {

    private var tipo : TipoCarro = TipoCarro.CLASSICOS

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carros)

        this.tipo = intent.getSerializableExtra("tipo") as TipoCarro
        val title = getString(tipo.value)
        setupToolbar(R.id.toolbar, title, true)

        carrosText.setText("Carros $title")
    }
}