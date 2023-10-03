package com.sportify.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.sportify.controller.EquipeController;

public class DialogEditForm {
	private MenuForm menuForm;
	
	private String id;
	private String name;
	
	private JButton buttonConfirmDialog;
	private JButton buttonCancelDialog;
	
	private EquipeController equipeController;
	
	public DialogEditForm(MenuForm menuForm, String id, String name, EquipeController equipeController) {
		this.menuForm = menuForm;
		this.id = id;
		this.name = name;
		this.equipeController = equipeController;
	}
	
	public JDialog factoryEditDialog() {
		JDialog dialog = new JDialog(this.menuForm, "Editar equipe");
		dialog.setSize(300, 100);
		dialog.setLayout(new FlowLayout());
		
		this.buttonConfirmDialog = new JButton();
		this.buttonConfirmDialog.setText("Confirmar");
		
		this.buttonCancelDialog = new JButton();
		this.buttonCancelDialog.setText("Cancelar");
		
		
		JTextField tfNome = new JTextField();
		tfNome.setLayout(new FlowLayout());
		tfNome.setColumns(25);
		tfNome.setName("Nome");
		tfNome.setText(this.name);
		
		dialog.add(tfNome);
		
		dialog.add(buttonConfirmDialog);
		dialog.add(buttonCancelDialog);
		
		dialog.setLocationRelativeTo(this.menuForm);
		
		this.buttonConfirmDialog.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tfNome.getText().equals("")) {
            		JOptionPane.showMessageDialog(
    				menuForm, 
    				"Preencha o campo 'Nome'", 
    				"Error", 
    				JOptionPane.ERROR_MESSAGE); 
				} else {
					equipeController.updateEquipe(Long.parseLong(id), tfNome.getText());
					
					JOptionPane.showMessageDialog(
					menuForm, 
					"Equipe salva com sucesso", 
					"Sucess", 
					JOptionPane.INFORMATION_MESSAGE);
					
					dialog.setVisible(false);
				}
			}
		});
		
		this.buttonCancelDialog.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(false);
			}
		});
		
		return dialog;
		
	}
}
