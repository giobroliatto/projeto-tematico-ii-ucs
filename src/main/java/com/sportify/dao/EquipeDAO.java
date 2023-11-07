package com.sportify.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.sportify.model.Equipe;

import java.util.Date;
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
    
    public void removeEquipe(Long id) {
        session.beginTransaction();
        Equipe equipe = session.get(Equipe.class, id); /* CARREGA A ENTIDADE A SER REMOVIDA */
        if (equipe != null) {
            session.delete(equipe); /* REMOVE A ENTIDADE */
        }
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
    
    public List<Equipe> getEquipesDisponiveis(Date dataInicioNovoEvento, Date dataFimNovoEvento) {
        String hql = "SELECT DISTINCT e FROM Equipe e " +
                     "LEFT JOIN EquipeEvento ee ON e.id = ee.idEquipe " +
                     "LEFT JOIN Evento ev ON ee.idEvento = ev.id " +
                     "WHERE " +
                     "(ee.id IS NULL) OR " +
                     "(ee.id IS NOT NULL AND " +
                     "(ev.dataInicio > :dataFimNovoEvento OR ev.dataFim < :dataInicioNovoEvento)) " +
                     "ORDER BY e.nome ASC";

        Query<Equipe> query = session.createQuery(hql, Equipe.class);
        query.setParameter("dataInicioNovoEvento", dataInicioNovoEvento);
        query.setParameter("dataFimNovoEvento", dataFimNovoEvento);

        return query.list();
    }
    
    public Long getIdByNome(String nome) {
        Query<Long> query = session.createQuery("SELECT id FROM Equipe WHERE nome = :nome", Long.class);
        query.setParameter("nome", nome);
        return query.uniqueResult();
    }
    
    public Equipe getEquipeById(Long id) {
        return session.get(Equipe.class, id);
    }
    
    public List<Long> buscaRelacionamento(long idEquipe) {
    	Query<Long> query = session.createQuery("SELECT id FROM EquipeEvento WHERE idequipe = :idequipe", Long.class);
    	query.setParameter("idequipe", idEquipe);
    	return query.list();
    }
}
