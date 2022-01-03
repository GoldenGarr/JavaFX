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

    public void signupUser(String first_name, String second_name, String username
    , String password, String location, String gender) {
        String query = "INSERT INTO " + Constants.USER_TABLE + "(" + Constants.FIRST_NAME + ", "
                + Constants.SECOND_NAME  + ", " + Constants.USERNAME + ", " + Constants.LOCATION
                + ", " + Constants.GENDER + ", " + Constants.PASSWORD + ") VALUES(?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, first_name);
            preparedStatement.setString(2, second_name);
            preparedStatement.setString(3, username);
            preparedStatement.setString(4, location);
            preparedStatement.setString(5, gender);
            preparedStatement.setString(6, password);
            preparedStatement.executeUpdate() ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
