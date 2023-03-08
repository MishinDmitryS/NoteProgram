package com.note;

import com.note.fileSerialization.Serialization;
import com.note.menuElements.PrintNotes;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static ArrayList<Note> notes;
    Menu(ArrayList<Note> notes) {
        Menu.notes = notes;
    }

    //Запуск меню программы
    public void startMenu() {
        boolean exit = true;
        while(exit) {
            printCommands();
            Scanner scanner = new Scanner(System.in);
            String numb = scanner.nextLine();
            int number;
            if(isNumeric(numb)) {
                number = Integer.parseInt(numb);
            } else {
                System.out.println("Неверное значение");
                continue;
            }
            System.out.println();
            switch (number) {
                case 1:
                    new PrintNotes();
                    break;
                case 2:
                    createNode();
                    break;
                case 3:
                    deleteAllNotes();
                    break;
                case 4:
                    deleteNote();
                    break;
                case 5:
                    exit = false;
                    break;
            }
        }
    }

    //Вывести в консоль все доступные действия
    private void printCommands() {
        System.out.println("____________________________________________________________________");
        System.out.println("1. Вывести все заметки");
        System.out.println("2. Создать заметку");
        System.out.println("3. Удалить все заметки");
        System.out.println("4. Удалить заметку");
        System.out.println("5. Выход");
        System.out.print("Напишите выбранный пункт (число): ");
    }

    //Создать новую заметку
    private void createNode() {
        System.out.println("Введите заголовок заметки");
        Scanner scanner = new Scanner(System.in);
        String header = scanner.nextLine();
        System.out.println("Введите текст заметки");
        String text = scanner.nextLine();
        Note node = new Note(header, text);
        Menu.notes.add(node);
        System.out.println();
        new Serialization(Menu.notes);
    }

    //Удалить все заметки
    private void deleteAllNotes() {
        Menu.notes = new ArrayList<>();
        Note note = new Note("Заголовок 1",
                "Многие думают, что Lorem Ipsum - взятый с потолка псевдо-латинский набор слов, но это не совсем так.");
        Menu.notes.add(note);
        new Serialization(Menu.notes);
    }

    //Удалить одну конкретную заметку
    private void deleteNote() {
        System.out.println("Введите номер удаляемой заметки.");
        try {
            Scanner scanner = new Scanner(System.in);
            String indexString = scanner.nextLine();
            int index = Integer.parseInt(indexString);
            Menu.notes.remove(index-1);
            if (Menu.notes.isEmpty()) {
                Note note = new Note("Заголовок 1",
                        "Многие думают, что Lorem Ipsum - взятый с потолка псевдо-латинский набор слов, но это не совсем так.");
                Menu.notes.add(note);
            }
            new Serialization(Menu.notes);
        } catch (Exception e) {
            System.out.println("Неверное значение!");
        }
    }

    //Проверка является ли строка числом
    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
