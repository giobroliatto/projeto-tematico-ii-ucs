package com.sportify.controller;

import com.sportify.dao.EquipeDAO;
import com.sportify.model.Equipe;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;

public class EquipeController {
    private EquipeDAO equipeDAO;

    public EquipeController(Session session) {
        equipeDAO = new EquipeDAO(session);
    }

    public void createEquipe(String nome) {
        Equipe equipe = new Equipe();
        equipe.setNome(nome);
        equipeDAO.saveEquipe(equipe);
    }
    
    public void updateEquipe(Long id, String nome) {
    	Equipe equipe = equipeDAO.getEquipeById(id);
    	if(equipe != null) {
    		equipe.setNome(nome);
    		equipeDAO.updateEquipe(equipe);
    	}
    }
    
    public void removeEquipe(Long id) {
    	System.out.println(id);
    	if(id != null) {
    		equipeDAO.removeEquipe(id);
    	}
    }
    
    public List<Equipe> getEquipes() {
        return equipeDAO.getEquipes();
    }
    
    public List<Equipe> getEquipesDisponiveis(Date dataInicioNovoEvento, Date dataFimNovoEvento) {
    	return equipeDAO.getEquipesDisponiveis(dataInicioNovoEvento, dataFimNovoEvento);
    }
    
    public Long getIdByNome(String nome) {
        return equipeDAO.getIdByNome(nome);
    }

    public String validateNomeEquipe(String nome) {
        if (nome == null || nome.isEmpty()) {
            return "O nome da equipe não pode estar vazio.";
        }

        Long id = getIdByNome(nome);
        if (id != null) {
            return "Equipe '" + nome + "' já cadastrada.";
        }

        return null;
    }
}
