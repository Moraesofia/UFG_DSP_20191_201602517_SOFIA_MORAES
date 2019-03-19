package br.com.Moraesofia.dsp20191.aulas0104.as;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ExercicioTres {

    private static String fileName = "Arquivo.txt";

    public static void main(String[] args) {

        PrintWriter pw;
        try {
            pw = new PrintWriter(new FileWriter(fileName, true));

            pw.println();
            pw.println("---- Novo Conteúdo:");
            pw.println("linha um");
            pw.println("linha dois");
            pw.println("linha três");
            pw.println("linha quatro");
            pw.println("linha cinco");

            pw.close();
            pw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
