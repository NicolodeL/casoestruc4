package EditorInteractivo;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class EditorTexto implements InterfazEditorTexto {
    private JTextArea textArea;
    private JFrame frame;
    private JList<String> documentList;
    private ArrayList<File> documents;

    private JLabel mousePositionLabel;

    public JFrame getFrame() {
        return frame;
    }
    public EditorTexto() {
        frame = new JFrame("Editor de Texto");
        documents = new ArrayList<>();
        documentList = new JList<>();

        // Cargar documentos existentes
        File folder = new File(".");
        for (File file : folder.listFiles()) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                documents.add(file);
            }
        }

        // Actualizar JList
        updateDocumentList();

        documentList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                loadDocument(documents.get(documentList.getSelectedIndex()));
            }
        });

        JButton saveButton = new JButton("Guardar");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveTextToFile();
            }
        });

        textArea = new JTextArea(16, 60);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        frame.getContentPane().add(scrollPane);
        frame.getContentPane().add(saveButton, "South");
        frame.getContentPane().add(new JScrollPane(documentList), "East");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        mousePositionLabel = new JLabel();
        frame.getContentPane().add(mousePositionLabel, "South");
    }

    private void updateDocumentList() {
        String[] fileNames = new String[documents.size()];
        for (int i = 0; i < documents.size(); i++) {
            fileNames[i] = documents.get(i).getName();
        }
        documentList.setListData(fileNames);
    }

    private void loadDocument(File file) {
        try {
            textArea.setText(new String(Files.readAllBytes(Paths.get(file.getPath()))));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error al cargar el archivo");
        }
    }

    @Override
    public void saveTextToFile() {
        File fileToWrite;
        if (documentList.getSelectedIndex() != -1) {
            fileToWrite = documents.get(documentList.getSelectedIndex());
        } else {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            LocalDateTime now = LocalDateTime.now();
            String uniqueFileName = "output" + dtf.format(now) + ".txt";
            fileToWrite = new File(uniqueFileName);
            documents.add(fileToWrite);
            updateDocumentList();
        }

        try (FileWriter writer = new FileWriter(fileToWrite)) {
            writer.write(textArea.getText());
            System.out.println("Archivo guardado: " + fileToWrite.getName());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error al guardar el archivo");
        }
    }

    @Override
    public void compareFiles() {

    }

    public Component getCompareButton() {
        return null;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void updateTextArea(String s) {
    }
    public JLabel getMousePositionLabel() {
        return mousePositionLabel;
    }
}
