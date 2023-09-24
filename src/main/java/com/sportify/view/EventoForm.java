package com.sportify.view;

import javax.swing.*;
import com.sportify.controller.EventoController;
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

    public EventoForm(EventoController eventoController) {
        this.eventoController = eventoController;

        setTitle("Criar Evento");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        JPanel panel = new JPanel(new GridLayout(5, 2));

        JLabel nomeLabel = new JLabel("Nome do Evento:");
        nomeField = new JTextField();
        JLabel localLabel = new JLabel("Local do Evento:");
        localField = new JTextField();
        JLabel dataInicioLabel = new JLabel("Data de Início (dd/MM/yyyy):");
        dataInicioField = new JTextField();
        JLabel esporteLabel = new JLabel("Esporte:");
        esporteField = new JTextField();
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

            // Chamar o controlador para criar o evento com os dados fornecidos
            eventoController.criarEvento(nome, local, dataInicio, esporte);

            JOptionPane.showMessageDialog(this, "Evento criado com sucesso!");
            nomeField.setText("");
            localField.setText("");
            dataInicioField.setText("");
            esporteField.setText("");
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Formato de data inválido. Use dd/MM/yyyy.");
        }
    }
}
