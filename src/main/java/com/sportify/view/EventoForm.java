package com.sportify.view;

import javax.swing.*;

import com.sportify.controller.EquipeController;
import com.sportify.controller.EventoController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventoForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField nomeField;
    private JTextField localField;
    private JTextField dataInicioField;
    private JTextField esporteField;
    private JButton criarEventoButton;
    private JButton retornarMenuButton;
    private EventoController eventoController;
    private EquipeController equipeController;
    private MenuForm menuForm;

    public EventoForm(EventoController eventoController, EquipeController equipeController, MenuForm menuForm) {
        this.eventoController = eventoController;
        this.equipeController = equipeController;
        this.menuForm = menuForm;

        setTitle("Cadastrar evento");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Título
        JLabel titleLabel = new JLabel("Cadastro de Evento");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titleLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Espaçamento

        // Campos de Evento
        nomeField = createInputField(panel, "Nome do evento:");
        localField = createInputField(panel, "Local do evento:");
        dataInicioField = createInputField(panel, "Data de início:");
        esporteField = createInputField(panel, "Esporte:");

        // Botão Criar Evento
        criarEventoButton = new JButton("Criar Evento");
        criarEventoButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(criarEventoButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaçamento

        // Botão Retornar ao Menu
        retornarMenuButton = new JButton("Retornar ao Menu");
        retornarMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(retornarMenuButton);

        criarEventoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createEvento();
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

    private JTextField createInputField(JPanel panel, String labelText) {
        JLabel label = new JLabel(labelText);
        JTextField textField = new JTextField();

        // Define o tamanho preferencial dos campos de entrada
        textField.setColumns(20); // Ajuste o tamanho desejado aqui

        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Alinhe os campos à direita

        inputPanel.add(label);
        inputPanel.add(textField);

        panel.add(inputPanel);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaçamento entre os campos

        return textField;
    }

    private void createEvento() {
        String nome = nomeField.getText();
        String local = localField.getText();
        String dataInicioStr = dataInicioField.getText();
        String esporte = esporteField.getText();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date dataInicio = dateFormat.parse(dataInicioStr);

            String mensagemErro = eventoController.validateEvento(nome, local, dataInicio, esporte);

            if (mensagemErro != null) {
                JOptionPane.showMessageDialog(this, mensagemErro);
            } else {
                long eventoId = eventoController.createEvento(nome, local, dataInicio, esporte);

                nomeField.setText("");
                localField.setText("");
                dataInicioField.setText("");
                esporteField.setText("");

                JOptionPane.showMessageDialog(this, "Selecione as equipes que participarão deste evento.");

                VinculoEquipesForm vinculoEquipesForm = new VinculoEquipesForm(eventoController, equipeController, eventoId);
                vinculoEquipesForm.setVisible(true);
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Formato de data inválido. Use dd/mm/aaaa.");
        }
    }

    private void returnToMenu() {
        menuForm.setVisible(true);
        dispose();
    }

}
