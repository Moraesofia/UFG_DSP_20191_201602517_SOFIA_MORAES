package br.com.Moraesofia.dsp20191.aulas0912.as;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 *
 * @author sofia
 *
 */
public class ExercicioDezXml {

    private static String XML_FILE = "students.xml";

    private static String RESOURCES_PATH = "src/main/resources/";

    private static String MATRICULA = "201602517";

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws DocumentException, IOException {

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        File XmlFile = new File(classLoader.getResource(XML_FILE).getFile());

        SAXReader reader = new SAXReader();
        Document document = reader.read(XmlFile);

        List<Node> students = document.selectNodes("/class/student");

        for (Node s : students) {
            String matricula = s.selectSingleNode("matricula").getText();

            if (matricula.equals(MATRICULA)) {
                List<Node> frequencia = s.selectNodes("frequencia/aulas[@numero='0104']");
                for (Node f : frequencia) {
                    if (f.getText().equals("P")) {
                        f.setText("F");
                    } else {
                        f.setText("P");
                    }
                }

            }
        }

        OutputFormat format = OutputFormat.createPrettyPrint();
        FileWriter fw = new FileWriter(RESOURCES_PATH + XML_FILE);
        XMLWriter writer;
        writer = new XMLWriter(fw, format);
        writer.write(document);
        writer.flush();
        writer.close();
        System.out.println("Documento " + RESOURCES_PATH + XML_FILE + " alterado.");

    }
}
