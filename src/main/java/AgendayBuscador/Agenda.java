package AgendayBuscador;

import EditorInteractivo.EditorTexto;

import javax.swing.*;

public class Agenda {
    private EditorTexto editorTexto;

    public Agenda(EditorTexto editorTexto) {
        this.editorTexto = editorTexto;
    }

    public JButton createAgendaButton() {
        JButton agendaButton = new JButton("Agenda");
        agendaButton.addActionListener(e -> {
            // Aquí va la lógica para la funcionalidad de la agenda
        });

        return agendaButton;
    }
}
