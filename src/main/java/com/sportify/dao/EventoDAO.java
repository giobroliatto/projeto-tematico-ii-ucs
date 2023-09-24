package com.sportify.dao;

import org.hibernate.Session;

import com.sportify.model.Evento;

public class EventoDAO {
    private Session session;

    public EventoDAO(Session session) {
        this.session = session;
    }

    public long salvarEvento(Evento evento) {
        session.beginTransaction();
        long eventoId = (long) session.save(evento);
        session.getTransaction().commit();
        return eventoId;
    }

    public Evento getEvento(long id) {
        return session.get(Evento.class, id);
    }

    public void atualizarEvento(Evento evento) {
        session.beginTransaction();
        session.update(evento);
        session.getTransaction().commit();
    }
}
