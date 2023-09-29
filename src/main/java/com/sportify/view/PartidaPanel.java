package com.sportify.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.Border;

public class PartidaPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private JLabel equipeALabel;
    private JLabel equipeBLabel;
    private JLabel placarALabel;
    private JLabel placarBLabel;

    public PartidaPanel(String equipeA, String equipeB, boolean partidaFinal) {
        equipeALabel = new JLabel(equipeA);
        equipeBLabel = new JLabel(equipeB);
        placarALabel = new JLabel("0");
        placarBLabel = new JLabel("0");

        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.insets = new Insets(0, 10, 0, 10);
        
        if (partidaFinal) {
            add(equipeALabel, constraints);
            constraints.gridx = 1;
            add(placarALabel, constraints);
            constraints.gridx = 2;
            add(placarBLabel, constraints);
            constraints.gridx = 3;
            add(equipeBLabel, constraints);
        } else {
        	 constraints.gridx = 0;
             constraints.gridy = 0;
             constraints.anchor = GridBagConstraints.CENTER;
             add(equipeALabel, constraints);

             constraints.gridx = 2;
             constraints.gridy = 0;
             add(equipeBLabel, constraints);

             constraints.gridx = 0;
             constraints.gridy = 1;
             constraints.insets = new Insets(5, 0, 0, 10);
             add(placarALabel, constraints);

             constraints.gridx = 2;
             constraints.gridy = 1;
             constraints.insets = new Insets(5, 10, 0, 0);
             add(placarBLabel, constraints);
        }

        int padding = 10;
        Border paddingBorder = BorderFactory.createEmptyBorder(padding, padding, padding, padding);
        Border lineBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        Border compoundBorder = BorderFactory.createCompoundBorder(paddingBorder, lineBorder);

        setBorder(compoundBorder);

        // Adicione um ouvinte de clique ao painel
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Lógica a ser executada quando o painel for clicado
                // Por exemplo, abrir detalhes da partida
                abrirDetalhesDaPartida();
            }
        });
    }

    // Método para abrir detalhes da partida
    private void abrirDetalhesDaPartida() {
        // Implemente a lógica para abrir os detalhes da partida aqui
        // Por exemplo, exibir uma janela de diálogo com os detalhes da partida
        JOptionPane.showMessageDialog(this, "Detalhes da partida: Equipe A vs. Equipe B");
    }
}
