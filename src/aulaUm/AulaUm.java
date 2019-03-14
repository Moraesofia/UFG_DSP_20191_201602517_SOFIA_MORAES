package aulaUm;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Criar um arquivo texto, escrever, ler e imprimir o conteúdo desse arquivo.
 * 
 * @author Sofia
 *
 */
public class AulaUm {

    private static String fileName = "Arquivo.txt";

    public static void main(final String[] args) {

        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write("Este é o conteúdo deste arquivo.");

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        FileReader fr;
        try {
            fr = new FileReader(fileName);
            int i;
            while ((i = fr.read()) != -1) {
                System.out.print((char) i);
            }
            fr.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

}
