package org.example.br.com.alura.alugames.principal

import org.example.br.com.alura.alugames.modelo.Jogo
import org.example.br.com.alura.alugames.servicos.ConsumoApi
import java.util.*

fun main() {

    val leitura = Scanner(System.`in`)
    println("Digite um código de jogo para buscar:")
    val busca = leitura.nextLine()

    var meuJogo: Jogo? = null
    val resultado = runCatching {
        val buscaApi = ConsumoApi()
        meuJogo = buscaApi.buscaJogo(busca)
    }

    resultado.onFailure {
        println("Jogo inexistente. Tente outro id.")
    }

    resultado.onSuccess {
        println("Deseja inserir uma descrição personalizada? S/N")
        val opcao = leitura.nextLine()
        if (opcao.equals("s", true)) {
            println("Insira a descrição personalizada para o jogo:")
            val descricaoPersonalizada = leitura.nextLine()
            meuJogo?.descricao = descricaoPersonalizada
        } else {
            meuJogo?.descricao = meuJogo.titulo
        }
        println(meuJogo)
    }

    resultado.onSuccess {
        println("Busca finalizada com sucesso!")
    }

}