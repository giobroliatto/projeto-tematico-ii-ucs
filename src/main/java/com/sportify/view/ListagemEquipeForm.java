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

public class ListagemEquipeForm extends JFrame {
	
	private EquipeController equipeController;
	private MenuForm menuForm;
	
	private String idAux;
	private String nameAux;
	
	List<Equipe> listNomes;
	
	public ListagemEquipeForm(EquipeController equipeController, MenuForm menuForm) {
		this.equipeController = equipeController;
		this.menuForm = menuForm;
		
		setTitle("Listagem de Equipes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 220);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
          
        EquipeTableModel equipeTModel = new EquipeTableModel(this.equipeController.getEquipes());
        JTable jTable = new JTable(equipeTModel); 
        
        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new FlowLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JButton buttonEdit = new JButton();
        buttonEdit.setText("Editar");
        
        JButton buttonRemove = new JButton();
        buttonRemove.setText("Remover");
        
        JButton buttonVoltar = new JButton();
        buttonVoltar.setText("Voltar");
       
        /* Esconder coluna ID */
        this.hideColumnID(jTable);
        
        buttonEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(jTable.getSelectedRow() == -1) {
            		JOptionPane.showMessageDialog(
    				menuForm, 
    				"Nenhuma equipe selecionada", 
    				"Error", 
    				JOptionPane.ERROR_MESSAGE);
            	} else {
            		idAux = jTable.getValueAt(jTable.getSelectedRow(), 0).toString();
            		nameAux = jTable.getValueAt(jTable.getSelectedRow(), 1).toString();
            		
            		DialogEditForm editDialog = new DialogEditForm(menuForm, idAux, nameAux, equipeController);
                	editDialog.factoryEditDialog().setVisible(true);
            	}
        	}
        });
        
        buttonRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(jTable.getSelectedRow() == -1) {
            		JOptionPane.showMessageDialog(
    				menuForm, 
    				"Nenhuma equipe selecionada", 
    				"Error", 
    				JOptionPane.ERROR_MESSAGE);
            	} else {
            		idAux = jTable.getValueAt(jTable.getSelectedRow(), 0).toString();
            		
                	DialogRemoveForm removeDialog = new DialogRemoveForm(menuForm, idAux, equipeController);
                	removeDialog.factoryRemoveDialgo().setVisible(true);
                	
                	System.out.println("TESTE");
                	
            	}
            }
        });
        
        buttonVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				returnToMenu();
			}
		});
        
        panelButtons.add(buttonEdit);
        panelButtons.add(buttonRemove);
        panelButtons.add(buttonVoltar);
        
        panel.add(new JScrollPane(jTable), BorderLayout.CENTER);
        panel.add(panelButtons, BorderLayout.SOUTH);
        
        add(panel);
        setLocationRelativeTo(null);
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


