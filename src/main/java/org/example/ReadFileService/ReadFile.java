package org.example.ReadFileService;

import org.example.dataBaseService.DatabaseInitService;
import org.example.dataBaseService.DatabasePopulateService;
import org.example.prefs.Prefs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    public static void readFileInit() {
        String input = "";
        String initDbFilename = new Prefs().getString(Prefs.INIT_DB_SQL_FILE_PATH);
        DatabaseInitService databaseInitService = new DatabaseInitService();

        File file = new File(initDbFilename);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                line += ";";

                databaseInitService.createTable(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println(initDbFilename + " file - not found");
        }
        System.out.println("Tables - created successfully..");
    }

    public static void readFilePopulate() {
        String input = "";
        String populateDbFilename = new Prefs().getString(Prefs.POPULATE_DB_SQL_FILE_PATH);
        DatabasePopulateService databasePopulateService = new DatabasePopulateService();

        File file = new File(populateDbFilename);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                line += ";";
                databasePopulateService.insertTable(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println(populateDbFilename + " file - not found");
        }
        System.out.println("Insertion into table was successful.");
    }

    public static String readFileSelect(String fileName) {
        String input = "";

        File file = new File("src/main/resources/" + fileName);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                input += line + " ";
            }
        } catch (FileNotFoundException e) {
            System.out.println(fileName + " - not found");
        }
        return input;
    }
}

