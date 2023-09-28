package com.sportify.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.sportify.dao.ChaveDAO;
import com.sportify.dao.EquipeEventoDAO;
import com.sportify.dao.PartidaDAO;
import com.sportify.model.Chave;
import com.sportify.model.EquipeEvento;
import com.sportify.model.Partida;

public class EquipeEventoController {
    private EquipeEventoDAO equipeEventoDAO;
    private PartidaDAO partidaDAO;
    private ChaveDAO chaveDAO;

    public EquipeEventoController(Session session) {
    	equipeEventoDAO = new EquipeEventoDAO(session);
    	partidaDAO = new PartidaDAO(session);
    	chaveDAO = new ChaveDAO(session);
    }

    public void createEquipeEvento(long idEquipe, long idEvento, Date dataInicio, Date dataFim) {
        EquipeEvento equipeEvento = new EquipeEvento();
        equipeEvento.setEquipeId(idEquipe);
        equipeEvento.setEventoId(idEvento);
        equipeEvento.setDataInicio(dataInicio);
        equipeEvento.setDataFim(dataFim);

        equipeEventoDAO.saveEquipeEvento(equipeEvento);
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
    
    private Long createPartida(List<Long> pair, Long idEvento) {
        Long idEquipeA = pair.get(0);
        Long idEquipeB = pair.get(1);

        Partida partida = new Partida();
        partida.setIdEvento(idEvento);
        partida.setIdEquipeA(idEquipeA);
        partida.setIdEquipeB(idEquipeB);

        partidaDAO.savePartida(partida);

        return partida.getId();
    }

    public void gerarChave(Long idEvento) {
        List<Long> idEquipes = equipeEventoDAO.getIdEquipesByIdEvento(idEvento);
        List<List<Long>> pairs = gerarParesDeEquipes(idEquipes);

        Chave chave = new Chave();
        chave.setIdEvento(idEvento);

        int numPartidas = pairs.size();
        if (numPartidas == 1) {
            chave.setIdPartidaFinal(createPartida(pairs.get(0), idEvento));
        } else if (numPartidas == 2) {
            chave.setIdPartida1Semi(createPartida(pairs.get(0), idEvento));
            chave.setIdPartida2Semi(createPartida(pairs.get(1), idEvento));
        } else if (numPartidas == 4) {
        	chave.setIdPartida1Quartas(createPartida(pairs.get(0), idEvento));
        	chave.setIdPartida2Quartas(createPartida(pairs.get(1), idEvento));
        	chave.setIdPartida3Quartas(createPartida(pairs.get(2), idEvento));
        	chave.setIdPartida4Quartas(createPartida(pairs.get(3), idEvento));
        } else if (numPartidas == 8) {
            chave.setIdPartida1Oitavas(createPartida(pairs.get(0), idEvento));
            chave.setIdPartida2Oitavas(createPartida(pairs.get(1), idEvento));
            chave.setIdPartida3Oitavas(createPartida(pairs.get(2), idEvento));
            chave.setIdPartida4Oitavas(createPartida(pairs.get(3), idEvento));
            chave.setIdPartida5Oitavas(createPartida(pairs.get(4), idEvento));
            chave.setIdPartida6Oitavas(createPartida(pairs.get(5), idEvento));
            chave.setIdPartida7Oitavas(createPartida(pairs.get(6), idEvento));
            chave.setIdPartida8Oitavas(createPartida(pairs.get(7), idEvento));
        }

        chaveDAO.saveChave(chave);
    }
}
