package com.sportify.view;

import com.sportify.controller.EquipeController;
import com.sportify.controller.EquipeEventoController;
import com.sportify.controller.EventoController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JButton cadastrarEquipeButton;
    private JButton cadastrarEventoButton;
    private JButton listarEquipesButton;
    private JButton listarEventosButton;
    
    // REMOVER: Adicionar input e botão
    private JTextField idEventoInput;
    private JButton gerarChaveButton;

    public MenuForm(EquipeController equipeController, EventoController eventoController, EquipeEventoController equipeEventoController) {
        setTitle("SPORTIFY");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 380);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Título
        JLabel titleLabel = new JLabel("SPORTIFY");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titleLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Espaçamento

        // Seção "Cadastros"
        JLabel cadastrosLabel = new JLabel("Cadastros");
        cadastrosLabel.setFont(new Font("Arial", Font.BOLD, 16));
        cadastrosLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(cadastrosLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaçamento

        cadastrarEquipeButton = new JButton("Cadastrar equipe");
        cadastrarEquipeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(cadastrarEquipeButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaçamento

        cadastrarEventoButton = new JButton("Cadastrar evento");
        cadastrarEventoButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(cadastrarEventoButton);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Espaçamento

        // Seção "Listagens"
        JLabel listagemLabel = new JLabel("Listagens");
        listagemLabel.setFont(new Font("Arial", Font.BOLD, 16));
        listagemLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(listagemLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaçamento

        listarEquipesButton = new JButton("Listar equipes");
        listarEquipesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(listarEquipesButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaçamento

        listarEventosButton = new JButton("Listar eventos");
        listarEventosButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(listarEventosButton);

        // REMOVER: Adicionar input e botão
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        idEventoInput = new JTextField(10); // Defina o tamanho desejado
        gerarChaveButton = new JButton("Gerar Chave"); // Botão para gerar a chave
        
        JPanel gerarChavePanel = new JPanel();
        gerarChavePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        gerarChavePanel.add(idEventoInput);
        gerarChavePanel.add(gerarChaveButton);
        panel.add(gerarChavePanel);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaçamento

        cadastrarEquipeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadastrarEquipeForm equipeForm = new CadastrarEquipeForm(equipeController, MenuForm.this);
                setVisible(false);
                equipeForm.setVisible(true);
            }
        });

        cadastrarEventoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadastrarEventoForm eventoForm = new CadastrarEventoForm(eventoController, equipeController, equipeEventoController, MenuForm.this);
                setVisible(false);
                eventoForm.setVisible(true);
            }
        });

        listarEquipesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TO DO lógica para listar equipes
            }
        });

        listarEventosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TO DO lógica para listar eventos
            }
        });
        
        // REMOVER: Adicionar ação para o botão de gerar chave
        gerarChaveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtenha o ID do evento a partir do input
                Long idEvento = Long.valueOf(idEventoInput.getText());
                
                // Chame o método para gerar a chave
                equipeEventoController.gerarChave(idEvento);
                
                // Adicione aqui qualquer ação adicional após gerar a chave
            }
        });

        add(panel);
        setLocationRelativeTo(null); 
    }
}
