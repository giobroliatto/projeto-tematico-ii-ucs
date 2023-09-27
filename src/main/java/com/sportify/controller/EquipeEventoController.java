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

        List<Long> idPartidasOitavas = new ArrayList<>();
        List<Long> idPartidasQuartas = new ArrayList<>();
        List<Long> idPartidasSemi = new ArrayList<>();
        Long idPartidaFinal = null;

        int numPartidas = pairs.size();
        if (numPartidas == 1) {
            idPartidaFinal = createPartida(pairs.get(0), idEvento);
        } else if (numPartidas == 2) {
            idPartidasSemi.add(createPartida(pairs.get(0), idEvento));
            idPartidasSemi.add(createPartida(pairs.get(1), idEvento));
        } else if (numPartidas == 4) {
        	idPartidasQuartas.add(createPartida(pairs.get(0), idEvento));
        	idPartidasQuartas.add(createPartida(pairs.get(1), idEvento));
        	idPartidasQuartas.add(createPartida(pairs.get(2), idEvento));
        	idPartidasQuartas.add(createPartida(pairs.get(3), idEvento));
        } else if (numPartidas == 8) {
            idPartidasOitavas.add(createPartida(pairs.get(0), idEvento));
            idPartidasOitavas.add(createPartida(pairs.get(1), idEvento));
            idPartidasOitavas.add(createPartida(pairs.get(2), idEvento));
            idPartidasOitavas.add(createPartida(pairs.get(3), idEvento));
            idPartidasOitavas.add(createPartida(pairs.get(4), idEvento));
            idPartidasOitavas.add(createPartida(pairs.get(5), idEvento));
            idPartidasOitavas.add(createPartida(pairs.get(6), idEvento));
            idPartidasOitavas.add(createPartida(pairs.get(7), idEvento));
        }

        chave.setIdPartidasOitavas(idPartidasOitavas);
        chave.setIdPartidasQuartas(idPartidasQuartas);
        chave.setIdPartidasSemi(idPartidasSemi);
        chave.setIdPartidaFinal(idPartidaFinal);

        chaveDAO.saveChave(chave);
    }
}
