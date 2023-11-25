package com.sportify.util;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

public class FactoryComponents {
	private JButton button;
	private JTable table;
	private JDialog dialog;
	private JTextField textField;
	private JLabel label;
	
	private SimpleDateFormat format;
	private String dateFormattedStr;
	
	public JButton createButtonList(String name) {
		button = new JButton();
		button.setText(name);
		button.setFont(new Font("Arial", Font.BOLD, 15));
		button.setBackground(new Color(81, 85, 81));
		button.setForeground(new Color(255, 255, 255));
        button.setBorderPainted(false); /* REMOVE A BORDA */
        button.setFocusPainted(false); /* REMOVE O FOCO */
		return button;
	}
	
	public JPanel createPanelList() {
		return new JPanel();
	}
	
	public JTable createTableList(AbstractTableModel model) {
		table = new JTable(model);		
		table.setBackground(new Color(255, 255, 255));
		table.setForeground(new Color(0, 0, 0));
		table.setFont(new Font("Arial", Font.BOLD, 15));
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
	
	public JLabel createJLabel(String nome) {
		label = new JLabel();
		label.setText(nome);
		label.setFont(new Font("Arial", Font.BOLD, 16));
		
		return label;
	}
	
	public String dateFieldFormatting(Date dateAux) {

		format = new SimpleDateFormat("dd/MM/yyyy");
		
		dateFormattedStr = format.format(dateAux);
		
		return dateFormattedStr;
	}
	
	
	

}	
