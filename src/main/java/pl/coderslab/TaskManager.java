package pl.coderslab;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class TaskManager {
    static String[][] tasks;

    public static void main(String[] args) {

        tasks = readData();
        Scanner scanner = new Scanner(System.in);

        String input;
        do {
            printOption();
            input = scanner.nextLine();
            switch (input) {
                case "add":
                    addTask();
                    break;
                case "remove":
                    removeTask();
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

    public static String[][] readData() {
        File file = new File("tasks.csv");
        String[][] taskListArr = new String[0][];
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.err.println("There is no such a file" + e.getMessage());
        }
        do {
            taskListArr = Arrays.copyOf(taskListArr, taskListArr.length + 1);
            taskListArr[taskListArr.length - 1] = scanner.nextLine().split(","); // Czy tu nie trzeba obciac spacji jakoś? jak?
//            System.out.println(Arrays.toString(taskListArr[taskListArr.length - 1]));
        } while (scanner.hasNextLine());
        return taskListArr;
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

        System.out.println(Arrays.deepToString(tasks)); //Jak to zrobić żeby poprawnie drukowało listę tj. tak jak w treści zadania?
    }

    public static void addTask() {


        tasks = Arrays.copyOf(tasks, tasks.length + 1);
        tasks[tasks.length - 1] = new String[3];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please add task description");
        String input = scanner.nextLine();
        tasks[tasks.length - 1][0] = input;

        System.out.println("Please add task due date");
        input = scanner.nextLine();
        tasks[tasks.length - 1][1] = input;

        System.out.println("Is your task important: true/false");
        input = scanner.nextLine();
        tasks[tasks.length - 1][2] = input;

        System.out.println("YOUR TASK WAS SUCCESFULLY ADDED");
    }

    public static void removeTask() {
        Scanner scanner = new Scanner(System.in);

        // Jak to zrobić żeby nie wychodziło znów to ListTask? DO-WHILEM?
        String imput = scanner.nextLine();
//        do {
            System.out.println("PLEASE SELECT TASK NUMBER TO REMOVE:");
            if (NumberUtils.isParsable(imput)) {
                int indexToRemove = Integer.parseInt(imput);
                if (indexToRemove >= 0 && indexToRemove < tasks.length) {
                    tasks = ArrayUtils.remove(tasks, indexToRemove);
                    return;
                }
            }
            System.out.println("Proszę podaj poprawny numer");
//        } while (indexToRemove < 0 || indexToRemove >= tasks.length);
    }

    public static void exit() {
        // dane z tablicy mają zostać zapisane do pliku tasks.csv NIE WIEM JAK
        System.err.println("THAT'S ALL FOLKS");
    }
}



