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

    public JButton createSearchButton() {
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

        return searchButton;


    }

}