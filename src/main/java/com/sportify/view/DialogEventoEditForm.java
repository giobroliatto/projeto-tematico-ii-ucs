package com.sportify.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.sportify.controller.EventoController;
import com.sportify.util.FactoryComponents;

public class DialogEventoEditForm {
	private MenuForm menuForm;
	private String validateFields;
	
	private JDialog dialog;
	
	private JButton buttonConfirmDialog;
	private JButton buttonCancelDialog;
	
	private JTextField tfNome;
	private JTextField tfLocal;
	private JTextField tfEsporte;
	
	private JTextField tfDataInicio;
	private JTextField tfDataFim;
	
	private Date _dataInicio;
	private Date _dataFim;
	
	private boolean isError;
	
	FactoryComponents factory;
	
	public DialogEventoEditForm(MenuForm menuForm, EventoController eventoController, String id, String nome, String local, String dataInicio, String dataFim, String esporte) {
		this.menuForm = menuForm;
		
		factory = new FactoryComponents();
		
		dialog = factory.createJDialog(menuForm, "Editar evento");
		dialog.setSize(300, 200);
		dialog.setLayout(new FlowLayout());
		
		buttonConfirmDialog = factory.createButtonList("Editar");
		buttonCancelDialog = factory.createButtonList("Cancelar");
				
		tfNome 		 = factory.createTextFieldDialog("Nome", nome);
		tfLocal  	 = factory.createTextFieldDialog("Local", local);
		tfDataInicio = factory.createTextFieldDialog("Data de incio", dataInicio);
		tfDataFim 	 = factory.createTextFieldDialog("Data final", dataFim);
		tfEsporte	 = factory.createTextFieldDialog("Esporte", esporte);
		
		dialog.add(tfNome);
		dialog.add(tfLocal);
		dialog.add(tfDataInicio);
		dialog.add(tfDataFim);
		dialog.add(tfEsporte);
		
		dialog.add(buttonConfirmDialog);
		dialog.add(buttonCancelDialog);
		
		dialog.setLocationRelativeTo(this.menuForm);
		
		dialog.setVisible(true);
		
		/* CONFIRMAR */
		this.buttonConfirmDialog.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				convertDate();
				validateFields = eventoController.validateEvento(tfNome.getText(), tfLocal.getText(), _dataInicio, _dataFim, tfEsporte.getText());
				if(validateFields != null && !isError) {
					JOptionPane.showMessageDialog(
					menuForm,
					validateFields, 
					"ERRO", 
					JOptionPane.ERROR_MESSAGE);
				} else if(!isError){
					eventoController.updateEvento(Long.parseLong(id), tfNome.getText(), tfLocal.getText(), _dataInicio, _dataFim, tfEsporte.getText());
					JOptionPane.showMessageDialog(
					menuForm, 
					"Evento salvo com sucesso",
					"Sucesso",
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
	}
	
	public void convertDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			_dataInicio = dateFormat.parse(tfDataInicio.getText());
			_dataFim    = dateFormat.parse(tfDataFim.getText());
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(
					menuForm, 
					"Formato de data inválido. Use dd/mm/aaaa.", 
					"ERRO",
					JOptionPane.ERROR_MESSAGE);
			isError = true;
		}
	}
}
