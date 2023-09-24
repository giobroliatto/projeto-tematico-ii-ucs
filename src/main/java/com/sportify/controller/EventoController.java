package com.sportify.controller;

import com.sportify.dao.EventoDAO;
import com.sportify.dao.EquipeDAO; // Importe a classe EquipeDAO
import com.sportify.model.Evento;
import com.sportify.model.Equipe; // Importe a classe Equipe

import java.util.Date;
import java.util.List; // Importe a classe List

import org.hibernate.Session;

public class EventoController {
    private EventoDAO eventoDAO;
    private EquipeDAO equipeDAO;

    public EventoController(Session session) {
        eventoDAO = new EventoDAO(session);
        equipeDAO = new EquipeDAO(session);
    }

    public long criarEvento(String nome, String local, Date dataInicio, String esporte) {
        Evento evento = new Evento();
        evento.setNome(nome);
        evento.setLocal(local);
        evento.setDataInicio(dataInicio);
        evento.setEsporte(esporte);

        return eventoDAO.salvarEvento(evento);
    }
    
    public void vincularEquipesAoEvento(long eventoId, List<Long> equipeIds) {
        Evento evento = eventoDAO.getEvento(eventoId);

        if (evento != null) {
            List<Equipe> equipesSelecionadas = equipeDAO.getEquipesByIds(equipeIds);

            for (Equipe equipe : equipesSelecionadas) {
                equipe.setEventoId(eventoId);
                equipeDAO.atualizarEquipe(equipe);
            }
        }
    }

}
