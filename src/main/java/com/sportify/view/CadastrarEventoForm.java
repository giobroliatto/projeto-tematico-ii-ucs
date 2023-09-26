package com.sportify.view;

import javax.swing.*;
import com.sportify.controller.EquipeController;
import com.sportify.controller.EquipeEventoController;
import com.sportify.controller.EventoController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CadastrarEventoForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField nomeField;
    private JTextField localField;
    private JTextField dataInicioField;
    private JTextField dataFimField;
    private JTextField esporteField;
    private JComboBox<Integer> quantidadeEquipesComboBox;
    private JButton criarEventoButton;
    private JButton retornarMenuButton;
    private EventoController eventoController;
    private EquipeController equipeController;
    private EquipeEventoController equipeEventoController;
    private MenuForm menuForm;

    public CadastrarEventoForm(EventoController eventoController, EquipeController equipeController, EquipeEventoController equipeEventoController, MenuForm menuForm) {
        this.eventoController = eventoController;
        this.equipeController = equipeController;
        this.equipeEventoController = equipeEventoController;
        this.menuForm = menuForm;

        setTitle("Cadastro de Evento");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 450);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Título
        JLabel titleLabel = new JLabel("Cadastrar evento");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titleLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Espaçamento

        // Campos de Evento
        nomeField = createInputField(panel, "Nome do evento:");
        localField = createInputField(panel, "Local do evento:");
        dataInicioField = createInputField(panel, "Data de início:");
        dataFimField = createInputField(panel, "Data de término:");
        esporteField = createInputField(panel, "Esporte:");

        // ComboBox para quantidade de equipes
        JLabel quantidadeEquipesLabel = new JLabel("Quantidade de equipes:");
        quantidadeEquipesComboBox = new JComboBox<>(new Integer[]{2, 4, 8, 16});
        JPanel quantidadeEquipesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        quantidadeEquipesPanel.add(quantidadeEquipesLabel);
        quantidadeEquipesPanel.add(quantidadeEquipesComboBox);
        panel.add(quantidadeEquipesPanel);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Botão Criar Evento
        criarEventoButton = new JButton("Selecionar equipes");
        criarEventoButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(criarEventoButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaçamento

        // Botão Retornar ao Menu
        retornarMenuButton = new JButton("Retornar ao menu");
        retornarMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(retornarMenuButton);

        criarEventoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createEvento();
            }
        });

        retornarMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                returnToMenu();
            }
        });

        add(panel);
        setLocationRelativeTo(null);
    }

    private JTextField createInputField(JPanel panel, String labelText) {
        JLabel label = new JLabel(labelText);
        JTextField textField = new JTextField();

        // Define o tamanho preferencial dos campos de entrada
        textField.setColumns(20); // Ajuste o tamanho desejado aqui

        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Alinhe os campos à direita

        inputPanel.add(label);
        inputPanel.add(textField);

        panel.add(inputPanel);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaçamento entre os campos

        return textField;
    }

    private void createEvento() {
        String nome = nomeField.getText();
        String local = localField.getText();
        String dataInicioStr = dataInicioField.getText();
        String dataFimStr = dataFimField.getText();
        String esporte = esporteField.getText();
        int quantidadeEquipes = (Integer) quantidadeEquipesComboBox.getSelectedItem(); // Obtém a quantidade de equipes selecionada

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date dataInicio = dateFormat.parse(dataInicioStr);
            Date dataFim = dateFormat.parse(dataFimStr);

            String mensagemErro = eventoController.validateEvento(nome, local, dataInicio, dataFim, esporte);

            if (mensagemErro != null) {
                JOptionPane.showMessageDialog(this, mensagemErro);
            } else {
                long eventoId = eventoController.createEvento(nome, local, dataInicio, dataFim, esporte);

                nomeField.setText("");
                localField.setText("");
                dataInicioField.setText("");
                dataFimField.setText("");
                esporteField.setText("");

                JOptionPane.showMessageDialog(this, "Selecione as equipes que participarão deste evento.");

                VinculoEquipesForm vinculoEquipesForm = new VinculoEquipesForm(eventoController, equipeController, equipeEventoController, eventoId, quantidadeEquipes);
                vinculoEquipesForm.setVisible(true);
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Formato de data inválido. Use dd/mm/aaaa.");
        }
    }

    private void returnToMenu() {
        menuForm.setVisible(true);
        dispose();
    }
}
