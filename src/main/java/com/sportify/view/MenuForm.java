package com.sportify.view;

import com.sportify.controller.EquipeController;
import com.sportify.controller.EventoController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuForm extends JFrame {
    private JButton cadastrarEquipeButton;
    private JButton cadastrarEventoButton;

    public MenuForm(EquipeController equipeController, EventoController eventoController) {
        setTitle("Menu Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);

        JPanel panel = new JPanel(new GridLayout(2, 1));

        cadastrarEquipeButton = new JButton("Cadastrar Equipe");
        cadastrarEventoButton = new JButton("Cadastrar Evento");

        panel.add(cadastrarEquipeButton);
        panel.add(cadastrarEventoButton);

        cadastrarEquipeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EquipeForm equipeForm = new EquipeForm(equipeController);
                equipeForm.setVisible(true);
            }
        });

        cadastrarEventoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EventoForm eventoForm = new EventoForm(eventoController, equipeController);
                eventoForm.setVisible(true);
            }
        });

        add(panel);
    }
}
