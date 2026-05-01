package br.com.alura.alugames.principal

import br.com.alura.alugames.dados.Banco
import br.com.alura.alugames.dados.JogosDAO
import br.com.alura.alugames.modelo.Jogo

fun main() {

    val jogo = Jogo("Dandara2",
        "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554",
        10.99,
        "XXXXX")

    val manager = Banco.getEntityManager()
    val jogoDAO = JogosDAO(manager)
    // jogoDAO.adicionar(jogo)

    val jogoRecuperado = jogoDAO.recuperarPeloId(4)
    println(jogoRecuperado)

    jogoDAO.apagar(4)

    val listaJogos: List<Jogo> = jogoDAO.getLista()
    println(listaJogos)

    manager.close()
}