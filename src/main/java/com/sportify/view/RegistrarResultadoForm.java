package com.sportify.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarResultadoForm extends JFrame {

    private static final long serialVersionUID = 1L;

    public RegistrarResultadoForm(String equipeA, String equipeB) {
        setTitle("Registrar Resultado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 250);
        setLocationRelativeTo(null);

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
        panel.add(placarEquipeA, constraints);

        JTextField placarEquipeB = new JTextField(5);
        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.EAST;
        panel.add(placarEquipeB, constraints);

        // Espaço abaixo dos inputs
        constraints.gridy++;
        panel.add(new JLabel(), constraints);

        // Botão "Confirmar"
        JButton confirmarButton = new JButton("Confirmar");
        constraints.gridx = 0;
        constraints.gridwidth = 3;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(confirmarButton, constraints);

        // Botão "Retornar"
        JButton retornarButton = new JButton("Retornar");
        constraints.gridy++;
        panel.add(retornarButton, constraints);

        // Adicionar ActionListener para o botão "Confirmar"
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String placarEquipeAText = placarEquipeA.getText();
                String placarEquipeBText = placarEquipeB.getText();

                String mensagem = "  Confirma o resultado da partida?\n\n";
                mensagem += "        Equipe A   " + placarEquipeAText + " x " + placarEquipeBText + "   Equipe B\n\n";
                mensagem += "Equipe XXXXXXX será a vencedora\n";
                mensagem += " ";

                int resposta = JOptionPane.showConfirmDialog(RegistrarResultadoForm.this, mensagem, "Confirmação de Resultado", JOptionPane.YES_NO_OPTION);

                if (resposta == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(RegistrarResultadoForm.this, "Resultado confirmado!");
                    placarEquipeA.setText("");
                    placarEquipeB.setText("");
                }
            }
        });

        add(panel);

        setVisible(true);
    }
}

