package com.sportify.dao;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.sportify.model.Evento;

public class EventoDAO {
    private Session session;

    public EventoDAO(Session session) {
        this.session = session;
    }

    public long saveEvento(Evento evento) {
        session.beginTransaction();
        long eventoId = (long) session.save(evento);
        session.getTransaction().commit();
        return eventoId;
    }

    public Evento getEvento(long id) {
        return session.get(Evento.class, id);
    }

    public void updateEvento(Evento evento) {
        session.beginTransaction();
        session.update(evento);
        session.getTransaction().commit();
    }
    
    public Long getIdByNome(String nome) {
        Query<Long> query = session.createQuery("SELECT id FROM Evento WHERE nome = :nome", Long.class);
        query.setParameter("nome", nome);
        return query.uniqueResult();
    }
    
    public Date getDataInicioById(long id) {
        Query<Date> query = session.createQuery("SELECT dataInicio FROM Evento WHERE id = :id", Date.class);
        query.setParameter("id", id);
        return query.uniqueResult();
    }

    public Date getDataFimById(long id) {
        Query<Date> query = session.createQuery("SELECT dataFim FROM Evento WHERE id = :id", Date.class);
        query.setParameter("id", id);
        return query.uniqueResult();
    }
}
