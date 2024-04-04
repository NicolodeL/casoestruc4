package org.example;
import ComparadoryContador.Comparador;
import EditorInteractivo.EditorTexto;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        EditorTexto editorTexto = new EditorTexto();
        Comparador comparador = new Comparador();

        File file1 = new File("ruta/al/archivo1.txt");
        File file2 = new File("ruta/al/archivo2.txt");

        comparador.compareFiles(file1, file2);
}
}