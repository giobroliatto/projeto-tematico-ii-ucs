package com.sportify.controller;

import com.sportify.dao.EquipeDAO;
import com.sportify.model.Equipe;
import org.hibernate.Session;

import java.util.List;

public class EquipeController {
    private EquipeDAO equipeDAO;

    public EquipeController(Session session) {
        equipeDAO = new EquipeDAO(session);
    }

    public void criarEquipe(String nome) {
        Equipe equipe = new Equipe();
        equipe.setNome(nome);

        equipeDAO.salvarEquipe(equipe);
    }
    
    public List<Equipe> getEquipes() {
        return equipeDAO.getEquipes();
    }

    public List<Equipe> getEquipesByIds(List<Long> ids) {
        return equipeDAO.getEquipesByIds(ids);
    }
    
    public Long getPeloNome(String nome) {
        return equipeDAO.getIdDaEquipePeloNome(nome);
    }
}
