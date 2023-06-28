package com.fbergeron.util;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuprototipo extends JFrame {
    public menuprototipo() {
        setTitle("Menu Inicial");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        JButton novoJogoButton = new JButton("Novo Jogo");
        JButton melhoresTemposButton = new JButton("Melhores Tempos");

        novoJogoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para iniciar um novo jogo
                JOptionPane.showMessageDialog(null, "Iniciar novo jogo!");
            }
        });

        melhoresTemposButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para exibir melhores tempos
                JOptionPane.showMessageDialog(null, "Exibir melhores tempos!");
            }
        });

        panel.add(novoJogoButton);
        panel.add(melhoresTemposButton);
        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new menuprototipo();
            }
        });
    }
}
