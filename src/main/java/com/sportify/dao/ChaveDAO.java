package com.sportify.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.sportify.dto.IdPartidasDTO;
import com.sportify.model.Chave;

public class ChaveDAO {
	private Session session;
	
	public ChaveDAO(Session session) {
		this.session = session;
	}
	
	public void saveChave(Chave chave) {
        session.beginTransaction();
        session.save(chave);
        session.getTransaction().commit();
	}
	
    public Long getIdChaveByIdEvento(Long idEvento) {
        Query<Long> query = session.createQuery(
            "SELECT c.id FROM Chave c WHERE c.idEvento = :idEvento", Long.class);
        query.setParameter("idEvento", idEvento);

        Long chaveId = query.uniqueResult();
        return chaveId;
    }
    
    public IdPartidasDTO getIdPartidasByIdEvento(Long idEvento) {
        Query<IdPartidasDTO> query = session.createQuery(
            "SELECT new com.sportify.dto.IdPartidasDTO(" +
            "c.idPartida1Oitavas, c.idPartida2Oitavas, c.idPartida3Oitavas, c.idPartida4Oitavas, " +
            "c.idPartida5Oitavas, c.idPartida6Oitavas, c.idPartida7Oitavas, c.idPartida8Oitavas, " +
            "c.idPartida1Quartas, c.idPartida2Quartas, c.idPartida3Quartas, c.idPartida4Quartas, " +
            "c.idPartida1Semi, c.idPartida2Semi, c.idPartidaFinal) " +
            "FROM Chave c WHERE c.idEvento = :idEvento", IdPartidasDTO.class);
        query.setParameter("idEvento", idEvento);

        return query.uniqueResult();
    }

}
