package InterfazAvanzada;

import EditorInteractivo.EditorTexto;

import javax.swing.*;
import java.awt.event.MouseMotionAdapter;

public class Raton extends MouseMotionAdapter {
    private EditorTexto editorTexto;

    public Raton(EditorTexto editorTexto) {
        this.editorTexto = editorTexto;

        // Agregar este objeto como MouseMotionListener al editor de texto
        this.editorTexto.getFrame().addMouseMotionListener(this);
    }

    @Override
    public void mouseMoved(java.awt.event.MouseEvent e) {
        // Actualizar la etiqueta con la posición del ratón
        editorTexto.getMousePositionLabel().setText("Mouse Position: " + e.getX() + ", " + e.getY());
    }
}
