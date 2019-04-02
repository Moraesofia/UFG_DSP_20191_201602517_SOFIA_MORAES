package br.com.Moraesofia.dsp20191.aulas0912.as;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

/**
 *
 * @author sofia
 *
 */
public class ExercicioOitoJson {

    private static String JSON_FILE = "students.json";

    public static void main(String[] args) throws IOException {

        Gson gson = new GsonBuilder().create();
        String json = readJson();

        JsonElement turma = gson.fromJson(json, JsonElement.class);
        JsonArray array = (JsonArray) gson.fromJson(json, JsonElement.class);

        System.out.println(array.toString());

        // try {
        // System.out.println(alunos.getAsJsonObject().get("class").getAsString());
        // } catch (Exception e) {
        // // TODO: handle exception
        // }
        // try {
        // System.out.println(alunos.getAsJsonObject().get("student").getAsString());
        // } catch (Exception e) {
        // // TODO: handle exception
        // }
        // try {
        // System.out.println(alunos.getAsJsonObject().get("matricula").getAsString());
        // } catch (Exception e) {
        // // TODO: handle exception
        // }

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
