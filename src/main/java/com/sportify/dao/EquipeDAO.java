package com.sportify.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.sportify.model.Equipe;

import java.util.List;

public class EquipeDAO {
    private Session session;

    public EquipeDAO(Session session) {
        this.session = session;
    }

    public void saveEquipe(Equipe equipe) {
        session.beginTransaction();
        session.save(equipe);
        session.getTransaction().commit();
    }
    
    public void updateEquipe(Equipe equipe) {
        session.beginTransaction();
        session.update(equipe);
        session.getTransaction().commit();
    }

    public List<Equipe> getEquipes() {
        Query<Equipe> query = session.createQuery("FROM Equipe", Equipe.class);
        return query.list();
    }

    public List<Equipe> getEquipesByIds(List<Long> ids) {
        Query<Equipe> query = session.createQuery("FROM Equipe WHERE id IN (:ids)", Equipe.class);
        query.setParameterList("ids", ids);
        return query.list();
    }
    
    public Long getIdByNome(String nome) {
        Query<Long> query = session.createQuery("SELECT id FROM Equipe WHERE nome = :nome", Long.class);
        query.setParameter("nome", nome);
        return query.uniqueResult();
    }
}
