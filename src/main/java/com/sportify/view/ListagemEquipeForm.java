package com.sportify.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import com.sportify.controller.EquipeController;
import com.sportify.model.Equipe;
import com.sportify.tableModel.EquipeTableModel;
import com.sportify.util.FactoryComponents;

public class ListagemEquipeForm extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private EquipeController equipeController;
	private MenuForm menuForm;
	
	private String idAux;
	private String nameAux;
	private FactoryComponents factory;
	
	private JButton buttonEdit;
	private JButton buttonRemove;
	private JButton buttonVoltar;
	private JButton buttonAtualizar;
	
	private JPanel panel;
	private JPanel panelButtons;
	
	private JTable table;
	
	private EquipeTableModel equipeTModel;
	
	List<Equipe> listNomes;
	
	private List<Long> relacionamentos;
	
	public ListagemEquipeForm() {
		
	}
	
	public ListagemEquipeForm(EquipeController equipeController, MenuForm menuForm) {
		this.equipeController = equipeController;
		this.menuForm = menuForm;
		
        createTable();
        
        /* EDITAR */
        buttonEdit.addActionListener(new ActionListener() {	
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(table.getSelectedRow() == -1) {
            		JOptionPane.showMessageDialog(
    				menuForm, 
    				"Nenhuma equipe selecionada", 
    				"Error", 
    				JOptionPane.ERROR_MESSAGE);
            	} else {
            		idAux = table.getValueAt(table.getSelectedRow(), 0).toString();
            		nameAux = table.getValueAt(table.getSelectedRow(), 1).toString();
            		
            		new DialogEquipeEditForm(menuForm, idAux, nameAux, equipeController);
            	}
        	}
        });
        
        /* REMOVER */
        buttonRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	if(table.getSelectedRow() == -1) {
            		JOptionPane.showMessageDialog(
    				menuForm, 
    				"Nenhuma equipe selecionada", 
    				"Error", 
    				JOptionPane.ERROR_MESSAGE);
            	} else {
            		idAux = table.getValueAt(table.getSelectedRow(), 0).toString();
            		
            		relacionamentos = equipeController.buscaRelacionamento(Long.parseLong(idAux));
            		
            		if(relacionamentos.size() > 0) {
                		JOptionPane.showMessageDialog(
        				menuForm, 
        				"Não é possível excluir esta equipe, pois ela está vinculada com um ou mais eventos", 
        				"Error", 
        				JOptionPane.ERROR_MESSAGE);
            		} else {
                		DialogEquipeRemoveForm removeDialog = new DialogEquipeRemoveForm(menuForm, idAux, equipeController);
                    	removeDialog.factoryRemoveDialog().setVisible(true);
            		}
            	}
            }
        });
        
        /* VOLTAR */
        buttonVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				returnToMenu();
			}
		});
        	
        /* ATUALIZAR */
        buttonAtualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				equipeTModel = new EquipeTableModel(equipeController.getEquipes());
				table.setModel(equipeTModel);
				
		        /* ESCONDER COLUNA ID */
		        hideColumnID(table);
			}
		});
	}	
	
	private void returnToMenu() {
		menuForm.setVisible(true);
		dispose();
	}
	
	/**
	 * 
	 */
	public void createTable() {		
		setTitle("Listagem de Equipes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        
        factory = new FactoryComponents();
        
    	panel = factory.createPanelList();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    	  
        equipeTModel = new EquipeTableModel(this.equipeController.getEquipes());
        table = factory.createTableList(equipeTModel);
        
        panelButtons = factory.createPanelList();
        panelButtons.setLayout(new FlowLayout());
        panelButtons.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        buttonEdit = factory.createButtonList("Editar");
        
        buttonRemove = factory.createButtonList("Remover");
        buttonRemove.setBackground(new Color(134, 22, 20));

        buttonVoltar = factory.createButtonList("Voltar");
  
        buttonAtualizar = factory.createButtonList("Atualizar");

        
        
        panelButtons.add(buttonEdit);
        panelButtons.add(buttonRemove);
        panelButtons.add(buttonAtualizar);
        panelButtons.add(buttonVoltar);
        
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        panel.add(panelButtons, BorderLayout.SOUTH);
        
        add(panel);
        setLocationRelativeTo(null);
        
        /* ESCONDER COLUNA ID */
        this.hideColumnID(table);
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
	
	public void updateTable() {
		equipeTModel = new EquipeTableModel(equipeController.getEquipes());
		table.setModel(equipeTModel);
		
        /* ESCONDER COLUNA ID */
        hideColumnID(table);
	}
}


