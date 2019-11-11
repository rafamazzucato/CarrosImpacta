package br.com.impacta.kotlin.carrosimpacta.domains.carro

import android.content.Context
import br.com.impacta.kotlin.carrosimpacta.enums.TipoCarro

object CarroService {
    fun getCarros(context: Context, tipoCarro: TipoCarro) : List<Carro>{
        val tipoString = context.getString(tipoCarro.value)

        val carros = mutableListOf<Carro>()

        for(i in 1..20){
            val carro = Carro(
                nome = "Carro $tipoString: $i",
                descricao = "Desc $i",
                urlFoto = "http://www.livroandroid.com.br/livro/carros/esportivos/Ferrari_FF.png"
            )
            carros.add(carro)
        }

        return carros
    }
}