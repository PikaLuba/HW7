package org.example.dataBaseService;

import org.example.ReadFileService.ReadFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabasePopulateService {
    public static void main(String[] args) {
        ReadFile readFile = new ReadFile();
        readFile.readFilePopulate();
    }

    public static void insertTable(String input) {
        PreparedStatement insertST;

        Database databaseConnection = Database.getInstance();
        Connection connection = databaseConnection.getConnection();

        try {

            insertST = connection.prepareStatement(input);

            insertST.executeUpdate();
            insertST.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

