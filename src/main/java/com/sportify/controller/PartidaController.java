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
        partida.setPlacarEquipeA(-1);
        partida.setPlacarEquipeB(-1);
        partida.setIdEvento(idEvento);
        partida.setIdEquipeA(idEquipeA);
        partida.setIdEquipeB(idEquipeB);

        partidaDAO.savePartida(partida);

        return partida.getId();
    }
    
    public void atualizarPlacar(Long idPartida, Integer novoPlacarEquipeA, Integer novoPlacarEquipeB) {
        Partida partida = partidaDAO.getPartidaById(idPartida);

        partida.setPlacarEquipeA(novoPlacarEquipeA);
        partida.setPlacarEquipeB(novoPlacarEquipeB);

        partidaDAO.updatePartida(partida);
    }
    
    public String getNomeEquipeAByIdPartida(Long idPartida) {
        return partidaDAO.getNomeEquipeAByIdPartida(idPartida);
    }

    public String getNomeEquipeBByIdPartida(Long idPartida) {
        return partidaDAO.getNomeEquipeBByIdPartida(idPartida);
    }
    
    public Integer getPlacarEquipeAByIdPartida(Long idPartida) {
        return partidaDAO.getPlacarEquipeAByIdPartida(idPartida);
    }

    public Integer getPlacarEquipeBByIdPartida(Long idPartida) {
        return partidaDAO.getPlacarEquipeBByIdPartida(idPartida);
    }
}
