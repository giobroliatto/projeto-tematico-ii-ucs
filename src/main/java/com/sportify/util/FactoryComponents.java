package com.sportify.util;

import java.awt.FlowLayout;
import java.text.ParseException;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.MaskFormatter;

public class FactoryComponents {
	private JButton button;
	private JTable table;
	private JDialog dialog;
	private JTextField textField;
	private MaskFormatter dateMask;
	private JFormattedTextField dateField;
	
	
	public JButton createButtonList(String name) {
		button = new JButton();
		button.setText(name);
		return button;
	}
	
	public JPanel createPanelList() {
		return new JPanel();
	}
	
	public JTable createTableList(AbstractTableModel model) {
		table = new JTable(model);		
		return table;
	}	
	
	public JDialog createJDialog(JFrame frame, String title) {
		dialog = new JDialog(frame);
		dialog.setTitle(title);
		return dialog;
	}
	
	public JTextField createTextFieldDialog(String name, String value) {
		textField = new JTextField();
		textField.setName(name);
		textField.setText(value);
		textField.setLayout(new FlowLayout());
		textField.setColumns(25);
		return textField;
	}
	
	public JFormattedTextField createDatePicker(String name, LocalDate value) {
	    try {
	        dateMask = new MaskFormatter("####/##/##");
	        dateField = new JFormattedTextField(dateMask);
	        dateField.setColumns(25);

	        String formattedDate = String.format("%04d/%02d/%02d", value.getYear(), value.getMonthValue(), value.getDayOfMonth());
	        dateField.setText(formattedDate);
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }

	    return dateField;
	}

	
}	
