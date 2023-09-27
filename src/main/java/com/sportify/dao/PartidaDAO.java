package com.sportify.dao;

import org.hibernate.Session;

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
}
