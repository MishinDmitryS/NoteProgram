package com.note;

//Класс заметки
public class Note {
    private String header;

    private String text;

    Note() {};

    public Note(String header, String text) {
        this.header = header;
        this.text = text;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void print() {
        System.out.println("Заголовок:");
        System.out.println(header);
        System.out.println("Текст:");
        System.out.println(text + "\n");
    }
}
