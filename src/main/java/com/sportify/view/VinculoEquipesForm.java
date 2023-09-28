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
    private long idEvento;
    private int quantidadeEquipes;

    public VinculoEquipesForm(
    		EventoController eventoController, 
    		EquipeController equipeController, 
    		EquipeEventoController equipeEventoController,
    		long idEvento,
    		int quantidadeEquipes) 
    {
        this.eventoController = eventoController;
        this.equipeController = equipeController;
        this.equipeEventoController = equipeEventoController;
        this.idEvento = idEvento;
        this.quantidadeEquipes = quantidadeEquipes;

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
    	
        Date dataInicioNovoEvento = eventoController.getDataInicioById(this.idEvento);
        Date dataFimNovoEvento = eventoController.getDataFimById(this.idEvento);
    	
        List<Equipe> equipes = equipeController.getEquipesDisponiveis(dataInicioNovoEvento, dataFimNovoEvento);
        DefaultListModel<String> equipeListModel = new DefaultListModel<>();

        for (Equipe equipe : equipes) {
            equipeListModel.addElement(equipe.getNome());
        }

        return equipes;
    }

    private void linkEquipesToEvento() {
        int[] selectedIndices = equipeList.getSelectedIndices();
        
        if (selectedIndices.length != quantidadeEquipes) {
            JOptionPane.showMessageDialog(this, "Selecione exatamente " + quantidadeEquipes + " equipes. Você selecionou " + selectedIndices.length + " equipes");
        } else {
            for (int index : selectedIndices) {
                String equipeNome = equipeListModel.getElementAt(index);

                long id = equipeController.getIdByNome(equipeNome);
                Date dataInicioEvento = eventoController.getDataInicioById(this.idEvento);
                Date dataFimEvento = eventoController.getDataFimById(this.idEvento);
                
                equipeEventoController.createEquipeEvento(id, this.idEvento, dataInicioEvento, dataFimEvento);
            }

            JOptionPane.showMessageDialog(this, "Evento criado com sucesso!");
            dispose();
        }
    }
}
