package com.sportify.view;

import javax.swing.*;

import com.sportify.controller.EquipeController;
import com.sportify.controller.EventoController;
import com.sportify.dao.EquipeDAO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventoForm extends JFrame {
    private JTextField nomeField;
    private JTextField localField;
    private JTextField dataInicioField;
    private JTextField esporteField;
    private JButton criarEventoButton;
    private EventoController eventoController;
    private EquipeController equipeController;

    public EventoForm(EventoController eventoController, EquipeController equipeController) {
        this.eventoController = eventoController;
        this.equipeController = equipeController;

        setTitle("Criar Evento");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        JPanel panel = new JPanel(new GridLayout(5, 2));

        JLabel nomeLabel = new JLabel("Nome do Evento:");
        nomeField = new JTextField();
        nomeField.setText("Evento de Exemplo");
        JLabel localLabel = new JLabel("Local do Evento:");
        localField = new JTextField();
        localField.setText("Local de Exemplo");
        JLabel dataInicioLabel = new JLabel("Data de Início (dd/MM/yyyy):");
        dataInicioField = new JTextField();
        dataInicioField.setText("01/01/2023");
        JLabel esporteLabel = new JLabel("Esporte:");
        esporteField = new JTextField();
        esporteField.setText("Esporte de Exemplo");
        criarEventoButton = new JButton("Criar Evento");

        panel.add(nomeLabel);
        panel.add(nomeField);
        panel.add(localLabel);
        panel.add(localField);
        panel.add(dataInicioLabel);
        panel.add(dataInicioField);
        panel.add(esporteLabel);
        panel.add(esporteField);
        panel.add(criarEventoButton);

        criarEventoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                criarEvento();
            }
        });

        add(panel);
    }

    private void criarEvento() {
        String nome = nomeField.getText();
        String local = localField.getText();
        String dataInicioStr = dataInicioField.getText();
        String esporte = esporteField.getText();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date dataInicio = dateFormat.parse(dataInicioStr);

            long eventoId = eventoController.criarEvento(nome, local, dataInicio, esporte);

            int escolha = JOptionPane.showConfirmDialog(this, "Evento criado com sucesso! Deseja vincular equipes ao evento?", "Vincular Equipes", JOptionPane.YES_NO_OPTION);
            if (escolha == JOptionPane.YES_OPTION) {
                VinculoEquipesForm vinculoEquipesForm = new VinculoEquipesForm(eventoController, equipeController, eventoId);
                vinculoEquipesForm.setVisible(true);
            } else {
                dispose();
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Formato de data inválido. Use dd/MM/yyyy.");
        }
    }


}
