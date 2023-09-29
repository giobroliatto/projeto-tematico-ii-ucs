package com.sportify.view;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

public class PartidaPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private JLabel equipeALabel;
    private JLabel equipeBLabel;
    private JLabel placarALabel;
    private JLabel placarBLabel;
    private JButton detalhesButton;

    public PartidaPanel(String equipeA, String equipeB) {
        equipeALabel = new JLabel(equipeA);
        equipeBLabel = new JLabel(equipeB);
        placarALabel = new JLabel("0");
        placarBLabel = new JLabel("0");
        detalhesButton = new JButton("Detalhes");

        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.insets = new Insets(0, 10, 0, 10);

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

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 3; 
        constraints.insets = new Insets(10, 0, 0, 0);
        add(detalhesButton, constraints);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        setBorder(border);
    }
}
