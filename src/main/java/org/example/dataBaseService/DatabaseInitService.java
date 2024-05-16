package org.example.dataBaseService;

import org.example.ReadFileService.ReadFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseInitService {

    public static void main(String[] args) {
        ReadFile readFile = new ReadFile();
        readFile.readFileInit();
    }

    public static void createTable(String input) {
        PreparedStatement createST;

        Database databaseConnection = Database.getInstance();
        Connection connection = databaseConnection.getConnection();
        try {
            createST = connection.prepareStatement(input);

            createST.execute();
            createST.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}