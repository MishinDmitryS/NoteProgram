package com.note.menuElements;

import com.note.Menu;
import com.note.Note;
import com.note.fileSerialization.Serialization;

import java.util.Scanner;

public class PrintNotes {
    public PrintNotes() {
        chooseNote();
    }

    //Вывести в консоль все заметки
    private void printAllNotes() {
        System.out.println("\n" + "____________________________________________________________________");
        System.out.println("Все заметки:" + "\n");
        int i = 0;
        for (Note n : Menu.notes) {
            System.out.print(++i + ". ");
            n.print();
        }
    }

    //Выбрать заметку
    private void chooseNote() {
        boolean exit = true;
        while(exit) {
            printAllNotes();
            System.out.print("Выбирете заметку или вернитесь назад (команда back): ");
            Scanner scanner = new Scanner(System.in);
            String value = scanner.nextLine();
            System.out.println();
            int number;
            if(isNumeric(value)) {
                number = Integer.parseInt(value);
                if(number > 0 && number <= Menu.notes.size()) {
                    menuChooseCommand(number);
                }
            } else {
                if (value.equals("back")) {
                    exit = false;
                }
            }
        }
    }

    //Выбрать действие над заметкой
    private void menuChooseCommand(int number) {
        boolean exit = true;
        while(exit) {
            printCommandMenuChangeNote(number);
            Scanner scanner = new Scanner(System.in);
            String numb = scanner.nextLine();
            int valueCommand;
            if(isNumeric(numb)) {
                valueCommand = Integer.parseInt(numb);
            } else {
                System.out.println("Неверное значение!");
                continue;
            }
            System.out.println();
            switch (valueCommand) {
                case 1:
                    changeHeader(number);
                    break;
                case 2:
                    changeText(number);
                    break;
                case 3:
                    exit = false;
                    break;
            }
        }
    }

    //Изменить заголовок заметки
    private void changeHeader(int number) {
        System.out.println("Введите заголовок:");
        Scanner scanner = new Scanner(System.in);
        String numb = scanner.nextLine();
        Menu.notes.get(number-1).setHeader(numb);
        new Serialization(Menu.notes);
        System.out.println("Заголовок введен." + "\n");
    }

    //Изменить текст заметки
    private void changeText(int number) {
        System.out.println("Введите текст:");
        Scanner scanner = new Scanner(System.in);
        String numb = scanner.nextLine();
        Menu.notes.get(number-1).setText(numb);
        new Serialization(Menu.notes);
        System.out.println("Текст введен." + "\n");
    }

    //Вывести в консоль все команды для заметки
    private void printCommandMenuChangeNote(int number) {
        System.out.println();
        System.out.print(number + ". ");
        Menu.notes.get(number-1).print();

        System.out.println("1. Изменить заголовок;");
        System.out.println("2. Изменить текст;");
        System.out.println("3. Назад.");
        System.out.print("Выберете пункт:");
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
