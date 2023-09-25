package com.sportify.controller;

import com.sportify.dao.EventoDAO;
import com.sportify.dao.EquipeDAO;
import com.sportify.model.Evento;
import com.sportify.model.Equipe;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

public class EventoController {
    private EventoDAO eventoDAO;
    private EquipeDAO equipeDAO;

    public EventoController(Session session) {
        eventoDAO = new EventoDAO(session);
        equipeDAO = new EquipeDAO(session);
    }

    public long createEvento(String nome, String local, Date dataInicio, String esporte) {
        Evento evento = new Evento();
        evento.setNome(nome);
        evento.setLocal(local);
        evento.setDataInicio(dataInicio);
        evento.setEsporte(esporte);

        return eventoDAO.saveEvento(evento);
    }
    
    public Long getIdByNome(String nome) {
        return eventoDAO.getIdByNome(nome);
    }

    public void linkEquipesToEvento(long eventoId, List<Long> equipeIds) {
        Evento evento = eventoDAO.getEvento(eventoId);

        if (evento != null) {
            List<Equipe> equipesSelecionadas = equipeDAO.getEquipesByIds(equipeIds);

            for (Equipe equipe : equipesSelecionadas) {
                equipe.setEventoId(eventoId);
                equipeDAO.updateEquipe(equipe);
            }
        }
    }

    public String validateEvento(String nome, String local, Date dataInicio, String esporte) {
        if (nome == null || nome.isEmpty()) {
            return "O nome do evento não pode estar vazio.";
        }

        if (local == null || local.isEmpty()) {
            return "O local do evento não pode estar vazio.";
        }

        if (dataInicio == null) {
            return "A data de início do evento não pode estar vazia.";
        }

        if (esporte == null || esporte.isEmpty()) {
            return "O esporte do evento não pode estar vazio.";
        }
        
        Long id = getIdByNome(nome);
        if (id != null) {
            return "Evento '" + nome + "' já cadastrado.";
        }

        return null;
    }
}
