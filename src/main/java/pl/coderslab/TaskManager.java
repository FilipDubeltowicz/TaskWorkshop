package pl.coderslab;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TaskManager {
    public static void printOption() {
        System.out.println("Please select an option:");
        String[] optionToSelect = {"add", "remove", "list", "exit"};
        for (String options : optionToSelect) {
            System.out.println(options);
        }
    }

    public static void listTask() {
        System.out.println("list");
        File file = new File("tasks.csv");

        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage() + "Nie ma pliku");
        }
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input;
        do {
            printOption();
            input = scanner.nextLine();
            switch (input) {
                case "add":
//                addTask();
                    break;
                case "remove":
//                removeTask();
                    break;
                case "list":
                    listTask();
                    break;
                case "exit":
                    break;
                default:
                    System.out.println("Please select a correct option.");
            }
        } while (!input.equals("exit"));
    }
}



