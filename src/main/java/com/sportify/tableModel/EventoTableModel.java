package com.sportify.tableModel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.sportify.model.Evento;

public class EventoTableModel extends AbstractTableModel {
    private List<Evento> eventos;
    private String[] colunas = {"Nome", "Local", "Data de início", "Data final", "Esporte"};

    public EventoTableModel(List<Evento> eventos) {
        this.eventos = eventos;
    }

    @Override
    public int getRowCount() {
        return eventos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Evento evento = eventos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return evento.getNome();
            case 1:
                return evento.getLocal();
            case 2:
                return evento.getDataInicio();
            case 3:
                return evento.getDataFim();
            case 4:
                return evento.getEsporte();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
}
