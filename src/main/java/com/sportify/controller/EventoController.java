package com.sportify.controller;

import com.sportify.dao.EventoDAO;
import com.sportify.model.Evento;

import java.util.Date;

import org.hibernate.Session;

public class EventoController {
    private EventoDAO eventoDAO;

    public EventoController(Session session) {
        eventoDAO = new EventoDAO(session);
    }

    public long createEvento(String nome, String local, Date dataInicio, Date dataFim, String esporte) {
        Evento evento = new Evento();
        evento.setNome(nome);
        evento.setLocal(local);
        evento.setDataInicio(dataInicio);
        evento.setDataFim(dataFim);
        evento.setEsporte(esporte);

        return eventoDAO.saveEvento(evento);
    }
    
    public Long getIdByNome(String nome) {
        return eventoDAO.getIdByNome(nome);
    }
    
    public Date getDataInicioById(long id) {
    	return eventoDAO.getDataInicioById(id);
    }
    
    public Date getDataFimById(long id) {
    	return eventoDAO.getDataFimById(id);
    }
    
    public String validateEvento(String nome, String local, Date dataInicio, Date dataFim, String esporte) {
        if (nome == null || nome.isEmpty()) {
            return "O nome do evento não pode estar vazio.";
        }

        if (local == null || local.isEmpty()) {
            return "O local do evento não pode estar vazio.";
        }

        if (dataInicio == null) {
            return "A data de início do evento não pode estar vazia.";
        }

        if (dataFim == null) {
            return "A data final do evento não pode estar vazia.";
        }

        if (esporte == null || esporte.isEmpty()) {
            return "O esporte do evento não pode estar vazio.";
        }

        if (dataFim.before(dataInicio)) {
            return "A data final não pode ser anterior à data de início.";
        }
        
        Long id = getIdByNome(nome);
        if (id != null) {
            return "Evento '" + nome + "' já cadastrado.";
        }

        return null;
    }

}
