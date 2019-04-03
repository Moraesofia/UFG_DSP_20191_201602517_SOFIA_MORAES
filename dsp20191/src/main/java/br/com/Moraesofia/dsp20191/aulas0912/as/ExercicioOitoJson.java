package br.com.Moraesofia.dsp20191.aulas0912.as;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map.Entry;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 *
 * @author sofia
 *
 */
public class ExercicioOitoJson {

    private static String JSON_FILE = "students.json";

    public static void main(String[] args) throws IOException {

        JsonParser parser = new JsonParser();
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        InputStream is = classLoader.getResourceAsStream(JSON_FILE);
        Reader reader = new InputStreamReader(is);
        JsonElement rootElement = parser.parse(reader);
        JsonObject rootObject = rootElement.getAsJsonObject();
        JsonObject students = rootObject.getAsJsonObject("class");
        JsonArray array = null;
        JsonArray aulas = null;

        for (Entry<String, JsonElement> entry : students.entrySet()) {
            array = entry.getValue().getAsJsonArray();
        }

        for (JsonElement item : array) {
            JsonObject o = item.getAsJsonObject();
            System.out.println("....................................");
            System.out.println("Matricula: " + o.get("matricula"));
            System.out.println("Nome: " + o.get("firstname"));
            System.out.println("Sobrenome: " + o.get("lastname"));
            System.out.println("Apelido: " + o.get("nickname"));
            System.out.println("Frequencia: ");
            JsonObject freq = rootObject.getAsJsonObject("frequencia");
            if (freq != null) {
                System.out.println("FREQUENCIA");
            }

            // for (Entry<String, JsonElement> f : freq.entrySet()) {
            // aulas = f.getValue().getAsJsonArray();
            //
            // for (JsonElement aula : aulas) {
            // JsonObject a = aula.getAsJsonObject();
            // System.out.println(" aulas" + a.get("numero") + ": " + a.get("#text"));
            // }
            // }

        }

        // Gson gson = new GsonBuilder().create();
        // String json = readJson();

    }

    public final static String readJson() throws IOException {
        try {
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            File jsonFile = new File(classLoader.getResource(JSON_FILE).getFile());
            FileReader arq = new FileReader(jsonFile);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();
            while (linha != null) {
                linha = lerArq.readLine();
            }
            arq.close();
            return linha;
        } catch (IOException e) {
            throw new IOException("NAO FOI POSSIVEL LER O ARQUIVO");
        }
    }

}
