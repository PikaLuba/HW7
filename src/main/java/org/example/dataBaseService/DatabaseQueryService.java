package org.example.dataBaseService;

import org.example.ReadFileService.ReadFile;
import org.example.selectStructure.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    PreparedStatement selectST;

    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        List<MaxSalaryWorker> result = new ArrayList<>();
        ReadFile readFile = new ReadFile();

        String input = "";
        input = readFile.readFileSelect("find_max_salary_worker.sql");

        Database databaseConnection = Database.getInstance();
        Connection connection = databaseConnection.getConnection();

        try {
            selectST = connection.prepareStatement(input);
            ResultSet rs = selectST.executeQuery();

            while (rs.next()) {
                result.add(new MaxSalaryWorker(
                        rs.getString("name"),
                        rs.getInt("salary")));
            }

            rs.close();
            selectST.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<MaxProgectCountClient> findMaxProgectClient() {
        List<MaxProgectCountClient> result = new ArrayList<>();
        ReadFile readFile = new ReadFile();

        String input = "";
        input = readFile.readFileSelect("find_max_progects_client.sql");

        Database databaseConnection = Database.getInstance();
        Connection connection = databaseConnection.getConnection();

        try {
            selectST = connection.prepareStatement(input);
            ResultSet rs = selectST.executeQuery();

            while (rs.next()) {
                result.add(new MaxProgectCountClient(
                        rs.getString("name"),
                        rs.getInt("progectCount")));
            }

            rs.close();
            selectST.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<LongestProgect> findLongestProgect() {
        List<LongestProgect> result = new ArrayList<>();
        ReadFile readFile = new ReadFile();

        String input = "";
        input = readFile.readFileSelect("find_longest_progect.sql");

        Database databaseConnection = Database.getInstance();
        Connection connection = databaseConnection.getConnection();

        try {
            selectST = connection.prepareStatement(input);
            ResultSet rs = selectST.executeQuery();

            while (rs.next()) {
                result.add(new LongestProgect(
                        rs.getString("name"),
                        rs.getInt("month_count")));
            }

            rs.close();
            selectST.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<YoungestEldestWorkers> findYoungestEldestWorkers() {
        List<YoungestEldestWorkers> result = new ArrayList<>();
        ReadFile readFile = new ReadFile();

        String input = "";
        input = readFile.readFileSelect("find_youngest_eldest_workers.sql");

        Database databaseConnection = Database.getInstance();
        Connection connection = databaseConnection.getConnection();

        try {
            selectST = connection.prepareStatement(input);
            ResultSet rs = selectST.executeQuery();

            while (rs.next()) {
                result.add(new YoungestEldestWorkers(
                        rs.getString("type"),
                        rs.getString("name"),
                        rs.getString("birhday")));
            }

            rs.close();
            selectST.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<ProgectPrices> printProgectPrices() {
        List<ProgectPrices> result = new ArrayList<>();
        ReadFile readFile = new ReadFile();

        String input = "";
        input = readFile.readFileSelect("print_project_prices.sql");

        Database databaseConnection = Database.getInstance();
        Connection connection = databaseConnection.getConnection();

        try {
            selectST = connection.prepareStatement(input);
            ResultSet rs = selectST.executeQuery();

            while (rs.next()) {
                result.add(new ProgectPrices(
                        rs.getString("name"),
                        rs.getInt("price")));
            }

            rs.close();
            selectST.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
