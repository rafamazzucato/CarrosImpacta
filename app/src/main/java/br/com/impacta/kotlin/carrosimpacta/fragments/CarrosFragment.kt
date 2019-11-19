package br.com.impacta.kotlin.carrosimpacta.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.impacta.kotlin.carrosimpacta.R
import br.com.impacta.kotlin.carrosimpacta.activities.CarroActivity
import br.com.impacta.kotlin.carrosimpacta.adapters.CarroAdapter
import br.com.impacta.kotlin.carrosimpacta.domains.carro.Carro
import br.com.impacta.kotlin.carrosimpacta.domains.carro.CarroService
import br.com.impacta.kotlin.carrosimpacta.enums.TipoCarro
import kotlinx.android.synthetic.main.fragment_carros.*
import org.jetbrains.anko.startActivity

class CarrosFragment : BaseFragment() {

    private var tipo : TipoCarro = TipoCarro.CLASSICOS
    private lateinit var carros : List<Carro>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_carros, container, false)

        this.tipo = arguments?.getSerializable("tipo") as TipoCarro
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycleFragmentCarros.layoutManager = LinearLayoutManager(context)
        recycleFragmentCarros.itemAnimator = DefaultItemAnimator()
        recycleFragmentCarros.setHasFixedSize(true)
    }

    override fun onResume() {
        super.onResume()
        taskCarros()
    }

    private fun taskCarros(){
        this.carros = CarroService.getCarros(context!!, tipo)
        recycleFragmentCarros.adapter = CarroAdapter(this.carros, this::onClickCarro)
    }

    private fun onClickCarro (carro : Carro){
        activity!!.startActivity<CarroActivity>("carro" to carro)
    }
}