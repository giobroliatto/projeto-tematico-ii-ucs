package com.sportify.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.sportify.controller.EventoController;
import com.sportify.model.Evento;
import com.sportify.util.FactoryComponents;

public class DialogEventoEditForm {
	private MenuForm menuForm;
	private Long id;
	private String nome;
	private String local;
	private String dataInicio;
	private String dataFim;
	private String esporte;
	private String validateFields;
	
	private EventoController eventoController;
	
	private JDialog dialog;
	
	private JButton buttonConfirmDialog;
	private JButton buttonCancelDialog;
	
	private JTextField tfNome;
	private JTextField tfLocal;
	private JTextField tfEsporte;
	
	private JFormattedTextField tfDataInicio;
	private JFormattedTextField tfDataFim;
	
	private Date _dataInicio;
	private Date _dataFim;
	
	
	FactoryComponents factory;
	
	public DialogEventoEditForm(MenuForm menuForm, Evento fieldValues, EventoController eventoController) {
		this.menuForm = menuForm;
		
		this.id 		= fieldValues.getId();
		this.nome 		= fieldValues.getNome().toString();
		this.local 		= fieldValues.getLocal().toString();
		this.dataInicio = fieldValues.getDataInicio().toString();
		this.dataFim 	= fieldValues.getDataFim().toString();
		this.esporte 	= fieldValues.getEsporte().toString();
		
		this.eventoController = eventoController;
		
		factory = new FactoryComponents();
		
		dialog = factory.createJDialog(menuForm, "Editar evento");
		dialog.setSize(300, 200);
		dialog.setLayout(new FlowLayout());
		
		buttonConfirmDialog = factory.createButtonList("Editar");
		buttonCancelDialog = factory.createButtonList("Cancelar");
				
		tfNome 		 = factory.createTextFieldDialog("Nome", this.nome);
		tfLocal  	 = factory.createTextFieldDialog("Local", this.local);
		tfDataInicio = factory.createDatePicker("Data de inicio", getDateFormatterLabel(this.dataInicio));
		tfDataFim    = factory.createDatePicker("Data final", getDateFormatterLabel(this.dataInicio));
		tfEsporte	 = factory.createTextFieldDialog("Esporte", this.esporte);
		
		dialog.add(tfNome);
		dialog.add(tfLocal);
		dialog.add(tfDataInicio);
		dialog.add(tfDataFim);
		dialog.add(tfEsporte);
		
		dialog.add(buttonConfirmDialog);
		dialog.add(buttonCancelDialog);
		
		dialog.setLocationRelativeTo(this.menuForm);
		
		dialog.setVisible(true);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			_dataInicio = dateFormat.parse(tfDataInicio.getText());
			_dataFim    = dateFormat.parse(tfDataFim.getText());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		this.buttonConfirmDialog.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				validateFields = eventoController.validateEvento(tfNome.getText(), tfLocal.getText(), _dataInicio, _dataFim, tfEsporte.getText());
				if(validateFields != null) {
					JOptionPane.showMessageDialog(
					menuForm,
					validateFields, 
					"ERRO", 
					JOptionPane.ERROR_MESSAGE);
				} else {
					/* TESTAR PARA VER SE NAO VAI QUEBRAR ALGO DO BANCO DEVIDO AO FORMATO DAS DATAS */
					eventoController.updateEvento(id, tfNome.getText(), local, _dataInicio, _dataFim, esporte);
					JOptionPane.showMessageDialog(
					menuForm, 
					"Evento salvo com sucesso",
					"Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
					dialog.setVisible(true);
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
	
	/* MÉTODO PARA FORMATAR A DATA PARA MOSTRAR CORRETAMENTE NA LABEL DO DIALOG */
	public LocalDate getDateFormatterLabel(String data) {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("E MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
		
		LocalDate date = LocalDate.parse(data, dateFormatter);
		
		return date;
	}
	
	public LocalDate getDateFormatter(String data) {
		String unmaskedText = data.replaceAll("[^0-9]", "");
        int year = Integer.parseInt(unmaskedText.substring(0, 4));
        int month = Integer.parseInt(unmaskedText.substring(4, 6));
        int day = Integer.parseInt(unmaskedText.substring(6, 8));
        
        return LocalDate.of(year, month, month);
		
	}
}
