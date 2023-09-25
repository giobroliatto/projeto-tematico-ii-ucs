package com.sportify.controller;

import java.util.Date;

import org.hibernate.Session;

import com.sportify.dao.EquipeEventoDAO;
import com.sportify.model.EquipeEvento;

public class EquipeEventoController {
    private EquipeEventoDAO equipeEventoDAO;

    public EquipeEventoController(Session session) {
    	equipeEventoDAO = new EquipeEventoDAO(session);
    }

    public void createEquipeEvento(long equipeid, long eventoid, Date dataInicio, Date dataFim) {
        EquipeEvento equipeEvento = new EquipeEvento();
        equipeEvento.setEquipeId(equipeid);
        equipeEvento.setEventoId(eventoid);
        equipeEvento.setDataInicio(dataInicio);
        equipeEvento.setDataFim(dataFim);

        equipeEventoDAO.saveEquipeEvento(equipeEvento);
    }
}
