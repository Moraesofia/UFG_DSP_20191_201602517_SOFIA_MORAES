package br.com.Moraesofia.dsp20191.aulas0912.as;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/**
 *
 * @author sofia
 *
 */
public class ExercicioOitoXml {

    private static String XML_FILE = "students.xml";

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws DocumentException {

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        File XmlFile = new File(classLoader.getResource(XML_FILE).getFile());
        SAXReader reader = new SAXReader();
        Document document = reader.read(XmlFile);

        List<Node> students = document.selectNodes("/class/student");
        System.out.println(document.getRootElement().getName() + " " + students.get(0).getName() + "s");

        for (Node s : students) {
            System.out.println("....................................");
            System.out.println("Matricula: " + s.selectSingleNode("matricula").getText());
            System.out.println("Nome: " + s.selectSingleNode("firstname").getText());
            System.out.println("Sobrenome: " + s.selectSingleNode("lastname").getText());
            System.out.println("Apelido: " + s.selectSingleNode("nickname").getText());
            System.out.println("Frequencia: ");

            List<Node> frequencia = s.selectNodes("frequencia/aulas");
            for (Node f : frequencia) {
                System.out.println("   aulas" + f.valueOf("@numero") + ": " + f.getText());
            }
        }

    }

}
