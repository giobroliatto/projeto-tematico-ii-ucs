package com.sportify.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import com.sportify.controller.EventoController;
import com.sportify.model.Evento;
import com.sportify.tableModel.EventoTableModel;

public class ListagemEventoForm extends JFrame{

	private static final long serialVersionUID = 1L;
	private EventoController eventoController;
	private MenuForm menuForm;
	List<Evento> listEventos = new ArrayList<>();
	
	public ListagemEventoForm(EventoController eventoController, MenuForm menuForm) {
		this.eventoController = eventoController;
		this.menuForm = menuForm;
		
		setTitle("Listagem de eventos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 220);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        EventoTableModel eventoTModel = new EventoTableModel(this.eventoController.getEventos());
		JTable jTable = new JTable(eventoTModel);
		
		panel.add(jTable);
		add(panel);
		setLocationRelativeTo(null);
		
	}
	
	private void returnToMenu() {
		menuForm.setVisible(true);
		dispose();
	}
	
}
