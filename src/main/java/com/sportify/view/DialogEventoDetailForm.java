package com.sportify.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sportify.controller.ChaveController;
import com.sportify.controller.EventoController;
import com.sportify.controller.PartidaController;
import com.sportify.model.Evento;
import com.sportify.util.FactoryComponents;

public class DialogEventoDetailForm {
	
	private EventoController eventoController;
	
	private JDialog dialog;
	
	private JLabel nomeLabel;
	private JLabel localLabel;
	private JLabel dataInicioLabel;	
	private JLabel dataFimLabel;
	private JLabel esporteLabel;
	
	private String _dataInicio;
	private String _dataFim;
	
	private JPanel panel;
	
	private JButton buttonVerChave;
	private JButton buttonGerarChave;
	
	private List<Long> verificaChave;
	
	private Evento evento;
	
	FactoryComponents factory;
	
	public DialogEventoDetailForm(MenuForm menuForm, Long idEvento, EventoController eventoController, PartidaController partidaController, ChaveController chaveController) {
		this.eventoController = eventoController;
		
		evento = this.eventoController.getEveto(idEvento);
		
		factory = new FactoryComponents();
		
		dialog = factory.createJDialog(menuForm, "Detalhar evento");
		dialog.setSize(380, 250);
		dialog.setLayout(new FlowLayout());
		
		panel = new JPanel(new GridLayout(0, 1));
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		_dataInicio = dateFormat.format(evento.getDataInicio());
		_dataFim = dateFormat.format(evento.getDataFim());
		 
		
		nomeLabel = factory.createJLabel("Nome: " + evento.getNome());
		localLabel = factory.createJLabel("Local: " + evento.getLocal());
		dataInicioLabel = factory.createJLabel("Data de início: " + _dataInicio);
		dataFimLabel = factory.createJLabel("Data final: " + _dataFim);
		esporteLabel = factory.createJLabel("Esporte: " + evento.getEsporte());
		
		panel.add(nomeLabel);
		panel.add(localLabel);
		panel.add(dataInicioLabel);
		panel.add(dataFimLabel);
		panel.add(esporteLabel);
		
		buttonGerarChave = factory.createButtonList("Gerar chave");
		
		buttonVerChave = factory.createButtonList("Ver chave");	
		
		
		verificaChave = eventoController.buscaRelacionamentoComChave(idEvento);
		if(verificaChave.size() > 0) {
			panel.add(buttonVerChave);
		} else if(verificaChave.size() == 0) {
			panel.add(buttonGerarChave);
		}
		
        dialog.add(panel);
        
        dialog.setLocationRelativeTo(menuForm);
		dialog.setVisible(true);
		
		/* VER CHAVE */
		buttonVerChave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChaveForm chaveForm = new ChaveForm(idEvento, partidaController, chaveController);
                chaveForm.setVisible(true);
                dialog.setVisible(false);
            }
        });
		
		/* GERAR CHAVE */
		buttonGerarChave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String mensagemErro = chaveController.validateChaveByIdEvento(idEvento);
                if (mensagemErro != null) {
                    JOptionPane.showMessageDialog(null, mensagemErro);
                } else {
	                chaveController.createChave(idEvento);
	                JOptionPane.showMessageDialog(null, "Partidas e chave gerados com sucesso");
                }
                dialog.setVisible(false);
            }
        });
	}
}
