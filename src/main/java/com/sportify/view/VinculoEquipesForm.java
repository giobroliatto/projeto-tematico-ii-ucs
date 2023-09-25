package com.sportify.view;

import com.sportify.controller.EquipeController;
import com.sportify.controller.EquipeEventoController;
import com.sportify.controller.EventoController;
import com.sportify.model.Equipe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

public class VinculoEquipesForm extends JFrame {
	
	private static final long serialVersionUID = 1L;
    private JList<String> equipeList;
    private DefaultListModel<String> equipeListModel;
    private JButton confirmarButton;
    private EquipeController equipeController; 
    private EventoController eventoController;
    private EquipeEventoController equipeEventoController;
    private long eventoId;

    public VinculoEquipesForm(EventoController eventoController, EquipeController equipeController, EquipeEventoController equipeEventoController, long eventoId) {
        this.eventoController = eventoController;
        this.equipeController = equipeController;
        this.equipeEventoController = equipeEventoController;
        this.eventoId = eventoId;

        setTitle("Vincular Equipes ao Evento");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);

        JPanel panel = new JPanel(new BorderLayout());

        List<Equipe> equipes = getEquipesList();

        equipeListModel = new DefaultListModel<>();
        for (Equipe equipe : equipes) {
            equipeListModel.addElement(equipe.getNome());
        }

        equipeList = new JList<>(equipeListModel);
        equipeList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane listScrollPane = new JScrollPane(equipeList);

        confirmarButton = new JButton("Confirmar");

        confirmarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                linkEquipesToEvento();
            }
        });


        panel.add(listScrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(confirmarButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
        setLocationRelativeTo(null);
    }

    private List<Equipe> getEquipesList() {
    	EquipeController equipeController = this.equipeController;
    	
        List<Equipe> equipes = equipeController.getEquipes();
        DefaultListModel<String> equipeListModel = new DefaultListModel<>();

        for (Equipe equipe : equipes) {
            equipeListModel.addElement(equipe.getNome());
        }

        return equipes;
    }

    private void linkEquipesToEvento() {
        int[] selectedIndices = equipeList.getSelectedIndices();
        
        if (selectedIndices.length < 2) {
            JOptionPane.showMessageDialog(this, "Selecione pelo menos duas equipes para vincular ao evento.");
        } else if (selectedIndices.length % 2 != 0) {
            JOptionPane.showMessageDialog(this, "Selecione um número par de equipes para vincular ao evento.");
        } else {
            for (int index : selectedIndices) {
                String equipeNome = equipeListModel.getElementAt(index);

                long id = equipeController.getIdByNome(equipeNome);
                Date dataInicioEvento = eventoController.getDataInicioById(this.eventoId);
                Date dataFimEvento = eventoController.getDataFimById(this.eventoId);
                
                equipeEventoController.createEquipeEvento(id, this.eventoId, dataInicioEvento, dataFimEvento);
            }

            JOptionPane.showMessageDialog(this, "Evento criado com sucesso!");
            dispose();
        }
    }
}
