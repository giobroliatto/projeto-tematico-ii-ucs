package com.sportify.view;

import javax.swing.*;

import com.sportify.controller.ChaveController;
import com.sportify.controller.PartidaController;
import com.sportify.util.FactoryComponents;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarResultadoForm extends JFrame {

    private static final long serialVersionUID = 1L;
    FactoryComponents factory;

    public RegistrarResultadoForm(Long idEvento, String equipeA, String equipeB, Long idPartida, PartidaController partidaController, ChaveController chaveController, ChaveForm chaveForm, boolean placarJaDefinido, Integer resultadoEquipeA, Integer resultadoEquipeB) {
        setTitle("Registrar Resultado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);
        setLocationRelativeTo(null);
        
        factory = new FactoryComponents();
        
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        // Título "Partida"
        JLabel tituloLabel = new JLabel("Resultado da partida:");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 14));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(tituloLabel, constraints);

        // Espaço entre o título e as labels "Equipe A" e "Equipe B"
        constraints.gridy++;
        panel.add(new JLabel(), constraints);

        // Labels "Equipe A" e "Equipe B"
        JLabel equipeALabel = new JLabel(equipeA);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.WEST;
        panel.add(equipeALabel, constraints);

        JLabel equipeBLabel = new JLabel(equipeB);
        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.EAST;
        panel.add(equipeBLabel, constraints);

        // Label "Placar"
        JLabel placarLabel = new JLabel("Placar");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(placarLabel, constraints);

        // Inputs para placar da equipe A e equipe B
        JTextField placarEquipeA = new JTextField(5);
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.WEST;
        placarEquipeA.setEnabled(!placarJaDefinido);
        
        // Alimenta o valor se placarJaDefinido for true
        if (placarJaDefinido) {
            placarEquipeA.setText(String.valueOf(resultadoEquipeA));
        }
        
        panel.add(placarEquipeA, constraints);

        JTextField placarEquipeB = new JTextField(5);
        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.EAST;
        placarEquipeB.setEnabled(!placarJaDefinido);

	    // Alimenta o valor se placarJaDefinido for true
	    if (placarJaDefinido) {
	        placarEquipeB.setText(String.valueOf(resultadoEquipeB));
	    }
	
	    panel.add(placarEquipeB, constraints);

        // Espaço abaixo dos inputs
        constraints.gridy++;
        panel.add(new JLabel(), constraints);

        // Botão "Confirmar"
        if (!placarJaDefinido) {
            JButton confirmarButton = factory.createButtonList("Confirmar");
            constraints.gridx = 0;
            constraints.gridwidth = 3;
            constraints.anchor = GridBagConstraints.CENTER;
            panel.add(confirmarButton, constraints);
            
            confirmarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String placarEquipeAText = placarEquipeA.getText();
                    String placarEquipeBText = placarEquipeB.getText();
                    String validarEquipe;
                    
                    if (Integer.parseInt(placarEquipeAText) > Integer.parseInt(placarEquipeBText)) {
                        validarEquipe = equipeA;
                    } else if (Integer.parseInt(placarEquipeAText) < Integer.parseInt(placarEquipeBText)) {
                        validarEquipe = equipeB;
                    } else {
                        JOptionPane.showMessageDialog(RegistrarResultadoForm.this, "A partida não pode terminar em empate. Por favor, insira um placar válido.");
                        return;
                    }

                    String mensagem = "Confirma o resultado da partida?\n\n";
                    mensagem += equipeA + "   " + placarEquipeAText + " x " + placarEquipeBText + "   " + equipeB + "\n\n";
                    mensagem += "Equipe '" + validarEquipe + "' será a vencedora\n";
                    mensagem += " ";

                    int resposta = JOptionPane.showConfirmDialog(RegistrarResultadoForm.this, mensagem, "Confirmação de Resultado", JOptionPane.YES_NO_OPTION);

                    if (resposta == JOptionPane.YES_OPTION) {
                        partidaController.atualizarPlacar(idPartida, Integer.parseInt(placarEquipeAText), Integer.parseInt(placarEquipeBText));
                        JOptionPane.showMessageDialog(RegistrarResultadoForm.this, "Resultado confirmado!");
                        placarEquipeA.setText("");
                        placarEquipeB.setText("");
                        setVisible(false);
                        ChaveForm chaveForm = new ChaveForm(idEvento, partidaController, chaveController);
                        chaveForm.setVisible(true);
                    }
                }
            });
        }

        // Botão "Confirmar"
        if (!placarJaDefinido) {
        	JButton confirmarButton = factory.createButtonList("Confirmar");
            constraints.gridx = 0;
            constraints.gridwidth = 3;
            constraints.anchor = GridBagConstraints.CENTER;
            panel.add(confirmarButton, constraints);
        }

        // Botão "Retornar"
        JButton retornarButton = factory.createButtonList("Retornar");
        constraints.gridy++;
        constraints.gridx = 0;
        constraints.gridwidth = 3;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(retornarButton, constraints);
        
        retornarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

                placarEquipeA.setText("");
                placarEquipeB.setText("");
                
                ChaveForm chaveForm = new ChaveForm(idEvento, partidaController, chaveController);
                chaveForm.setVisible(true);
            }
        });
        
        add(panel);
        setVisible(true);
    }
}

