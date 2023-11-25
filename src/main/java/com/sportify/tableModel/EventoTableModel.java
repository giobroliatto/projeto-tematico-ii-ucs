package com.sportify.tableModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.sportify.model.Evento;
import com.sportify.util.FactoryComponents;

public class EventoTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	
	private List<Evento> eventos;
    private String[] colunas = {"Id", "NOME", "LOCAL", "DATA DE INÍCIO", "DATA FINAL", "ESPORTE"};
    private FactoryComponents factory;

    public EventoTableModel(List<Evento> eventos) {
        this.eventos = eventos;
        this.factory = new FactoryComponents();
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
            	return this.factory.dateFieldFormatting(evento.getDataInicio());
            case 4:
                return this.factory.dateFieldFormatting(evento.getDataFim());
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
