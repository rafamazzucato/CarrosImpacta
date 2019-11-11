package br.com.impacta.kotlin.carrosimpacta.domains.carro

import java.io.Serializable

class Carro(
    var id:Long = 0,
    var tipo:String = "",
    var nome:String,
    var descricao:String,
    var urlFoto:String,
    var urlInfo:String = "",
    var urlVideo:String = "",
    var latitude:String = "",
    var longitude:String = ""
) : Serializable {

    override fun toString(): String {
        return "Carro(nome='$nome')"
    }


}
