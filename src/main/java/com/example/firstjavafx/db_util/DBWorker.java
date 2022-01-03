package com.example.firstjavafx.db_util;

import com.example.firstjavafx.util.User;

import java.sql.*;

public class DBWorker extends DBConfigs {
    private final String URL = "jdbc:mysql://" + db_host + ":" + db_port + "/" + db_name;
    private Connection connection;

    public DBWorker() {
        try {
            connection = DriverManager.getConnection(URL, db_user, db_password);
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

    public void signupUser(User user) {
        String query = "INSERT INTO " + Constants.USER_TABLE + "(" + Constants.FIRST_NAME + ", "
                + Constants.SECOND_NAME  + ", " + Constants.USERNAME + ", " + Constants.LOCATION
                + ", " + Constants.GENDER + ", " + Constants.PASSWORD + ") VALUES(?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, user.getFirst_name());
            preparedStatement.setString(2, user.getSecond_name());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getLocation());
            preparedStatement.setString(5, user.getGender());
            preparedStatement.setString(6, user.getPassword());
            preparedStatement.executeUpdate() ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
