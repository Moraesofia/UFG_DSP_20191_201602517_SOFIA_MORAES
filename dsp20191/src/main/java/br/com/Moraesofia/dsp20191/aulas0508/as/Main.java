package br.com.Moraesofia.dsp20191.aulas0508.as;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Atividade supervisionada aulas0508.
 *
 * @author sofia
 *
 */
public class Main {

    private static String DAT_FILE = "avaliacao.dat";

    private static Double MEDIA = 5.0;

    public static void main(String[] args) throws IOException {

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        storeAlunoInDat(classLoader);

        retrieveAlunoFromDat(classLoader);

    }

    public static void retrieveAlunoFromDat(ClassLoader classLoader)
            throws FileNotFoundException, IOException {
        // Exercicio 6
        DataInputStream dataIn = new DataInputStream(new FileInputStream(
                classLoader.getResource(DAT_FILE).getFile()));

        Aluno novoAluno = new Aluno();
        novoAluno.setNome(dataIn.readUTF());
        novoAluno.setMatricula(dataIn.readLong());
        novoAluno.setNota1(dataIn.readDouble());
        novoAluno.setNota2(dataIn.readDouble());
        dataIn.close();

        Double mediaAluno = novoAluno.getNota1() + novoAluno.getNota2() / 2;
        String resultado = getResultado(mediaAluno);

        imprimeAluno(novoAluno, resultado);
    }

    public static void storeAlunoInDat(ClassLoader classLoader)
            throws FileNotFoundException, IOException {
        // Exercicio 5
        Aluno aluno = new Aluno("Sofia", 123456L, 4.0, 6.0);

        DataOutputStream dataOut = new DataOutputStream(new FileOutputStream(
                classLoader.getResource(DAT_FILE).getFile()));

        dataOut.writeUTF(aluno.getNome());
        dataOut.writeLong(aluno.getMatricula());
        dataOut.writeDouble(aluno.getNota1());
        dataOut.writeDouble(aluno.getNota2());
        dataOut.flush();
        dataOut.close();
    }

    public static String getResultado(Double media) {
        return (media >= MEDIA) ? "Aprovado" : "Reprovado";

    }

    public static void imprimeAluno(Aluno aluno, String result) {
        System.out.println("Nome: " + aluno.getNome());
        System.out.println("Matricula: " + aluno.getMatricula());
        System.out.println(
                "N1 = " + aluno.getNota1() + " | N2 = " + aluno.getNota2());
        System.out.println("Resultado: " + result);
    }

}
