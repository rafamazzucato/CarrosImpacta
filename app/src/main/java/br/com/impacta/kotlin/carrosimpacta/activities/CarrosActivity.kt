package br.com.impacta.kotlin.carrosimpacta.activities

import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.impacta.kotlin.carrosimpacta.R
import br.com.impacta.kotlin.carrosimpacta.adapters.CarroAdapter
import br.com.impacta.kotlin.carrosimpacta.domains.carro.Carro
import br.com.impacta.kotlin.carrosimpacta.domains.carro.CarroService
import br.com.impacta.kotlin.carrosimpacta.enums.TipoCarro
import br.com.impacta.kotlin.carrosimpacta.extensions.setupToolbar
import kotlinx.android.synthetic.main.activity_carros.*
import org.jetbrains.anko.toast

class CarrosActivity : BaseActivity() {

    private var tipo : TipoCarro = TipoCarro.CLASSICOS
    private lateinit var carros : List<Carro>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carros)

        this.tipo = intent.getSerializableExtra("tipo") as TipoCarro
        val title = getString(tipo.value)
        setupToolbar(R.id.toolbar, title, true)

        recycleCarros.layoutManager = LinearLayoutManager(context)
        recycleCarros.itemAnimator = DefaultItemAnimator()
        recycleCarros.setHasFixedSize(true)
    }

    override fun onResume() {
        super.onResume()
        taskCarros()
    }

    private fun taskCarros(){
        this.carros = CarroService.getCarros(context, tipo)
        recycleCarros.adapter = CarroAdapter(this.carros, this::onClickCarro)
    }

    private fun onClickCarro (carro : Carro){
        toast("@Clicou no carro ${carro.nome}")
    }

}