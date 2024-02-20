package dev.javadrinker.gleam.util;

import java.sql.*;
import static dev.javadrinker.gleam.Gleam.getConfig;

public class MySqlConnection {

    // ** NOT IN USE, PLEASE IGNORE! **

    protected static final String url = getConfig.get("DB_URL");
    protected static final String user = getConfig.get("DB_USER");
    protected static final String password = getConfig.get("DB_PASSWORD");

    public static Object query(String query) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, user, password);

            Statement statement=connection.createStatement();

            return statement.executeQuery(query);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void update(String query) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, user, password);

            Statement statement=connection.createStatement();

            statement.executeUpdate(query);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void execute(String query) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, user, password);

            Statement statement=connection.createStatement();

            statement.execute(query);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
