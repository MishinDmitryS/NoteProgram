package com.note.fileSerialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.note.Note;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

// Сериализовать массив в json файл
public class Serialization {
    public Serialization() {}
    public Serialization(ArrayList<Note> notes) {
        writeJSON(notes);
    }

    public void writeJSON(ArrayList<Note> notes) {
        String separator = File.separator;
        String path = "folderNotes" + separator + "notes.json";
        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonNotes = gson.toJson(notes);
            out.write(jsonNotes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
