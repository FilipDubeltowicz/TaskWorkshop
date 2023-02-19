package pl.coderslab;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class TaskManager {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input;
        do {
            printOption();
            input = scanner.nextLine();
            switch (input) {
                case "add":
                    readData();
//                addTask();
                    break;
                case "remove":
//                removeTask();
                    break;
                case "list":
                    listTask();
                    break;
                case "exit":
                    exit();
                    break;
                default:
                    System.out.println("Please select a correct option.");
            }
        } while (!input.equals("exit"));
    }

    public static void readData() {
        File file = new File("tasks.csv");
        String[][] taskListArr = new String[0][3];
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.err.println("There is no such a file" + e.getMessage());
        }
        do {
            taskListArr = Arrays.copyOf(taskListArr, taskListArr.length + 1);
            taskListArr[taskListArr.length - 1] = scanner.nextLine().split(",");
//            System.out.println(Arrays.toString(taskListArr[taskListArr.length - 1]));
        } while (scanner.hasNextLine());
    }

    public static void printOption() {
        System.out.println(ConsoleColors.BLUE + "Please select an option:" + ConsoleColors.RESET);
        String[] optionToSelect = {"add", "remove", "list", "exit"};
        for (String options : optionToSelect) {
            System.out.println(options);
        }
        System.out.println();
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
        int counter = 0;
        while (scanner.hasNextLine()) {
            System.out.println(counter + ": " + scanner.nextLine());
            counter++;
        }
        System.out.println();
    }

    public static void exit() {
        System.err.println("THAT'S ALL FOLKS");
    }
}



