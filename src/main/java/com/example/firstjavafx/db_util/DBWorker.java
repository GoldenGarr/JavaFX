package com.example.firstjavafx.db_util;

import java.sql.*;

public class DBWorker extends DBConfigs {
    private final String URL = "jdbc:mysql://" + host + ":" + port + "/" + db_name;
    private Connection connection;

    public DBWorker() {
        try {
            connection = DriverManager.getConnection(URL, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
