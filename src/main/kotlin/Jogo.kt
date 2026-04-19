package org.example

class Jogo(val titulo:String, val capa:String) {

    val descricao = ""

    override fun toString(): String {
        return "Meu jogo: \nTitulo $titulo \ncapa= $capa \ndescricao: $descricao \n"
    }

}