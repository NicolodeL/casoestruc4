package InterfazAvanzada;

import EditorInteractivo.EditorTexto;

import javax.swing.*;

public class Ventana extends JFrame {
    private EditorTexto editorTexto;

    public Ventana(EditorTexto editorTexto) {
        this.editorTexto = editorTexto;
        this.setContentPane(editorTexto.getFrame().getContentPane());
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public EditorTexto getEditorTexto() {
        return editorTexto;
    }
}