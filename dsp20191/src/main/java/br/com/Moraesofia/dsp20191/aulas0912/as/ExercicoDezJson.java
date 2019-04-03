package br.com.Moraesofia.dsp20191.aulas0912.as;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map.Entry;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ExercicoDezJson {

	private static String JSON_FILE = "students.json";

	private static String RESOURCES_PATH = "src/main/resources/";

	private static String MATRICULA = "201602517";

	private static String conteudo;

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

			String m = o.get("matricula").toString();
			if (m.equals("\"201602517\"")) {
				JsonObject freq = o.getAsJsonObject("frequencia");
				for (Entry<String, JsonElement> f : freq.entrySet()) {
					aulas = f.getValue().getAsJsonArray();

					for (JsonElement aula : aulas) {
						JsonObject a = aula.getAsJsonObject();
						String p = a.get("numero").toString();
						String q = a.get("#text").toString();
						if (p.equals("\"0104\"")) {
							if (q.equals("\"P\"")) {
								a.remove("#text");
								a.addProperty("#text", "F");
							} else {
								a.remove("#text");
								a.addProperty("#text", "P");
							}
						}

					}
				}
				break;
			}

		}

		// Salva arquivo
		FileWriter fw = new FileWriter(RESOURCES_PATH + JSON_FILE);
		new GsonBuilder().setPrettyPrinting().create().toJson(rootElement, fw);
		fw.flush();
		fw.close();

	}

}
