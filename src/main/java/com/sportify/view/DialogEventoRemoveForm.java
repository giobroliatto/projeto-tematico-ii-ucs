package com.sportify.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import com.sportify.controller.EventoController;

public class DialogEventoRemoveForm {
	private MenuForm menuForm;
	private String id;
	
	private EventoController eventoController;
	
	public DialogEventoRemoveForm(MenuForm menuForm, String id, EventoController eventoController) {
		this.menuForm = menuForm;
		this.id = id;
		this.eventoController = eventoController;
	}
	
	public JDialog factoryRemoveDialog() {
		JDialog dialog = new JDialog(this.menuForm, "Remover registro");
		dialog.setSize(300, 100);
		dialog.setLayout(new FlowLayout());
		
		JButton buttonEditDialog = new JButton();
		buttonEditDialog.setText("Confirmar Remoção?");
		
		JButton buttonCancelDialog = new JButton();
		buttonCancelDialog.setText("Cancelar");
		
		dialog.add(buttonEditDialog);
		dialog.add(buttonCancelDialog);
		
		dialog.setLocationRelativeTo(this.menuForm);
		
		
		buttonEditDialog.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventoController.removeEvento(Long.parseLong(id));
				
				JOptionPane.showMessageDialog(
				menuForm, 
				"Equipe removida com sucesso", 
				"Sucess",
				JOptionPane.INFORMATION_MESSAGE);
				
				dialog.setVisible(false);
			}
		});
		
		buttonCancelDialog.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		return dialog;
	}
}
