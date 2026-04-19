package org.example.br.com.alura.alugames.modelo

class Jogo(val titulo:String, val capa:String) {

    var descricao: String? = null

    override fun toString(): String {
        return "Meu jogo: \nTitulo $titulo \ncapa= $capa \ndescricao: $descricao \n"
    }

}