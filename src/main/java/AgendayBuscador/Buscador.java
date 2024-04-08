package AgendayBuscador;

import EditorInteractivo.EditorTexto;

import javax.swing.*;
import java.awt.*;

public class Buscador {
    private EditorTexto editorTexto;

    public Buscador(EditorTexto editorTexto) {
        this.editorTexto = editorTexto;
        createSearchButton();
    }

    private void createSearchButton() {
        JButton searchButton = new JButton("Buscar");
        searchButton.addActionListener(e -> {
            String wordToFind = JOptionPane.showInputDialog("Introduce la palabra que quieres buscar");
            if (wordToFind != null && !wordToFind.isEmpty()) {
                JTextArea textArea = editorTexto.getTextArea();
                if (textArea != null) {
                    String text = textArea.getText();
                    String[] words = text.split("\\s+");
                    int count = 0;
                    for (String word : words) {
                        if (word.equals(wordToFind)) {
                            count++;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "La palabra '" + wordToFind + "' aparece " + count + " veces.");
                } else {
                    System.out.println("No se pudo obtener el área de texto");
                }
            }
        });

        System.out.println("Botón 'Buscar' creado");

        JPanel buttonPanel = new JPanel(null); // Establecer el layout a null
        searchButton.setBounds(50, 50, 100, 30); // Establecer las coordenadas y el tamaño del botón
        buttonPanel.add(searchButton);

        editorTexto.getFrame().getContentPane().add(buttonPanel);
        editorTexto.getFrame().revalidate();
        editorTexto.getFrame().repaint();

        System.out.println("Botón 'Buscar' agregado al JFrame");
    }
}