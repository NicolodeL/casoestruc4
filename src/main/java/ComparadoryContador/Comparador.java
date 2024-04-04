package ComparadoryContador;

import EditorInteractivo.EditorTexto;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

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
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File[] files = fileChooser.getSelectedFiles();
                if (files.length == 2) {
                    compareFiles(files[0], files[1]);
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, selecciona exactamente dos archivos para comparar");
                }
            }
        });
        editorTexto.getFrame().add(compareButton);
    }

    public void compareFiles(File file1, File file2) {
        try {
            byte[] file1Content = Files.readAllBytes(Paths.get(file1.getPath()));
            byte[] file2Content = Files.readAllBytes(Paths.get(file2.getPath()));

            if (Arrays.equals(file1Content, file2Content)) {
                System.out.println("Los archivos son iguales.");
            } else {
                System.out.println("Los archivos son diferentes.");
            }
        } catch (IOException e) {
            System.out.println("Error al comparar los archivos");
            e.printStackTrace();
        }
    }
}
