package com.sportify.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.Border;

import com.sportify.controller.PartidaController;

public class PartidaPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private JLabel equipeALabel;
    private JLabel equipeBLabel;
    private JLabel placarALabel;
    private JLabel placarBLabel;

    public PartidaPanel(String equipeA, String equipeB, Long idPartida, boolean partidaFinal, PartidaController partidaController) {
    	
    	Integer placarEquipeA = partidaController.getPlacarEquipeAByIdPartida(idPartida);
    	Integer placarEquipeB = partidaController.getPlacarEquipeBByIdPartida(idPartida);
        placarALabel = new JLabel();
        placarBLabel = new JLabel();
    	
        equipeALabel = new JLabel(equipeA);
        equipeBLabel = new JLabel(equipeB);
        
        if (placarEquipeA == null) {
        	placarALabel.setText("");
        } else if (placarEquipeA == -1) {
        	placarALabel.setText("-");
        } else {        	
        	placarALabel.setText(placarEquipeA.toString());
        }
        
        if (placarEquipeB == null) {
        	placarBLabel.setText("");
        } else if (placarEquipeB == -1) {
        	placarBLabel.setText("-");
        } else {        	
        	placarBLabel.setText(placarEquipeB.toString());
        }

        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.insets = new Insets(0, 10, 0, 10);
        
        if (partidaFinal) {
            add(equipeALabel, constraints);
            constraints.gridx = 1;
            add(placarALabel, constraints);
            constraints.gridx = 2;
            add(placarBLabel, constraints);
            constraints.gridx = 3;
            add(equipeBLabel, constraints);
        } else {
        	 constraints.gridx = 0;
             constraints.gridy = 0;
             constraints.anchor = GridBagConstraints.CENTER;
             add(equipeALabel, constraints);

             constraints.gridx = 2;
             constraints.gridy = 0;
             add(equipeBLabel, constraints);

             constraints.gridx = 0;
             constraints.gridy = 1;
             constraints.insets = new Insets(5, 0, 0, 10);
             add(placarALabel, constraints);

             constraints.gridx = 2;
             constraints.gridy = 1;
             constraints.insets = new Insets(5, 10, 0, 0);
             add(placarBLabel, constraints);
        }

        int padding = 10;
        Border paddingBorder = BorderFactory.createEmptyBorder(padding, padding, padding, padding);
        Border lineBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        Border compoundBorder = BorderFactory.createCompoundBorder(paddingBorder, lineBorder);

        setBorder(compoundBorder);

        // Adicione um ouvinte de clique ao painel
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Lógica a ser executada quando o painel for clicado
                // Por exemplo, abrir detalhes da partida
                abrirDetalhesPartida(equipeA, equipeB, idPartida, partidaController);
            }
        });
    }

    // Método para abrir detalhes da partida
    private void abrirDetalhesPartida(String equipeA, String equipeB, Long idPartida, PartidaController partidaController) {
    	RegistrarResultadoForm registrarResultadoForm = new RegistrarResultadoForm(equipeA, equipeB, idPartida, partidaController);
    	registrarResultadoForm.setVisible(true);
    }
}
