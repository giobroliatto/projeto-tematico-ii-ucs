package com.sportify.view;

import javax.swing.*;

import com.sportify.controller.EquipeController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EquipeForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField nomeField;
    private JButton criarEquipeButton;
    private JButton retornarMenuButton;
    private EquipeController equipeController;
    private MenuForm menuForm;

    public EquipeForm(EquipeController equipeController, MenuForm menuForm) {
        this.equipeController = equipeController;
        this.menuForm = menuForm;

        setTitle("Cadastro de Equipe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 220);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Título
        JLabel titleLabel = new JLabel("Cadastrar equipe");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titleLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Espaçamento

        // Campo de Nome
        JPanel nomePanel = new JPanel();
        nomePanel.setLayout(new BoxLayout(nomePanel, BoxLayout.X_AXIS));
        nomePanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel nomeLabel = new JLabel("Nome da equipe:");
        nomePanel.add(nomeLabel);

        nomeField = new JTextField();
        nomeField.setPreferredSize(new Dimension(200, nomeField.getPreferredSize().height)); // Tamanho fixo na vertical
        nomePanel.add(Box.createHorizontalStrut(10)); // Espaço horizontal
        nomePanel.add(nomeField);

        panel.add(nomePanel);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Espaçamento

        // Botão Criar Equipe
        criarEquipeButton = new JButton("Criar equipe");
        criarEquipeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(criarEquipeButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaçamento

        // Botão Retornar ao Menu
        retornarMenuButton = new JButton("Retornar ao menu");
        retornarMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(retornarMenuButton);

        criarEquipeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                criarEquipe();
            }
        });

        retornarMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                returnToMenu();
            }
        });

        add(panel);
        setLocationRelativeTo(null);
    }

    private void criarEquipe() {
        String nome = nomeField.getText();
        String mensagemErro = equipeController.validateNomeEquipe(nome);

        if (mensagemErro != null) {
            JOptionPane.showMessageDialog(this, mensagemErro);
        } else {
            equipeController.createEquipe(nome);
            JOptionPane.showMessageDialog(this, "Equipe criada com sucesso!");
            nomeField.setText("");
        }
    }

    private void returnToMenu() {
        menuForm.setVisible(true);
        dispose();
    }
}
