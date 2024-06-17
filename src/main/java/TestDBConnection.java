/** package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDBConnection {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://dpg-cpn17duehbks7380eta0-a.oregon-postgres.render.com:5432/berkay_db";
        String username = "berkay_db_user";
        String password = "mrS7KP3auNE70LJcC042UMtX33mJKrTY";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            if (connection != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to connect to the database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
**/