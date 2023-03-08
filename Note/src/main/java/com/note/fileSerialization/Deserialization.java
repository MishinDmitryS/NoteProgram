package com.note.fileSerialization;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.note.Note;

import java.io.File;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

//Десериализовать массив из json файла
public class Deserialization {
    public ArrayList<Note> readJSON() {
        String separator = File.separator;
        String path = "folderNotes" + separator + "notes.json";
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(path));
            Type type = new TypeToken<ArrayList<Note>>(){}.getType();
            ArrayList<Note> readNotes = gson.fromJson(reader, type);
            reader.close();
            return readNotes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
