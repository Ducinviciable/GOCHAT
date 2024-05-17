package com.example.gochat;

import java.sql.Connection;
import java.sql.DriverManager;

public class dataConect {
    private static dataConect dbConnection;

    private dataConect() {}

    public static dataConect getInstance() {
        if (dbConnection == null) {
            dbConnection = new dataConect();
        }
        return dbConnection;
    }

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/chat_app", "sa", "12345");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
