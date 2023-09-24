package com.sportify.view;

import javax.swing.*;

import com.sportify.controller.EquipeController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EquipeForm extends JFrame {
    private JTextField nomeField;
    private JButton criarEquipeButton;
    private EquipeController equipeController;


    public EquipeForm(EquipeController equipeController) {
        this.equipeController = equipeController;
        
        setTitle("Criar Equipe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);

        JPanel panel = new JPanel(new GridLayout(2, 2));

        JLabel nomeLabel = new JLabel("Nome da Equipe:");
        nomeField = new JTextField();
        criarEquipeButton = new JButton("Criar Equipe");

        panel.add(nomeLabel);
        panel.add(nomeField);
        panel.add(criarEquipeButton);

        criarEquipeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                criarEquipe();
            }
        });

        add(panel);
    }

    private void criarEquipe() {
        String nome = nomeField.getText();

        // Chamar o controlador para criar a equipe com o nome fornecido
        equipeController.criarEquipe(nome);

        JOptionPane.showMessageDialog(this, "Equipe criada com sucesso!");
        nomeField.setText("");
    }
}
