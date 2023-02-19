package pl.coderslab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TaskManagerList {
    public static void main(String[] args) {



        File file = new File("tasks.csv");
        String [][] tasks;
        try (Scanner scan = new Scanner(file)) {

            while (scan.hasNextLine()) {
                System.out.println(scan.nextLine());

            }
        } catch (FileNotFoundException e) {
            System.err.println("Nie znaleziono pliku");
        }

    }
}
