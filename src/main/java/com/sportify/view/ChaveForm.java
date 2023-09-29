package com.sportify.view;

import javax.swing.*;
import java.awt.*;

public class ChaveForm extends JFrame {
    private static final long serialVersionUID = 1L;

    public ChaveForm() {
        setTitle("Chaves de Jogos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);

        PartidaPanel partidaOitavas1 = new PartidaPanel("Equipe A", "Equipe B");
        PartidaPanel partidaOitavas2 = new PartidaPanel("Equipe C", "Equipe D");
        PartidaPanel partidaOitavas3 = new PartidaPanel("Equipe E", "Equipe F");
        PartidaPanel partidaOitavas4 = new PartidaPanel("Equipe G", "Equipe H");
        PartidaPanel partidaQuartas1 = new PartidaPanel("Vencedor Oitavas 1", "Vencedor Oitavas 2");
        PartidaPanel partidaQuartas2 = new PartidaPanel("Vencedor Oitavas 3", "Vencedor Oitavas 4");
        PartidaPanel partidaSemi1 = new PartidaPanel("Vencedor Quartas 1", "Vencedor Quartas 2");
        PartidaPanel partidaFinal = new PartidaPanel("Vencedor Semi 1", "Vencedor Semi 2");
        PartidaPanel partidaSemi2 = new PartidaPanel("Vencedor Quartas 3", "Vencedor Quartas 4");
        PartidaPanel partidaQuartas3 = new PartidaPanel("Vencedor Oitavas 5", "Vencedor Oitavas 6");
        PartidaPanel partidaQuartas4 = new PartidaPanel("Vencedor Oitavas 7", "Vencedor Oitavas 8");
        PartidaPanel partidaOitavas5 = new PartidaPanel("Equipe I", "Equipe J");
        PartidaPanel partidaOitavas6 = new PartidaPanel("Equipe K", "Equipe L");
        PartidaPanel partidaOitavas7 = new PartidaPanel("Equipe M", "Equipe N");
        PartidaPanel partidaOitavas8 = new PartidaPanel("Equipe O", "Equipe P");

        JPanel fase1Panel = new JPanel(new GridLayout(1, 4));
        fase1Panel.add(partidaOitavas1);
        fase1Panel.add(partidaOitavas2);
        fase1Panel.add(partidaOitavas3);
        fase1Panel.add(partidaOitavas4);

        JPanel fase2Panel = new JPanel(new GridLayout(1, 2));
        fase2Panel.add(partidaQuartas1);
        fase2Panel.add(partidaQuartas2);

        JPanel fase3Panel = new JPanel(new GridLayout(1, 1));
        fase3Panel.add(partidaSemi1);

        JPanel fase4Panel = new JPanel(new GridLayout(1, 1));
        fase4Panel.add(partidaFinal);

        JPanel fase3Panel2 = new JPanel(new GridLayout(1, 2));
        fase3Panel2.add(partidaSemi2);

        JPanel fase2Panel2 = new JPanel(new GridLayout(1, 2));
        fase2Panel2.add(partidaQuartas3);
        fase2Panel2.add(partidaQuartas4);
        
        JPanel fase1Panel2 = new JPanel(new GridLayout(1, 4));
        fase1Panel2.add(partidaOitavas5);
        fase1Panel2.add(partidaOitavas6);
        fase1Panel2.add(partidaOitavas7);
        fase1Panel2.add(partidaOitavas8);

        JPanel chavesPanel = new JPanel(new GridLayout(7, 1));
        chavesPanel.add(fase1Panel);
        chavesPanel.add(fase2Panel);
        chavesPanel.add(fase3Panel);
        chavesPanel.add(fase4Panel);
        chavesPanel.add(fase3Panel2);
        chavesPanel.add(fase2Panel2);
        chavesPanel.add(fase1Panel2);

        add(chavesPanel);

        setLocationRelativeTo(null);
    }
}
