package com.sportify.controller;

import com.sportify.dao.EquipeDAO;
import com.sportify.model.Equipe;
import org.hibernate.Session;

public class EquipeController {
    private EquipeDAO equipeDAO;

    public EquipeController(Session session) {
        equipeDAO = new EquipeDAO(session);
    }

    public void criarEquipe(String nome) {
        // Criar uma instância de Equipe com o nome fornecido
        Equipe equipe = new Equipe();
        equipe.setNome(nome);

        // Usar o EquipeDAO para salvar a equipe no banco de dados
        equipeDAO.salvarEquipe(equipe);
    }
}
