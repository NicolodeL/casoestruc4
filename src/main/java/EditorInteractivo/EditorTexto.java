package EditorInteractivo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EditorTexto implements InterfazEditorTexto{
    private JTextArea textArea;
    private JFrame frame;
    private JList<String> documentList;
    private ArrayList<File> documents;

    public EditorTexto() {
        frame = new JFrame("Editor de Texto");

        documents = new ArrayList<>();
        documentList = new JList<>();

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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void saveTextToFile() {
        try (FileWriter writer = new FileWriter("output.txt")) {
            writer.write(textArea.getText());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error al guardar el archivo");
        }
    }
}
