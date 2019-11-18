package br.com.impacta.kotlin.carrosimpacta.activities

import android.os.Bundle
import br.com.impacta.kotlin.carrosimpacta.R
import br.com.impacta.kotlin.carrosimpacta.domains.carro.Carro
import br.com.impacta.kotlin.carrosimpacta.extensions.loadUrl
import br.com.impacta.kotlin.carrosimpacta.extensions.setupToolbar
import kotlinx.android.synthetic.main.activity_carro.*
import android.content.Intent
import android.view.MenuItem


class CarroActivity : BaseActivity() {

    val carro : Carro by lazy {
        intent.getSerializableExtra("carro") as Carro
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carro)
        setupToolbar(R.id.toolbar, carro.nome, true)

        tDescricaoDetalhe.text = carro.descricao
        imagemCarroDetalhe.loadUrl(carro.urlFoto)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home -> {
                // app icon in action bar clicked; go home
//                val intent = Intent(this, CarrosActivity::class.java)
//                intent.putExtra("tipo", )
//                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}