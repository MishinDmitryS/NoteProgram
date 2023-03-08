package com.note;

import com.note.fileSerialization.Deserialization;

import java.util.ArrayList;

public class AppNotes {
    public AppNotes() {
        Deserialization deserialization = new Deserialization();
        ArrayList<Note> notes;
        notes = deserialization.readJSON();
        Menu menu = new Menu(notes);
        menu.startMenu();
    }
}
