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

public class ExercicioNoveJson {

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

		for (Entry<String, JsonElement> entry : students.entrySet()) {
			array = entry.getValue().getAsJsonArray();
		}

		for (JsonElement item : array) {
			JsonObject o = item.getAsJsonObject();

			String m = o.get("matricula").toString();
			if (m.equals("\"201602517\"")) {
				Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls()
						.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
				conteudo = gson.toJson(o);
				break;
			}

		}

		// Salva arquivo
		File novoJson = new File(RESOURCES_PATH + MATRICULA + ".json");
		FileWriter fw = new FileWriter(novoJson);
		fw.write(conteudo);
		fw.flush();
		fw.close();

	}
}
