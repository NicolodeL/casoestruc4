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
            // Aquí va la lógica para buscar
        });

        System.out.println("Botón 'Buscar' creado");

        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.add(searchButton, BorderLayout.WEST);

        editorTexto.getFrame().getContentPane().add(buttonPanel, BorderLayout.NORTH);
        editorTexto.getFrame().revalidate();
        editorTexto.getFrame().repaint();

        System.out.println("Botón 'Buscar' agregado al JFrame");
    }
}
