package com.example.firstjavafx.controllers;

import com.example.firstjavafx.HelloApplication;
import com.example.firstjavafx.animations.AnimationShake;
import com.example.firstjavafx.db_util.DBWorker;
import com.example.firstjavafx.util.CustomController;
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

public class SignInController extends CustomController {
    @FXML
    private TextField login_field;

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

            String loginText = login_field.getText().trim();
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
            openScene("signup.fxml", sign_button);
        });
    }

    private void loginUser(String loginText, String passwordText) {
        DBWorker worker = new DBWorker();

        User user = new User();
        user.setUsername(loginText);
        user.setPassword(passwordText);

        ResultSet resultSet = worker.getUser(user);
        // int counter = 0;
        boolean sign_in_successful = false;
        try {
            if (resultSet.next()) {
                user.setUser_id(resultSet.getInt("user_id"));
                sign_in_successful = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (sign_in_successful) {
            sendUserData("home.fxml", sign_button, user);
        } else {
            System.out.println("Wrong login and/or password");
            // AnimationShake sign_button_shake = new AnimationShake(sign_button);
            AnimationShake login_field_shake = new AnimationShake(login_field);
            AnimationShake password_field_shake = new AnimationShake(password_field);

            login_field_shake.execute();
            password_field_shake.execute();

            // sign_button_shake.execute();
        }
    }
}
