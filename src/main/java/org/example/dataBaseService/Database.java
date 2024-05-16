package org.example.dataBaseService;

import org.example.prefs.Prefs;

import java.sql.*;

public class Database {
    private static Database instance;
    private Connection connection;

    private Database() {
        String dbUrl = new Prefs().getString(Prefs.DB_URL);
        String dbUser = new Prefs().getString(Prefs.DB_USER);
        String dbPass = new Prefs().getString(Prefs.DB_PASSWORD);
        try {
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}
