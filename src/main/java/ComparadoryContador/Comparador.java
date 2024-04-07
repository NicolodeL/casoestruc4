package ComparadoryContador;

import EditorInteractivo.EditorTexto;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Comparador {
    private EditorTexto editorTexto;

    public Comparador(EditorTexto editorTexto) {
        this.editorTexto = editorTexto;
        createCompareButton();
    }

    private void createCompareButton() {
        JButton compareButton = new JButton("Comparar archivos");
        compareButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setMultiSelectionEnabled(true);
            fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos de texto", "txt"));
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File[] files = fileChooser.getSelectedFiles();
                if (files.length == 2) {
                    if (files[0].isFile() && files[1].isFile() && files[0].canRead() && files[1].canRead()) {
                        compareFiles(files[0], files[1]);
                    } else {
                        JOptionPane.showMessageDialog(null, "Uno o ambos archivos no son válidos o no se pueden leer");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, selecciona exactamente dos archivos para comparar");
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.add(compareButton);
        buttonPanel.add(new JLabel()); // Componente vacío para ocupar la mitad derecha
        editorTexto.getFrame().getContentPane().add(buttonPanel, BorderLayout.NORTH);
        editorTexto.getFrame().revalidate();
        editorTexto.getFrame().repaint();
    }

    public void compareFiles(File file1, File file2) {
        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1));
             BufferedReader reader2 = new BufferedReader(new FileReader(file2))) {

            String line1 = reader1.readLine();
            String line2 = reader2.readLine();

            while (line1 != null || line2 != null) {
                if (line1 == null || line2 == null || !line1.equals(line2)) {
                    System.out.println("Los archivos son diferentes.");
                    return;
                }
                line1 = reader1.readLine();
                line2 = reader2.readLine();
            }

            System.out.println("Los archivos son iguales.");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al comparar los archivos");
            e.printStackTrace();
        }
    }
}