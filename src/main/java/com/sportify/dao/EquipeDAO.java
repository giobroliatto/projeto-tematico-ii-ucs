package com.sportify.dao;

import org.hibernate.Session;

import com.sportify.model.Equipe;

public class EquipeDAO {
    private Session session;

    public EquipeDAO(Session session) {
        this.session = session;
    }

    public void salvarEquipe(Equipe equipe) {
        session.beginTransaction();
        session.save(equipe);
        session.getTransaction().commit();
    }
}
