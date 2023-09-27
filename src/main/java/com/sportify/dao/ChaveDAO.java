package com.sportify.dao;

import org.hibernate.Session;

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
}
