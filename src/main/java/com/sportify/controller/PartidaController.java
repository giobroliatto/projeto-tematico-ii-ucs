package com.sportify.controller;

import java.util.List;

import org.hibernate.Session;

import com.sportify.dao.PartidaDAO;
import com.sportify.model.Partida;

public class PartidaController {

    private PartidaDAO partidaDAO;
    
    public PartidaController(Session session) {
    	partidaDAO = new PartidaDAO(session);
    }
    
    public Long createPartida(List<Long> pair, Long idEvento) {
        Long idEquipeA = pair.get(0);
        Long idEquipeB = pair.get(1);

        Partida partida = new Partida();
        partida.setIdEvento(idEvento);
        partida.setIdEquipeA(idEquipeA);
        partida.setIdEquipeB(idEquipeB);

        partidaDAO.savePartida(partida);

        return partida.getId();
    }
    
    public String getNomeEquipeAByIdPartida(Long idPartida) {
        return partidaDAO.getNomeEquipeAByIdPartida(idPartida);
    }

    public String getNomeEquipeBByIdPartida(Long idPartida) {
        return partidaDAO.getNomeEquipeBByIdPartida(idPartida);
    }
}
