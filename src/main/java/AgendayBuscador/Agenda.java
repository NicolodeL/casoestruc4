package AgendayBuscador;

import EditorInteractivo.EditorTexto;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private EditorTexto editorTexto;
    private List<Contacto> contactos;

    public Agenda(EditorTexto editorTexto) {
        this.editorTexto = editorTexto;
        this.contactos = new ArrayList<>();
    }

    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
    }

    public void eliminarContacto(Contacto contacto) {
        contactos.remove(contacto);
    }

    public JButton createAgendaButton() {
        JButton agendaButton = new JButton("Agenda");
        agendaButton.addActionListener(e -> {
            StringBuilder contactosStr = new StringBuilder();
            for (Contacto contacto : contactos) {
                contactosStr.append("Nombre: ").append(contacto.getNombre())
                        .append(", Email: ").append(contacto.getEmail())
                        .append(", Teléfono: ").append(contacto.getNumeroTelefono())
                        .append("\n");
            }

            JOptionPane.showMessageDialog(null, "Contactos:\n" + contactosStr.toString());

            int respuesta = JOptionPane.showConfirmDialog(null, "¿Deseas agregar un nuevo contacto?", "Agregar contacto", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                String nombre = JOptionPane.showInputDialog("Introduce el nombre del contacto");
                String email = JOptionPane.showInputDialog("Introduce el email del contacto");
                String numeroTelefono = JOptionPane.showInputDialog("Introduce el número de teléfono del contacto");

                if (nombre != null && email != null && numeroTelefono != null) {
                    Contacto nuevoContacto = new Contacto(nombre, email, numeroTelefono);
                    agregarContacto(nuevoContacto);
                    JOptionPane.showMessageDialog(null, "Contacto agregado: " + nombre);
                }
            }
        });

        return agendaButton;
    }
}