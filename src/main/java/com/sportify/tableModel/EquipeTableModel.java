package com.sportify.tableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import com.sportify.model.Equipe;

public class EquipeTableModel extends AbstractTableModel {
    private List<Equipe> equipes;
    
    private JButton buttonEdit = new JButton();
    private JButton buttonRemove = new JButton();
    
    private String[] colunas = {"Id", "Nome"};

    public EquipeTableModel(List<Equipe> equipes) {
        this.equipes = equipes;
    }

    @Override
    public int getRowCount() {
        return equipes.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return equipes.get(rowIndex).getId();
        } else if(columnIndex == 1) {
        	return equipes.get(rowIndex).getNome();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    public JButton factoryActions(String value) {
    	JButton button = new JButton();
    	button.setText(value);
    	return button;
    }    
    
}
