package br.com.alura.alugames.dados

import br.com.alura.alugames.modelo.Gamer
import br.com.alura.alugames.utilitario.toEntity
import br.com.alura.alugames.utilitario.toModel
import javax.persistence.EntityManager

class GamersDAO(manager: EntityManager): DAO<Gamer, GamerEntity>(manager, GamerEntity::class.java) {

    override fun toEntity(objeto: Gamer): GamerEntity {
        return objeto.toEntity()
    }

    override fun toModel(entity: GamerEntity): Gamer {
        return entity.toModel().apply { plano = entity.plano.toModel() }
    }

//    fun getGamers(): List<Gamer> {
//        val query = manager.createQuery("FROM GamerEntity", GamerEntity::class.java)
//        return query.resultList.map { entity -> Gamer(entity.nome, entity.email, entity.dataNascimento, entity.usuario, entity.id) }
//    }
//
//    fun adicionarGamer(gamer: Gamer) {
//        val entity = GamerEntity(gamer.id, gamer.nome, gamer.email, gamer.dataNascimento, gamer.usuario)
//        manager.transaction.begin()
//        manager.persist(entity)
//        manager.transaction.commit()
//    }
}