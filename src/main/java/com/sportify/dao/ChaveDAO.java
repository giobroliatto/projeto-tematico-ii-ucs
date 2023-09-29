package com.sportify.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;

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
}
