package org.example.br.com.alura.alugames.servicos

import com.google.gson.Gson
import org.example.br.com.alura.alugames.modelo.InfoJogo
import org.example.br.com.alura.alugames.modelo.Jogo
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class ConsumoApi {

    fun buscaJogo(id: String): Jogo {
        val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()
        val response = client
            .send(request, BodyHandlers.ofString())
        val json = response.body()
        val gson = Gson()
        var meuJogo: Jogo? = null
        val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)
        meuJogo = Jogo(
            meuInfoJogo.info.title,
            meuInfoJogo.info.thumb
        )
        return meuJogo
    }


}