package ComparadoryContador;

import EditorInteractivo.EditorTexto;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Contador {
    private EditorTexto editorTexto;

    public Contador(EditorTexto editorTexto) {
        this.editorTexto = editorTexto;
        createCountButton();
    }

    private void createCountButton() {
        JButton countButton = new JButton("Contar");
        countButton.addActionListener(e -> {
            String text = editorTexto.getTextArea().getText();
            String[] words = text.split("\\s+");
            int wordCount = words.length;

            Map<String, Integer> wordUsage = new HashMap<>();
            for (String word : words) {
                wordUsage.put(word, wordUsage.getOrDefault(word, 0) + 1);
            }

            System.out.println("Número de palabras: " + wordCount);
            System.out.println("Estadísticas de uso de palabras: " + wordUsage);
        });

        System.out.println("Botón 'Contar' creado");

        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.add(countButton, BorderLayout.EAST);

        editorTexto.getFrame().getContentPane().add(buttonPanel, BorderLayout.NORTH);
        editorTexto.getFrame().revalidate();
        editorTexto.getFrame().repaint();

        System.out.println("Botón 'Contar' agregado al JFrame");
    }
}

