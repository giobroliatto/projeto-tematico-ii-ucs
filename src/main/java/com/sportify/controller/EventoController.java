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

    public void criarEvento(String nome, String local, Date dataInicio, String esporte) {
        // Criar uma instância de Evento com os dados fornecidos
        Evento evento = new Evento();
        evento.setNome(nome);
        evento.setLocal(local);
        evento.setDataInicio(dataInicio);
        evento.setEsporte(esporte);

        // Usar o EventoDAO para salvar o evento no banco de dados
        eventoDAO.salvarEvento(evento);
    }
}
