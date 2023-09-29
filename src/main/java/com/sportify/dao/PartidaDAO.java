package com.sportify.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.sportify.model.Partida;

public class PartidaDAO {
	private Session session;
	
	public PartidaDAO(Session session) {
		this.session = session;
	}
	
	public void savePartida(Partida partida) {
        session.beginTransaction();
        session.save(partida);
        session.getTransaction().commit();
	}
	
    public String getNomeEquipeAByIdPartida(Long idPartida) {
        Query<String> query = session.createQuery(
            "SELECT e.nome FROM Equipe e INNER JOIN Partida p ON e.id = p.idEquipeA WHERE p.id = :idPartida",
            String.class
        );
        query.setParameter("idPartida", idPartida);

        return query.uniqueResult();
    }

    public String getNomeEquipeBByIdPartida(Long idPartida) {
        Query<String> query = session.createQuery(
            "SELECT e.nome FROM Equipe e INNER JOIN Partida p ON e.id = p.idEquipeB WHERE p.id = :idPartida",
            String.class
        );
        query.setParameter("idPartida", idPartida);

        return query.uniqueResult();
    }
}
