package com.sportify.view;

import com.sportify.controller.EquipeController;
import com.sportify.controller.EventoController;
import com.sportify.model.Equipe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class VinculoEquipesForm extends JFrame {
    private JList<String> equipeList;
    private DefaultListModel<String> equipeListModel;
    private JButton confirmarButton;
    private JButton cancelarButton;
    private EventoController eventoController;
    private EquipeController equipeController; 
    private long eventoId;

    public VinculoEquipesForm(EventoController eventoController, EquipeController equipeController, long eventoId) {
        this.eventoController = eventoController;
        this.equipeController = equipeController;
        this.eventoId = eventoId;

        setTitle("Vincular Equipes ao Evento");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);

        JPanel panel = new JPanel(new BorderLayout());

        List<Equipe> equipes = obterListaDeEquipes();

        equipeListModel = new DefaultListModel<>();
        for (Equipe equipe : equipes) {
            equipeListModel.addElement(equipe.getNome());
        }

        equipeList = new JList<>(equipeListModel);
        equipeList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane listScrollPane = new JScrollPane(equipeList);

        confirmarButton = new JButton("Confirmar");
        cancelarButton = new JButton("Cancelar");

        confirmarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vincularEquipesAoEvento();
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        panel.add(listScrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(confirmarButton);
        buttonPanel.add(cancelarButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
    }

    private List<Equipe> obterListaDeEquipes() {
    	EquipeController equipeController = this.equipeController;
    	
        List<Equipe> equipes = equipeController.getEquipes();
        DefaultListModel<String> equipeListModel = new DefaultListModel<>();

        for (Equipe equipe : equipes) {
            equipeListModel.addElement(equipe.getNome());
        }

        return equipes;
    }

    private void vincularEquipesAoEvento() {
        int[] selectedIndices = equipeList.getSelectedIndices();
        
        if (selectedIndices.length < 2) {
            JOptionPane.showMessageDialog(this, "Selecione pelo menos duas equipes para vincular ao evento.");
        } else if (selectedIndices.length % 2 != 0) {
            JOptionPane.showMessageDialog(this, "Selecione um número par de equipes para vincular ao evento.");
        } else {
            List<Long> idsEquipesSelecionadas = new ArrayList<>();
            for (int index : selectedIndices) {
                String equipeNome = equipeListModel.getElementAt(index);

                long id = equipeController.getPeloNome(equipeNome);
                idsEquipesSelecionadas.add(id);
            }

            eventoController.vincularEquipesAoEvento(this.eventoId, idsEquipesSelecionadas);

            JOptionPane.showMessageDialog(this, "Equipes vinculadas ao evento com sucesso!");
            dispose();
        }
    }
}
