package com.example.firstjavafx.db_util;

import com.example.firstjavafx.db_util.table_constants.UsersConstants;
import com.example.firstjavafx.util.FlashCard;
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
        String query = "INSERT INTO " + UsersConstants.USER_TABLE + "(" + UsersConstants.FIRST_NAME + ", "
                + UsersConstants.SECOND_NAME + ", " + UsersConstants.USERNAME + ", " + UsersConstants.LOCATION
                + ", " + UsersConstants.GENDER + ", " + UsersConstants.PASSWORD + ") VALUES(?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, user.getFirst_name());
            preparedStatement.setString(2, user.getSecond_name());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getLocation());
            preparedStatement.setString(5, user.getGender());
            preparedStatement.setString(6, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertFlashCard(User user, FlashCard flashCard) {
        // String query =
    }

    public ResultSet getUser(User user) {
        ResultSet resultSet = null;
        String query = "SELECT * FROM " + UsersConstants.USER_TABLE + " WHERE " + UsersConstants.USERNAME + " = ? AND " + UsersConstants.PASSWORD + " = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
