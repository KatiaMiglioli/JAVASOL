package com.fbergeron.util;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.*;

public class SolitaireRanking extends JFrame {
    private JTextArea textArea;

    public SolitaireRanking() {
        setTitle("Solitaire Ranking");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(500, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(new Color(7, 103, 45));

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));
        textArea.setForeground(Color.WHITE);
        textArea.setOpaque(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);

        add(scrollPane, BorderLayout.CENTER);

        loadJSONData();

        setVisible(true);
    }

    private void loadJSONData() {
        try {
            String jsonFilePath = "C:\\Users\\ktmig\\Desktop\\MS28S\\ranking.json"; // Caminho para o arquivo JSON
            String jsonData = new String(Files.readAllBytes(Paths.get(jsonFilePath)));

            // Exibe os itens do ranking
            textArea.setText(jsonData);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao ler o arquivo JSON.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SolitaireRanking());
    }
}
