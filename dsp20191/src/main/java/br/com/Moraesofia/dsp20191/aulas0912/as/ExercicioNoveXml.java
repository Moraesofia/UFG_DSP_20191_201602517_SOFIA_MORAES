package br.com.Moraesofia.dsp20191.aulas0912.as;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 *
 * @author sofia
 *
 */
public class ExercicioNoveXml {

    private static String XML_FILE = "students.xml";

    private static String RESOURCES_PATH = "src/main/resources/";

    private static String MATRICULA = "201602517";

    private static String firstname = "";

    private static String lastname = "";

    private static String nickname = "";

    private static Map<String, String> frequencia;

    public static void main(String[] args) throws DocumentException, IOException {

        getInfoFromXml();

        createNewXml();
    }

    @SuppressWarnings("unchecked")
    public static void getInfoFromXml() throws DocumentException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        File XmlFile = new File(classLoader.getResource(XML_FILE).getFile());
        SAXReader reader = new SAXReader();
        Document document = reader.read(XmlFile);

        List<Node> students = document.selectNodes("/class/student");

        for (Node s : students) {
            String matricula = s.selectSingleNode("matricula").getText();
            if (matricula.equals(MATRICULA)) {
                firstname = s.selectSingleNode("firstname").getText();
                lastname = s.selectSingleNode("lastname").getText();
                nickname = s.selectSingleNode("nickname").getText();

                List<Node> frq = s.selectNodes("frequencia/aulas");
                frequencia = new HashMap<>();
                for (Node f : frq) {
                    frequencia.put(f.valueOf("@numero"), f.getText());

                }
                break;
            }
        }
    }

    public static void createNewXml() throws FileNotFoundException, UnsupportedEncodingException, IOException {
        Document newDocument = DocumentHelper.createDocument();
        Element root = newDocument.addElement("class");

        Element studentElement = root.addElement("student");
        studentElement.addElement("matricula").addText(MATRICULA);
        studentElement.addElement("firstname").addText(firstname);
        studentElement.addElement("lastname").addText(lastname);
        studentElement.addElement("nickname").addText(nickname);

        Element freqElement = studentElement.addElement("frequencia");
        freqElement.addElement("aulas").addAttribute("numero", "0104").addText(frequencia.get("0104"));
        freqElement.addElement("aulas").addAttribute("numero", "0508").addText(frequencia.get("0508"));

        OutputFormat format = OutputFormat.createPrettyPrint();
        FileOutputStream file = new FileOutputStream(RESOURCES_PATH + MATRICULA + ".xml");
        XMLWriter writer;
        writer = new XMLWriter(file, format);
        writer.write(newDocument);
        writer.flush();
        System.out.println("novo documento " + MATRICULA + ".xml salvo em: " + RESOURCES_PATH);
    }
}
