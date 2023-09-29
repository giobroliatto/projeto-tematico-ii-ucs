package com.sportify.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;

import com.sportify.dao.ChaveDAO;
import com.sportify.dto.IdPartidasDTO;
import com.sportify.model.Chave;

public class ChaveController {
    private ChaveDAO chaveDAO;
    private PartidaController partidaController;
    private EquipeEventoController equipeEventoController;
    
	public ChaveController(Session session) {
    	chaveDAO = new ChaveDAO(session);
    	equipeEventoController = new EquipeEventoController(session);
    	partidaController = new PartidaController(session);
	}
	
    public List<List<Long>> gerarParesDeEquipes(List<Long> idEquipes) {
        Collections.shuffle(idEquipes);
        List<List<Long>> pairs = new ArrayList<List<Long>>();

        for (int i = 0; i < idEquipes.size(); i += 2) {
            List<Long> pair = new ArrayList<Long>();
            pair.add(idEquipes.get(i));
            pair.add(idEquipes.get(i + 1));
            pairs.add(pair);
        }

        return pairs;
    }

    public void createChave(Long idEvento) {
        List<Long> idEquipes = equipeEventoController.getIdEquipesByIdEvento(idEvento);
        List<List<Long>> pairs = gerarParesDeEquipes(idEquipes);

        Chave chave = new Chave();
        chave.setIdEvento(idEvento);

        int numPartidas = pairs.size();
        if (numPartidas == 1) {
            chave.setIdPartidaFinal(partidaController.createPartida(pairs.get(0), idEvento));
        } else if (numPartidas == 2) {
            chave.setIdPartida1Semi(partidaController.createPartida(pairs.get(0), idEvento));
            chave.setIdPartida2Semi(partidaController.createPartida(pairs.get(1), idEvento));
        } else if (numPartidas == 4) {
        	chave.setIdPartida1Quartas(partidaController.createPartida(pairs.get(0), idEvento));
        	chave.setIdPartida2Quartas(partidaController.createPartida(pairs.get(1), idEvento));
        	chave.setIdPartida3Quartas(partidaController.createPartida(pairs.get(2), idEvento));
        	chave.setIdPartida4Quartas(partidaController.createPartida(pairs.get(3), idEvento));
        } else if (numPartidas == 8) {
            chave.setIdPartida1Oitavas(partidaController.createPartida(pairs.get(0), idEvento));
            chave.setIdPartida2Oitavas(partidaController.createPartida(pairs.get(1), idEvento));
            chave.setIdPartida3Oitavas(partidaController.createPartida(pairs.get(2), idEvento));
            chave.setIdPartida4Oitavas(partidaController.createPartida(pairs.get(3), idEvento));
            chave.setIdPartida5Oitavas(partidaController.createPartida(pairs.get(4), idEvento));
            chave.setIdPartida6Oitavas(partidaController.createPartida(pairs.get(5), idEvento));
            chave.setIdPartida7Oitavas(partidaController.createPartida(pairs.get(6), idEvento));
            chave.setIdPartida8Oitavas(partidaController.createPartida(pairs.get(7), idEvento));
        }

        chaveDAO.saveChave(chave);
    }
    
    public String validateChaveByIdEvento(Long idEvento) {
        if (chaveDAO.getIdChaveByIdEvento(idEvento) != null) {
            return "Chave já gerada para este evento";
        }
        return null;
    }
    
    public IdPartidasDTO getIdPartidasByIdEvento(Long idEvento) {
        return chaveDAO.getIdPartidasByIdEvento(idEvento);
    }
}
