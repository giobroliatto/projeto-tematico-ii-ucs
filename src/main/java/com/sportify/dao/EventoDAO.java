package com.sportify.dao;

import org.hibernate.Session;

import com.sportify.model.Evento;

public class EventoDAO {
    private Session session;

    public EventoDAO(Session session) {
        this.session = session;
    }

    public void salvarEvento(Evento evento) {
        session.beginTransaction();
        session.save(evento);
        session.getTransaction().commit();
    }
}
