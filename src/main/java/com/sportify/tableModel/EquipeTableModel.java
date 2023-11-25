package com.sportify.tableModel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.sportify.model.Equipe;

public class EquipeTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;

	private List<Equipe> equipes;
    
    private String[] colunas = {"ID", "NOME"};

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
}
