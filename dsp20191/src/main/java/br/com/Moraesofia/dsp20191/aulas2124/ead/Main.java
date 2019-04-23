package br.com.Moraesofia.dsp20191.aulas2124.ead;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Atividade EAD - aulas2124.
 *
 * @author sofia
 *
 */
public class Main {

    private static String DAT_FILE = "aluno.dat";

    private static String RESOURCES_PATH = "src/main/resources/";

    public static void main(String[] args) throws IOException {

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        Aluno aluno = new Aluno("Sofia Moraes", 201602517L, "DESENVOLVIMENTO DE SOFTWARE PARA PERSISTÊNCIA", 8.0, 9.0);

        createFile();

        storeAlunoInDat(aluno, classLoader);

        retrieveAlunoFromDat(classLoader);

    }

    /**
     * Creates a new 'dat' file if it doesn't exist already.
     *
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static void createFile() throws IOException, FileNotFoundException {
        File yourFile = new File(RESOURCES_PATH + DAT_FILE);
        yourFile.createNewFile();
        FileOutputStream oFile = new FileOutputStream(yourFile, false);
        oFile.close();
    }

    public static void retrieveAlunoFromDat(ClassLoader classLoader) throws FileNotFoundException, IOException {
        // Exercicio 3.2
        DataInputStream dataIn = new DataInputStream(new FileInputStream(classLoader.getResource(DAT_FILE).getFile()));

        Aluno novoAluno = new Aluno();
        novoAluno.setNome(dataIn.readUTF());
        novoAluno.setMatricula(dataIn.readLong());
        novoAluno.setDisciplina(dataIn.readUTF());
        novoAluno.setNota1(dataIn.readDouble());
        novoAluno.setNota2(dataIn.readDouble());
        dataIn.close();

        printAluno(novoAluno);
    }

    public static void storeAlunoInDat(Aluno aluno, ClassLoader classLoader) throws FileNotFoundException, IOException {
        // Exercicio 3.1
        DataOutputStream dataOut = new DataOutputStream(
                new FileOutputStream(classLoader.getResource(DAT_FILE).getFile()));

        dataOut.writeUTF(aluno.getNome());
        dataOut.writeLong(aluno.getMatricula());
        dataOut.writeUTF(aluno.getDisciplina());
        dataOut.writeDouble(aluno.getNota1());
        dataOut.writeDouble(aluno.getNota2());
        dataOut.writeUTF(aluno.getAprovacao());
        dataOut.flush();
        dataOut.close();
    }

    public static void printAluno(Aluno aluno) {
        System.out.println("Nome: " + aluno.getNome());
        System.out.println("Matricula: " + aluno.getMatricula());
        System.out.println("Disciplina: " + aluno.getDisciplina());
        System.out.println("N1 = " + aluno.getNota1() + " | N2 = " + aluno.getNota2());
        System.out.println("Resultado: " + aluno.getAprovacao());
    }

}
