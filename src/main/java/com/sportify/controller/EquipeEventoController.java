package com.sportify.controller;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.sportify.dao.EquipeEventoDAO;
import com.sportify.model.EquipeEvento;

public class EquipeEventoController {
    private EquipeEventoDAO equipeEventoDAO;

    public EquipeEventoController(Session session) {
    	equipeEventoDAO = new EquipeEventoDAO(session);
    }

    public void createEquipeEvento(long idEquipe, long idEvento, Date dataInicio, Date dataFim) {
        EquipeEvento equipeEvento = new EquipeEvento();
        equipeEvento.setEquipeId(idEquipe);
        equipeEvento.setEventoId(idEvento);
        equipeEvento.setDataInicio(dataInicio);
        equipeEvento.setDataFim(dataFim);

        equipeEventoDAO.saveEquipeEvento(equipeEvento);
    }
    
    public List<Long> getIdEquipesByIdEvento(Long idEvento) {
        return equipeEventoDAO.getIdEquipesByIdEvento(idEvento);
    }
}
