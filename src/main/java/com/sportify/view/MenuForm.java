package com.sportify.view;

import com.sportify.controller.ChaveController;
import com.sportify.controller.EquipeController;
import com.sportify.controller.EquipeEventoController;
import com.sportify.controller.EventoController;
import com.sportify.controller.PartidaController;
import com.sportify.util.FactoryComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JButton cadastrarEquipeButton;
    private JButton cadastrarEventoButton;
    private JButton listarEquipesButton;
    private JButton listarEventosButton;
    
    private FactoryComponents factory;
    
    public MenuForm(
    		EquipeController equipeController, 
    		EventoController eventoController, 
    		EquipeEventoController equipeEventoController, 
    		PartidaController partidaController,
    		ChaveController chaveController) {
    	
    	factory = new FactoryComponents();
    	
        setTitle("SPORTIFY");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 350);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        /* TÍTULO */
        JLabel titleLabel = new JLabel("SPORTIFY");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titleLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); /* ESPAÇAMENTO */

        /* SEÇÃO CADASTROS */
        JLabel cadastrosLabel = new JLabel("Cadastros");
        cadastrosLabel.setFont(new Font("Arial", Font.BOLD, 16));
        cadastrosLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(cadastrosLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); /* ESPAÇAMENTO */

        cadastrarEquipeButton = factory.createButtonList("Cadastrar equipe");
        cadastrarEquipeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(cadastrarEquipeButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); /* ESPAÇAMENTO */

        cadastrarEventoButton = factory.createButtonList("Cadastrar evento");
        cadastrarEventoButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(cadastrarEventoButton);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); /* ESPAÇAMENTO */

        /* SEÇÃO LISTAGENS */
        JLabel listagemLabel = new JLabel("Listagens");
        listagemLabel.setFont(new Font("Arial", Font.BOLD, 16));
        listagemLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(listagemLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); /* ESPAÇAMENTO */

        listarEquipesButton = factory.createButtonList("Lista equipes");
        listarEquipesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(listarEquipesButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); /* ESPAÇAMENTO */

        listarEventosButton = factory.createButtonList("Listar eventos");
        listarEventosButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(listarEventosButton);

        cadastrarEquipeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadastrarEquipeForm equipeForm = new CadastrarEquipeForm(equipeController, MenuForm.this);
                setVisible(false);
                equipeForm.setVisible(true);
            }
        });

        cadastrarEventoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadastrarEventoForm eventoForm = new CadastrarEventoForm(eventoController, equipeController, equipeEventoController, MenuForm.this);
                setVisible(false);
                eventoForm.setVisible(true);
            }
        });

        listarEquipesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
            	ListagemEquipeForm listagemEquipeForm = new ListagemEquipeForm(equipeController, MenuForm.this);
            	setVisible(false);
            	listagemEquipeForm.setVisible(true);
            }
        });

        listarEventosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ListagemEventoForm listagemEventoForm = new ListagemEventoForm(MenuForm.this, eventoController, partidaController, chaveController);
                setVisible(false);
                listagemEventoForm.setVisible(true);
            }
        });
        
        add(panel);
        setLocationRelativeTo(null); 
    }
}
