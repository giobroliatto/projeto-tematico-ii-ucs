package com.sportify.view;

import javax.swing.*;

import com.sportify.controller.ChaveController;
import com.sportify.controller.PartidaController;
import com.sportify.dto.IdPartidasDTO;

import java.awt.*;

public class ChaveForm extends JFrame {
	
    private static final long serialVersionUID = 1L;

    public ChaveForm(Long idEvento, PartidaController partidaController, ChaveController chaveController) {
    	
        setTitle("Chaves de Jogos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        
        IdPartidasDTO idPartidas = chaveController.getIdPartidasByIdEvento(idEvento);

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

        PartidaPanel partidaOitavas1 = new PartidaPanel(equipeAOitavas1, equipeBOitavas1, idPartidas.getIdPartida1Oitavas(), false, partidaController);
        PartidaPanel partidaOitavas2 = new PartidaPanel(equipeAOitavas2, equipeBOitavas2, idPartidas.getIdPartida2Oitavas(), false, partidaController);
        PartidaPanel partidaOitavas3 = new PartidaPanel(equipeAOitavas3, equipeBOitavas3, idPartidas.getIdPartida3Oitavas(), false, partidaController);
        PartidaPanel partidaOitavas4 = new PartidaPanel(equipeAOitavas4, equipeBOitavas4, idPartidas.getIdPartida4Oitavas(), false, partidaController);
        PartidaPanel partidaQuartas1 = new PartidaPanel(equipeAQuartas1, equipeBQuartas1, idPartidas.getIdPartida1Quartas(), false, partidaController);
        PartidaPanel partidaQuartas2 = new PartidaPanel(equipeAQuartas2, equipeBQuartas2, idPartidas.getIdPartida2Quartas(), false, partidaController);
        PartidaPanel partidaSemi1 = new PartidaPanel(equipeASemi1, equipeBSemi1, idPartidas.getIdPartida1Semi(), false, partidaController);
        PartidaPanel partidaFinal = new PartidaPanel(equipeAFinal, equipeBFinal, idPartidas.getIdPartidaFinal(), true, partidaController);
        PartidaPanel partidaSemi2 = new PartidaPanel(equipeASemi2, equipeBSemi2, idPartidas.getIdPartida2Semi(), false, partidaController);
        PartidaPanel partidaQuartas3 = new PartidaPanel(equipeAQuartas3, equipeBQuartas3, idPartidas.getIdPartida3Quartas(), false, partidaController);
        PartidaPanel partidaQuartas4 = new PartidaPanel(equipeAQuartas4, equipeBQuartas4, idPartidas.getIdPartida4Quartas(), false, partidaController);
        PartidaPanel partidaOitavas5 = new PartidaPanel(equipeAOitavas5, equipeBOitavas5, idPartidas.getIdPartida5Oitavas(), false, partidaController);
        PartidaPanel partidaOitavas6 = new PartidaPanel(equipeAOitavas6, equipeBOitavas6, idPartidas.getIdPartida6Oitavas(), false, partidaController);
        PartidaPanel partidaOitavas7 = new PartidaPanel(equipeAOitavas7, equipeBOitavas7, idPartidas.getIdPartida7Oitavas(), false, partidaController);
        PartidaPanel partidaOitavas8 = new PartidaPanel(equipeAOitavas8, equipeBOitavas8, idPartidas.getIdPartida8Oitavas(), false, partidaController);

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
 
        add(chavesPanel);

        setLocationRelativeTo(null);
    }
}
