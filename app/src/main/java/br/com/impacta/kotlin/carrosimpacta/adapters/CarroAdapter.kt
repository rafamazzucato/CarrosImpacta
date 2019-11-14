package br.com.impacta.kotlin.carrosimpacta.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.impacta.kotlin.carrosimpacta.R
import br.com.impacta.kotlin.carrosimpacta.domains.carro.Carro
import br.com.impacta.kotlin.carrosimpacta.extensions.loadUrl
import kotlinx.android.synthetic.main.adapter_carro.view.*

class CarroAdapter(
    val carros : List<Carro>,
    val onClick: (Carro) -> Unit)
    : RecyclerView.Adapter<CarroAdapter.VHCarro>() {

    class VHCarro(view: View) : RecyclerView.ViewHolder(view){}

    override fun getItemCount() = this.carros.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHCarro {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_carro, parent, false)
        return VHCarro(view)
    }

    override fun onBindViewHolder(holder: VHCarro, position: Int) {
        val carro = carros[position]

        val view = holder.itemView
        view.textCarroNome.text = carro.nome
        view.progressCarro.visibility = View.VISIBLE

        if(!carro.urlFoto.trim().isEmpty()){
            view.imagemCarro.loadUrl(carro.urlFoto, view.progressCarro)
        }

        holder.itemView.setOnClickListener{onClick(carro)}
    }
}