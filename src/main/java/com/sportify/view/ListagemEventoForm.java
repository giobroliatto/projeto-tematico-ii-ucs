package com.sportify.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import com.sportify.controller.ChaveController;
import com.sportify.controller.EventoController;
import com.sportify.controller.PartidaController;
import com.sportify.model.Evento;
import com.sportify.tableModel.EventoTableModel;
import com.sportify.util.FactoryComponents;

public class ListagemEventoForm extends JFrame{

	private static final long serialVersionUID = 1L;
	private EventoController eventoController;
	private MenuForm menuForm;
	
	private String idAux;
	private String nameAux;
	private String localAux;
	private String dataInicioAux;
	private String dataFimAux;
	private String esporteAux;
	
	private List<Long> relacionamentos;
	
	private Evento evento = new Evento();
	
	private FactoryComponents factory;
	
	private JPanel panel;
	private JPanel panelButtons;
	
	private JTable table;
	
	private JButton buttonEdit;
	private JButton buttonRemove;
	private JButton buttonVoltar;
	private JButton buttonDetalhar;
	
	private DialogEventoRemoveForm removeDialog;
	
	List<Evento> listEventos = new ArrayList<>();
	
	public ListagemEventoForm(MenuForm menuForm, EventoController eventoController, PartidaController partidaController, ChaveController chaveController) {
		this.eventoController = eventoController;
		this.menuForm = menuForm;
		
		setTitle("Listagem de eventos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 220);
        
        factory = new FactoryComponents();
        
        panel = factory.createPanelList();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        EventoTableModel eventoTModel = new EventoTableModel(this.eventoController.getEventos());
		table = factory.createTableList(eventoTModel);
		
		panelButtons = factory.createPanelList();
		panelButtons.setLayout(new FlowLayout());
		panelButtons.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
        buttonEdit 	 = factory.createButtonList("Editar");
        buttonRemove = factory.createButtonList("Remover");
        buttonDetalhar = factory.createButtonList("Detalhar");
        buttonVoltar = factory.createButtonList("Voltar");
        
        panelButtons.add(buttonEdit);
        panelButtons.add(buttonRemove);
        panelButtons.add(buttonDetalhar);
        panelButtons.add(buttonVoltar);
        
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        panel.add(panelButtons, BorderLayout.SOUTH);
		
		add(panel);
		setLocationRelativeTo(null);
		
		/* ESCONDER COLUNA ID */
		this.hideColumnID(table);
		
        /* EDITAR */
		this.buttonEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() == -1) {
            		JOptionPane.showMessageDialog(
    				menuForm, 
    				"Nenhuma equipe selecionada", 
    				"Error", 
    				JOptionPane.ERROR_MESSAGE);
				} else {
					idAux 		  = table.getValueAt(table.getSelectedRow(), 0).toString();
					nameAux 	  = table.getValueAt(table.getSelectedRow(), 1).toString();
					localAux 	  = table.getValueAt(table.getSelectedRow(), 2).toString();
					dataInicioAux = table.getValueAt(table.getSelectedRow(), 3).toString();
					dataFimAux    = table.getValueAt(table.getSelectedRow(), 4).toString();
					esporteAux    = table.getValueAt(table.getSelectedRow(), 5).toString();
					
					evento.setId(Long.parseLong(idAux));
					evento.setNome(nameAux);
					evento.setLocal(localAux);
					evento.setEsporte(esporteAux);
					evento.setDataInicio(new Date());
					evento.setDataFim(new Date());
					
					SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
					
					try {
						evento.setDataInicio(formato.parse(dataInicioAux));
						evento.setDataFim(formato.parse(dataFimAux));
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					
					new DialogEventoEditForm(menuForm, evento, eventoController);
				}
			}
		});
		
		/* REMOVER */
		this.buttonRemove.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() == -1) {
            		JOptionPane.showMessageDialog(
    				menuForm, 
    				"Nenhum evento selecionado", 
    				"Error", 
    				JOptionPane.ERROR_MESSAGE);
				} else {
					idAux = table.getValueAt(table.getSelectedRow(), 0).toString();
					relacionamentos = eventoController.buscaRelacionamento(Long.parseLong(idAux));
					if(relacionamentos.size() > 0) {
	            		JOptionPane.showMessageDialog(
        				menuForm, 
        				"Não é possível excluir este evento, pois existem equipes vinculadas", 
        				"Error", 
        				JOptionPane.ERROR_MESSAGE);
					} else {
						removeDialog = new DialogEventoRemoveForm(menuForm, idAux, eventoController);
						removeDialog.factoryRemoveDialog().setVisible(true);
					}
				}
			}
		});
		
		/* DETALHAR */
		this.buttonDetalhar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() == -1) {
            		JOptionPane.showMessageDialog(
    				menuForm, 
    				"Nenhum evento selecionado", 
    				"Error", 
    				JOptionPane.ERROR_MESSAGE);
				} else {
					idAux = table.getValueAt(table.getSelectedRow(), 0).toString();
					new DialogEventoDetailForm(menuForm, Long.parseLong(idAux), eventoController, partidaController, chaveController);
				}
			}
		});
		
		/* VOLTAR */
		this.buttonVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				returnToMenu();
			}
		});
	}
	
	private void returnToMenu() {
		menuForm.setVisible(true);
		dispose();
	}
	
	public void hideColumnID(JTable table) {
        TableColumnModel columnModel = table.getColumnModel();
        TableColumn column = columnModel.getColumn(0);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column.setPreferredWidth(0);
        
        table.getTableHeader().resizeAndRepaint();
        table.repaint();

	}
	
}
