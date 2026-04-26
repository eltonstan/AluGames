package br.com.alura.alugames.principal

import br.com.alura.alugames.dados.Banco
import br.com.alura.alugames.dados.JogosDAO
import br.com.alura.alugames.modelo.Jogo

fun main() {

    val jogo = Jogo("Dandara",
        "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554",
        10.99,
        "XXXXX")

    val manager = Banco.getEntityManager()
    val jogosDAO = JogosDAO(manager)
    jogosDAO.adicionarJogo(jogo)

    val listaJogos: List<Jogo> = jogosDAO.getJogos()
    println(listaJogos)

    manager.close()
}