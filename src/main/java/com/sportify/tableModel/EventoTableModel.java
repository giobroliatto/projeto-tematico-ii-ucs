package com.sportify.tableModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.sportify.model.Evento;

public class EventoTableModel extends AbstractTableModel {
	private List<Evento> eventos;
    private Date dataAux;
    private String[] colunas = {"Id", "Nome", "Local", "Data de início", "Data final", "Esporte"};

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
        		return evento.getId();
            case 1:
                return evento.getNome();
            case 2:
                return evento.getLocal();
            case 3:
                return formatDate(evento.getDataInicio());
            case 4:
                return formatDate(evento.getDataInicio());
            case 5:
                return evento.getEsporte();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    public String formatDate(Date data) {
		SimpleDateFormat formatoSaida = new SimpleDateFormat("dd/MM/yyyy");

        /* FORMATAR DATA PARA NOVO FORMATO */
        String dataFormatada = formatoSaida.format(data);

        return dataFormatada;
    }
}
