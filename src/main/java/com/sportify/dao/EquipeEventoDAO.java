package com.sportify.dao;

import org.hibernate.Session;
import com.sportify.model.EquipeEvento;

public class EquipeEventoDAO {
    private Session session;

    public EquipeEventoDAO(Session session) {
        this.session = session;
    }

    public void saveEquipeEvento(EquipeEvento equipeEvento) {
        session.beginTransaction();
        session.save(equipeEvento);
        session.getTransaction().commit();
    }

    public void updateEquipeEvento(EquipeEvento equipeEvento) {
        session.beginTransaction();
        session.update(equipeEvento);
        session.getTransaction().commit();
    }

    public void deleteEquipeEvento(EquipeEvento equipeEvento) {
        session.beginTransaction();
        session.delete(equipeEvento);
        session.getTransaction().commit();
    }

    public EquipeEvento getEquipeEventoById(Long id) {
        return session.get(EquipeEvento.class, id);
    }
}
