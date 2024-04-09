package org.example;

import AgendayBuscador.Agenda;
import ComparadoryContador.Comparador;
import ComparadoryContador.Contador;
import AgendayBuscador.Buscador;
import EditorInteractivo.EditorTexto;
import EmailyDiseñografico.Dibujo;
import InterfazAvanzada.Raton;
import InterfazAvanzada.Ventana;
import  EmailyDiseñografico.Email;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        EditorTexto editorTexto = new EditorTexto();

        Comparador comparador = new Comparador(editorTexto);
        Contador contador = new Contador(editorTexto);
        Buscador buscador = new Buscador(editorTexto);
        Agenda agenda = new Agenda(editorTexto);
        Raton raton = new Raton(editorTexto);
        Email email = new Email();
        Dibujo dibujo = new Dibujo();

        JButton compareButton = comparador.createCompareButton();
        JButton countButton = contador.createCountButton();
        JButton searchButton = buscador.createSearchButton();
        JButton agendaButton = agenda.createAgendaButton();
        JButton emailButton = email.createEmailButton();
        JButton dibujoButton = dibujo.createDibujoButton();

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        buttonPanel.add(compareButton);
        buttonPanel.add(countButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(agendaButton);
        buttonPanel.add(emailButton);
        buttonPanel.add(dibujoButton);

        editorTexto.getFrame().getContentPane().add(buttonPanel, BorderLayout.NORTH);
        editorTexto.getFrame().revalidate();
        editorTexto.getFrame().repaint();

        File file1 = new File("ruta/al/archivo1.txt");
        File file2 = new File("ruta/al/archivo2.txt");

        comparador.compareFiles(file1, file2);
    }
}