package com.example.firstjavafx.controllers;

import com.example.firstjavafx.HelloApplication;
import com.example.firstjavafx.animations.AnimationShake;
import com.example.firstjavafx.db_util.DBWorker;
import com.example.firstjavafx.util.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HelloController {
    @FXML
    private TextField login_filed;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button register_button;

    @FXML
    private Button sign_button;

    @FXML
    private Label title_label;

    @FXML
    void initialize() {
        sign_button.setOnAction(event -> {
            System.out.println("Sign in button pressed");

            String loginText = login_filed.getText().trim();
            String passwordText = password_field.getText().trim();
            if (!loginText.equals("") && !passwordText.equals("")) {
                loginUser(loginText, passwordText);
            } else {
                System.out.println("Empty login and/or password");
            }

            /* Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 700, 400);
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setScene(scene);
            stage.show(); */
        });

        register_button.setOnAction(event -> {
            System.out.println("Register button pressed");
            register_button.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HelloApplication.class.getResource("signup.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }

    private void loginUser(String loginText, String passwordText) {
        DBWorker worker = new DBWorker();

        User user = new User();
        user.setUsername(loginText);
        user.setPassword(passwordText);

        ResultSet resultSet = worker.getUser(user);
        int counter = 0;
        while(true) {
            try {
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            counter++;
        }
        if (counter == 1) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HelloApplication.class.getResource("home.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } else {
            System.out.println("Wrong login and/or password");
            AnimationShake sign_button_shake = new AnimationShake(sign_button);
            sign_button_shake.execute();
        }
    }
}
