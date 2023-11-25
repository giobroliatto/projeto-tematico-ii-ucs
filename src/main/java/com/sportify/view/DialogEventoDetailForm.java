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
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		_dataInicio = dateFormat.format(evento.getDataInicio());
		_dataFim = dateFormat.format(evento.getDataFim());
		
		dialog = factory.createJDialog(menuForm, "Detalhar evento");
		dialog.setSize(300, 200);
		dialog.setLayout(new FlowLayout());
		
		panel = new JPanel(new GridLayout(0, 1));
		 
		nomeLabel = new JLabel("Nome: " + evento.getNome());
		localLabel = new JLabel("Local: " + evento.getLocal());
		dataInicioLabel = new JLabel("Data de início: " + _dataInicio);
		dataFimLabel = new JLabel("Data final: " + _dataFim);
		esporteLabel = new JLabel("Esporte: " + evento.getEsporte());
		
		panel.add(nomeLabel);
		panel.add(localLabel);
		panel.add(dataInicioLabel);
		panel.add(dataFimLabel);
		panel.add(esporteLabel);
		
		buttonGerarChave = factory.createButtonList("Gerar chave");
		
		buttonVerChave = factory.createButtonList("Ver chave");	
		
		verificaChave = eventoController.buscaRelacionamentoComChave(idEvento);
		if(verificaChave.size() > 0) {
			dialog.add(buttonVerChave);
		} else if(verificaChave.size() == 0) {
			dialog.add(buttonGerarChave);
		}
		
        dialog.add(panel);
	
		dialog.setVisible(true);
		
		/* VER CHAVE */
		buttonVerChave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChaveForm chaveForm = new ChaveForm(idEvento, partidaController, chaveController);
                chaveForm.setVisible(true);
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
            }
        });
	}
}
