package com.sportify.util;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

public class FactoryComponents {
	private JButton button;
	private JTable table;
	private JDialog dialog;
	private JTextField textField;
	
	
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
		return textField;
	}
	
}	
