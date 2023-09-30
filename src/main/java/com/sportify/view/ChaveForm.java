package com.sportify.view;

import javax.swing.*;

import com.sportify.controller.ChaveController;
import com.sportify.controller.PartidaController;
import com.sportify.dto.IdPartidasDTO;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ChaveForm extends JFrame {
	
    private static final long serialVersionUID = 1L;

    public ChaveForm(Long idEvento, PartidaController partidaController, ChaveController chaveController) {
    	
        setTitle("Chaves de Jogos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        
        IdPartidasDTO idPartidas = chaveController.getIdPartidasByIdEvento(idEvento);
        
        Long idVencedorOitavas1 = null;
        Long idVencedorOitavas2 = null;
        Long idVencedorOitavas3 = null;
        Long idVencedorOitavas4 = null;
        Long idVencedorOitavas5 = null;
        Long idVencedorOitavas6 = null;
        Long idVencedorOitavas7 = null;
        Long idVencedorOitavas8 = null;
        Long idVencedorQuartas1 = null;
        Long idVencedorQuartas2 = null;
        Long idVencedorQuartas3 = null;
        Long idVencedorQuartas4 = null;
        Long idVencedorSemi1 = null;
        Long idVencedorSemi2 = null;

        if (idPartidas.getIdPartida1Oitavas() != null) {
            idVencedorOitavas1 = partidaController.getIdEquipeVencedoraByIdPartida(idPartidas.getIdPartida1Oitavas());
        }
        if (idPartidas.getIdPartida2Oitavas() != null) {
            idVencedorOitavas2 = partidaController.getIdEquipeVencedoraByIdPartida(idPartidas.getIdPartida2Oitavas());
        }
        if (idPartidas.getIdPartida3Oitavas() != null) {
            idVencedorOitavas3 = partidaController.getIdEquipeVencedoraByIdPartida(idPartidas.getIdPartida3Oitavas());
        }
        if (idPartidas.getIdPartida4Oitavas() != null) {
            idVencedorOitavas4 = partidaController.getIdEquipeVencedoraByIdPartida(idPartidas.getIdPartida4Oitavas());
        }
        if (idPartidas.getIdPartida5Oitavas() != null) {
            idVencedorOitavas5 = partidaController.getIdEquipeVencedoraByIdPartida(idPartidas.getIdPartida5Oitavas());
        }
        if (idPartidas.getIdPartida6Oitavas() != null) {
            idVencedorOitavas6 = partidaController.getIdEquipeVencedoraByIdPartida(idPartidas.getIdPartida6Oitavas());
        }
        if (idPartidas.getIdPartida7Oitavas() != null) {
            idVencedorOitavas7 = partidaController.getIdEquipeVencedoraByIdPartida(idPartidas.getIdPartida7Oitavas());
        }
        if (idPartidas.getIdPartida8Oitavas() != null) {
            idVencedorOitavas8 = partidaController.getIdEquipeVencedoraByIdPartida(idPartidas.getIdPartida8Oitavas());
        }
        if (idPartidas.getIdPartida1Quartas() != null) {
            idVencedorQuartas1 = partidaController.getIdEquipeVencedoraByIdPartida(idPartidas.getIdPartida1Quartas());
        }
        if (idPartidas.getIdPartida2Quartas() != null) {
            idVencedorQuartas2 = partidaController.getIdEquipeVencedoraByIdPartida(idPartidas.getIdPartida2Quartas());
        }
        if (idPartidas.getIdPartida3Quartas() != null) {
            idVencedorQuartas3 = partidaController.getIdEquipeVencedoraByIdPartida(idPartidas.getIdPartida3Quartas());
        }
        if (idPartidas.getIdPartida4Quartas() != null) {
            idVencedorQuartas4 = partidaController.getIdEquipeVencedoraByIdPartida(idPartidas.getIdPartida4Quartas());
        }
        if (idPartidas.getIdPartida1Semi() != null) {
            idVencedorSemi1 = partidaController.getIdEquipeVencedoraByIdPartida(idPartidas.getIdPartida1Semi());
        }
        if (idPartidas.getIdPartida2Semi() != null) {
            idVencedorSemi2 = partidaController.getIdEquipeVencedoraByIdPartida(idPartidas.getIdPartida2Semi());
        }

        String equipeAOitavas1 = partidaController.getNomeEquipeAByIdPartida(idPartidas.getIdPartida1Oitavas());
        String equipeBOitavas1 = partidaController.getNomeEquipeBByIdPartida(idPartidas.getIdPartida1Oitavas());

        String equipeAOitavas2 = partidaController.getNomeEquipeAByIdPartida(idPartidas.getIdPartida2Oitavas());
        String equipeBOitavas2 = partidaController.getNomeEquipeBByIdPartida(idPartidas.getIdPartida2Oitavas());

        String equipeAOitavas3 = partidaController.getNomeEquipeAByIdPartida(idPartidas.getIdPartida3Oitavas());
        String equipeBOitavas3 = partidaController.getNomeEquipeBByIdPartida(idPartidas.getIdPartida3Oitavas());
        
        String equipeAOitavas4 = partidaController.getNomeEquipeAByIdPartida(idPartidas.getIdPartida4Oitavas());
        String equipeBOitavas4 = partidaController.getNomeEquipeBByIdPartida(idPartidas.getIdPartida4Oitavas());
        
        String equipeAOitavas5 = partidaController.getNomeEquipeAByIdPartida(idPartidas.getIdPartida5Oitavas());
        String equipeBOitavas5 = partidaController.getNomeEquipeBByIdPartida(idPartidas.getIdPartida5Oitavas());
        
        String equipeAOitavas6 = partidaController.getNomeEquipeAByIdPartida(idPartidas.getIdPartida6Oitavas());
        String equipeBOitavas6 = partidaController.getNomeEquipeBByIdPartida(idPartidas.getIdPartida6Oitavas());
        
        String equipeAOitavas7 = partidaController.getNomeEquipeAByIdPartida(idPartidas.getIdPartida7Oitavas());
        String equipeBOitavas7 = partidaController.getNomeEquipeBByIdPartida(idPartidas.getIdPartida7Oitavas());
        
        String equipeAOitavas8 = partidaController.getNomeEquipeAByIdPartida(idPartidas.getIdPartida8Oitavas());
        String equipeBOitavas8 = partidaController.getNomeEquipeBByIdPartida(idPartidas.getIdPartida8Oitavas());
        
        String equipeAQuartas1 = partidaController.getNomeEquipeAByIdPartida(idPartidas.getIdPartida1Quartas());
        String equipeBQuartas1 = partidaController.getNomeEquipeBByIdPartida(idPartidas.getIdPartida1Quartas());
        
        String equipeAQuartas2 = partidaController.getNomeEquipeAByIdPartida(idPartidas.getIdPartida2Quartas());
        String equipeBQuartas2 = partidaController.getNomeEquipeBByIdPartida(idPartidas.getIdPartida2Quartas());
        
        String equipeAQuartas3 = partidaController.getNomeEquipeAByIdPartida(idPartidas.getIdPartida3Quartas());
        String equipeBQuartas3 = partidaController.getNomeEquipeBByIdPartida(idPartidas.getIdPartida3Quartas());
        
        String equipeAQuartas4 = partidaController.getNomeEquipeAByIdPartida(idPartidas.getIdPartida4Quartas());
        String equipeBQuartas4 = partidaController.getNomeEquipeBByIdPartida(idPartidas.getIdPartida4Quartas());
        
        String equipeASemi1 = partidaController.getNomeEquipeAByIdPartida(idPartidas.getIdPartida1Semi());
        String equipeBSemi1 = partidaController.getNomeEquipeBByIdPartida(idPartidas.getIdPartida1Semi());
        
        String equipeASemi2 = partidaController.getNomeEquipeAByIdPartida(idPartidas.getIdPartida2Semi());
        String equipeBSemi2 = partidaController.getNomeEquipeBByIdPartida(idPartidas.getIdPartida2Semi());
        
        String equipeAFinal = partidaController.getNomeEquipeAByIdPartida(idPartidas.getIdPartidaFinal());
        String equipeBFinal = partidaController.getNomeEquipeBByIdPartida(idPartidas.getIdPartidaFinal());
        
        if (idVencedorOitavas1 != null && idVencedorOitavas2 != null && equipeAQuartas1 == null && equipeBQuartas1 == null) {
            List<Long> equipesQuartas1 = new ArrayList<>();

            equipesQuartas1.add(idVencedorOitavas1);
            equipesQuartas1.add(idVencedorOitavas2);
            
            Long idPartidaQuartas1 = partidaController.createPartida(equipesQuartas1, idEvento);
            Long idChave = chaveController.getIdChaveByIdEvento(idEvento);
            
            chaveController.updateChaveQuartas1(idPartidaQuartas1, idChave);
            
            equipeAQuartas1 = partidaController.getNomeEquipeAByIdPartida(idPartidaQuartas1);
            equipeBQuartas1 = partidaController.getNomeEquipeBByIdPartida(idPartidaQuartas1);
        }
        
        if (idVencedorOitavas3 != null && idVencedorOitavas4 != null && equipeAQuartas2 == null && equipeBQuartas2 == null) {
            List<Long> equipesQuartas2 = new ArrayList<>();

            equipesQuartas2.add(idVencedorOitavas3);
            equipesQuartas2.add(idVencedorOitavas4);
            
            Long idPartidaQuartas2 = partidaController.createPartida(equipesQuartas2, idEvento);
            Long idChave = chaveController.getIdChaveByIdEvento(idEvento);
            
            chaveController.updateChaveQuartas2(idPartidaQuartas2, idChave);
            
            equipeAQuartas2 = partidaController.getNomeEquipeAByIdPartida(idPartidaQuartas2);
            equipeBQuartas2 = partidaController.getNomeEquipeBByIdPartida(idPartidaQuartas2);
        }
        
        if (idVencedorOitavas5 != null && idVencedorOitavas6 != null && equipeAQuartas3 == null && equipeBQuartas3 == null) {
            List<Long> equipesQuartas3 = new ArrayList<>();

            equipesQuartas3.add(idVencedorOitavas5);
            equipesQuartas3.add(idVencedorOitavas6);
            
            Long idPartidaQuartas3 = partidaController.createPartida(equipesQuartas3, idEvento);
            Long idChave = chaveController.getIdChaveByIdEvento(idEvento);
            
            chaveController.updateChaveQuartas3(idPartidaQuartas3, idChave);
            
            equipeAQuartas3 = partidaController.getNomeEquipeAByIdPartida(idPartidaQuartas3);
            equipeBQuartas3 = partidaController.getNomeEquipeBByIdPartida(idPartidaQuartas3);
        }
        
        if (idVencedorOitavas7 != null && idVencedorOitavas8 != null && equipeAQuartas4 == null && equipeBQuartas4 == null) {
            List<Long> equipesQuartas4 = new ArrayList<>();

            equipesQuartas4.add(idVencedorOitavas7);
            equipesQuartas4.add(idVencedorOitavas8);
            
            Long idPartidaQuartas4 = partidaController.createPartida(equipesQuartas4, idEvento);
            Long idChave = chaveController.getIdChaveByIdEvento(idEvento);
            
            chaveController.updateChaveQuartas4(idPartidaQuartas4, idChave);
            
            equipeAQuartas4 = partidaController.getNomeEquipeAByIdPartida(idPartidaQuartas4);
            equipeBQuartas4 = partidaController.getNomeEquipeBByIdPartida(idPartidaQuartas4);
        }

        if (idVencedorQuartas1 != null && idVencedorQuartas2 != null && equipeASemi1 == null && equipeBSemi1 == null) {
            List<Long> equipesSemi1 = new ArrayList<>();

            equipesSemi1.add(idVencedorQuartas1);
            equipesSemi1.add(idVencedorQuartas2);
            
            Long idPartidaSemi1 = partidaController.createPartida(equipesSemi1, idEvento);
            Long idChave = chaveController.getIdChaveByIdEvento(idEvento);
            
            chaveController.updateChaveSemi1(idPartidaSemi1, idChave);
            
            equipeASemi1 = partidaController.getNomeEquipeAByIdPartida(idPartidaSemi1);
            equipeBSemi1 = partidaController.getNomeEquipeBByIdPartida(idPartidaSemi1);
        }

        if (idVencedorQuartas3 != null && idVencedorQuartas4 != null && equipeASemi2 == null && equipeBSemi2 == null) {
            List<Long> equipesSemi2 = new ArrayList<>();

            equipesSemi2.add(idVencedorQuartas3);
            equipesSemi2.add(idVencedorQuartas4);
            
            Long idPartidaSemi2 = partidaController.createPartida(equipesSemi2, idEvento);
            Long idChave = chaveController.getIdChaveByIdEvento(idEvento);
            
            chaveController.updateChaveSemi2(idPartidaSemi2, idChave);
            
            equipeASemi2 = partidaController.getNomeEquipeAByIdPartida(idPartidaSemi2);
            equipeBSemi2 = partidaController.getNomeEquipeBByIdPartida(idPartidaSemi2);
        }

        if (idVencedorSemi1 != null && idVencedorSemi2 != null && equipeAFinal == null && equipeBFinal == null) {
            List<Long> equipesFinal = new ArrayList<>();

            equipesFinal.add(idVencedorSemi1);
            equipesFinal.add(idVencedorSemi2);
            
            Long idPartidaFinal = partidaController.createPartida(equipesFinal, idEvento);
            Long idChave = chaveController.getIdChaveByIdEvento(idEvento);
            
            chaveController.updateChaveFinal(idPartidaFinal, idChave);
            
            equipeAFinal = partidaController.getNomeEquipeAByIdPartida(idPartidaFinal);
            equipeBFinal = partidaController.getNomeEquipeBByIdPartida(idPartidaFinal);
        }

        PartidaPanel partidaOitavas1 = new PartidaPanel(idEvento, equipeAOitavas1, equipeBOitavas1, idPartidas.getIdPartida1Oitavas(), false, partidaController, chaveController, ChaveForm.this);
        PartidaPanel partidaOitavas2 = new PartidaPanel(idEvento, equipeAOitavas2, equipeBOitavas2, idPartidas.getIdPartida2Oitavas(), false, partidaController, chaveController, ChaveForm.this);
        PartidaPanel partidaOitavas3 = new PartidaPanel(idEvento, equipeAOitavas3, equipeBOitavas3, idPartidas.getIdPartida3Oitavas(), false, partidaController, chaveController, ChaveForm.this);
        PartidaPanel partidaOitavas4 = new PartidaPanel(idEvento, equipeAOitavas4, equipeBOitavas4, idPartidas.getIdPartida4Oitavas(), false, partidaController, chaveController, ChaveForm.this);
        PartidaPanel partidaQuartas1 = new PartidaPanel(idEvento, equipeAQuartas1, equipeBQuartas1, idPartidas.getIdPartida1Quartas(), false, partidaController, chaveController, ChaveForm.this);
        PartidaPanel partidaQuartas2 = new PartidaPanel(idEvento, equipeAQuartas2, equipeBQuartas2, idPartidas.getIdPartida2Quartas(), false, partidaController, chaveController, ChaveForm.this);
        PartidaPanel partidaSemi1 = new PartidaPanel(idEvento, equipeASemi1, equipeBSemi1, idPartidas.getIdPartida1Semi(), false, partidaController, chaveController, ChaveForm.this);
        PartidaPanel partidaFinal = new PartidaPanel(idEvento, equipeAFinal, equipeBFinal, idPartidas.getIdPartidaFinal(), true, partidaController, chaveController, ChaveForm.this);
        PartidaPanel partidaSemi2 = new PartidaPanel(idEvento, equipeASemi2, equipeBSemi2, idPartidas.getIdPartida2Semi(), false, partidaController, chaveController, ChaveForm.this);
        PartidaPanel partidaQuartas3 = new PartidaPanel(idEvento, equipeAQuartas3, equipeBQuartas3, idPartidas.getIdPartida3Quartas(), false, partidaController, chaveController, ChaveForm.this);
        PartidaPanel partidaQuartas4 = new PartidaPanel(idEvento, equipeAQuartas4, equipeBQuartas4, idPartidas.getIdPartida4Quartas(), false, partidaController, chaveController, ChaveForm.this);
        PartidaPanel partidaOitavas5 = new PartidaPanel(idEvento, equipeAOitavas5, equipeBOitavas5, idPartidas.getIdPartida5Oitavas(), false, partidaController, chaveController, ChaveForm.this);
        PartidaPanel partidaOitavas6 = new PartidaPanel(idEvento, equipeAOitavas6, equipeBOitavas6, idPartidas.getIdPartida6Oitavas(), false, partidaController, chaveController, ChaveForm.this);
        PartidaPanel partidaOitavas7 = new PartidaPanel(idEvento, equipeAOitavas7, equipeBOitavas7, idPartidas.getIdPartida7Oitavas(), false, partidaController, chaveController, ChaveForm.this);
        PartidaPanel partidaOitavas8 = new PartidaPanel(idEvento, equipeAOitavas8, equipeBOitavas8, idPartidas.getIdPartida8Oitavas(), false, partidaController, chaveController, ChaveForm.this);

        JPanel fase1Panel = new JPanel(new GridLayout(1, 4));
        fase1Panel.add(partidaOitavas1);
        fase1Panel.add(partidaOitavas2);
        fase1Panel.add(partidaOitavas3);
        fase1Panel.add(partidaOitavas4);

        JPanel fase2Panel = new JPanel(new GridLayout(1, 4));
        fase2Panel.add(new JPanel());
        fase2Panel.add(partidaQuartas1);
        fase2Panel.add(partidaQuartas2);
        fase2Panel.add(new JPanel());

        JPanel fase3Panel = new JPanel(new GridLayout(1, 3));
        fase3Panel.add(new JPanel());
        fase3Panel.add(partidaSemi1);
        fase3Panel.add(new JPanel());

        JPanel fase4Panel = new JPanel(new GridLayout(1, 1));
        fase4Panel.add(partidaFinal);

        JPanel fase3Panel2 = new JPanel(new GridLayout(1, 3));
        fase3Panel2.add(new JPanel());
        fase3Panel2.add(partidaSemi2);
        fase3Panel2.add(new JPanel());

        JPanel fase2Panel2 = new JPanel(new GridLayout(1, 4));
        fase2Panel2.add(new JPanel());
        fase2Panel2.add(partidaQuartas3);
        fase2Panel2.add(partidaQuartas4);
        fase2Panel2.add(new JPanel());
        
        JPanel fase1Panel2 = new JPanel(new GridLayout(1, 4));
        fase1Panel2.add(partidaOitavas5);
        fase1Panel2.add(partidaOitavas6);
        fase1Panel2.add(partidaOitavas7);
        fase1Panel2.add(partidaOitavas8);

        JPanel chavesPanel = new JPanel(new GridLayout(7, 1));
        chavesPanel.add(fase1Panel);
        chavesPanel.add(fase2Panel);
        chavesPanel.add(fase3Panel);
        chavesPanel.add(fase4Panel);
        chavesPanel.add(fase3Panel2);
        chavesPanel.add(fase2Panel2);
        chavesPanel.add(fase1Panel2);
        
        if (idPartidas.getIdPartida1Oitavas() == null && idPartidas.getIdPartida1Quartas() != null) {
            PartidaPanel[] oitavasPartidas = {partidaOitavas1, partidaOitavas2, partidaOitavas3, partidaOitavas4, partidaOitavas5, partidaOitavas6, partidaOitavas7, partidaOitavas8};
            for (PartidaPanel partida : oitavasPartidas) {
                partida.setVisible(false);
            }
        }

        if (idPartidas.getIdPartida1Quartas() == null && idPartidas.getIdPartida1Semi() != null) {
            PartidaPanel[] oitavasQuartasPartidas = {partidaOitavas1, partidaOitavas2, partidaOitavas3, partidaOitavas4, partidaOitavas5, partidaOitavas6, partidaOitavas7, partidaOitavas8, partidaQuartas1, partidaQuartas2, partidaQuartas3, partidaQuartas4};
            for (PartidaPanel partida : oitavasQuartasPartidas) {
                partida.setVisible(false);
            }
        }

        if (idPartidas.getIdPartida1Semi() == null && idPartidas.getIdPartidaFinal() != null) {
            PartidaPanel[] todasPartidas = {partidaOitavas1, partidaOitavas2, partidaOitavas3, partidaOitavas4, partidaOitavas5, partidaOitavas6, partidaOitavas7, partidaOitavas8, partidaQuartas1, partidaQuartas2, partidaQuartas3, partidaQuartas4, partidaSemi1, partidaSemi2};
            for (PartidaPanel partida : todasPartidas) {
                partida.setVisible(false);
            }
        }

        add(chavesPanel);

        setLocationRelativeTo(null);
    }
}
