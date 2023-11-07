package com.sportify.view;

import java.awt.BorderLayout;
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
	
	private JPanel panel;
	private JPanel panelButtons;
	
	private JTable table;
	
	List<Equipe> listNomes;
	
	private List<Long> relacionamentos;
	
	public ListagemEquipeForm(EquipeController equipeController, MenuForm menuForm) {
		this.equipeController = equipeController;
		this.menuForm = menuForm;
		
		setTitle("Listagem de Equipes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 220);
        
        factory = new FactoryComponents();
        
    	panel = factory.createPanelList();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    	  
        EquipeTableModel equipeTModel = new EquipeTableModel(this.equipeController.getEquipes());
        table = factory.createTableList(equipeTModel);
        
        panelButtons = factory.createPanelList();
        panelButtons.setLayout(new FlowLayout());
        panelButtons.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        buttonEdit 	 = factory.createButtonList("Editar");
        buttonRemove = factory.createButtonList("Remover");
        buttonVoltar = factory.createButtonList("Voltar");
         
        panelButtons.add(buttonEdit);
        panelButtons.add(buttonRemove);
        panelButtons.add(buttonVoltar);
        
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        panel.add(panelButtons, BorderLayout.SOUTH);
        
        add(panel);
        setLocationRelativeTo(null);
        
        /* ESCONDER COLUNA ID */
        this.hideColumnID(table);
        
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
            		
            		DialogEquipeEditForm editDialog = new DialogEquipeEditForm(menuForm, idAux, nameAux, equipeController);
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


