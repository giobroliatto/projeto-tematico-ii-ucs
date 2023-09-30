package com.sportify.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.Border;

import com.sportify.controller.ChaveController;
import com.sportify.controller.PartidaController;

public class PartidaPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private JLabel equipeALabel;
    private JLabel equipeBLabel;
    private JLabel placarALabel;
    private JLabel placarBLabel;
    private JLabel aDefinirLabel;

    public PartidaPanel(Long idEvento, String equipeA, String equipeB, Long idPartida, boolean partidaFinal, PartidaController partidaController, ChaveController chaveController, ChaveForm chaveForm) {
    	
    	Integer placarEquipeA = partidaController.getPlacarEquipeAByIdPartida(idPartida);
    	Integer placarEquipeB = partidaController.getPlacarEquipeBByIdPartida(idPartida);
        placarALabel = new JLabel();
        placarBLabel = new JLabel();
    	
        equipeALabel = new JLabel(equipeA);
        equipeBLabel = new JLabel(equipeB);

        if (placarEquipeA != null && placarEquipeB != null) {        	
        	String equipeVencedora = partidaController.getEquipeVencedoraByIdPartida(idPartida);
        	Color corVencedora = new Color(0, 204, 0);
            
            if (equipeVencedora.equals(equipeA)) {
                equipeALabel.setFont(equipeALabel.getFont().deriveFont(Font.BOLD));
                equipeALabel.setForeground(corVencedora);
            } else if (equipeVencedora.equals(equipeB)) {
                equipeBLabel.setFont(equipeBLabel.getFont().deriveFont(Font.BOLD));
                equipeBLabel.setForeground(corVencedora);
            }    
        }
        
        if (equipeA == null && equipeB == null) {
            aDefinirLabel = new JLabel("A definir");
            aDefinirLabel.setFont(new Font("Arial", Font.BOLD, 13));
            aDefinirLabel.setForeground(Color.GRAY);
            aDefinirLabel.setHorizontalAlignment(JLabel.CENTER);
            aDefinirLabel.setVerticalAlignment(JLabel.CENTER);
            add(aDefinirLabel);
        }
        
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

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                abrirDetalhesPartida(idEvento, equipeA, equipeB, idPartida, partidaController, chaveController, chaveForm);
            }
        });
    }

    private void abrirDetalhesPartida(Long idEvento, String equipeA, String equipeB, Long idPartida, PartidaController partidaController, ChaveController chaveController, ChaveForm chaveForm) {
    	if (idPartida != null) {    		
    		RegistrarResultadoForm registrarResultadoForm = new RegistrarResultadoForm(idEvento, equipeA, equipeB, idPartida, partidaController, chaveController, chaveForm);
    		registrarResultadoForm.setVisible(true);
    		chaveForm.setVisible(false);
    	}
    }
}
