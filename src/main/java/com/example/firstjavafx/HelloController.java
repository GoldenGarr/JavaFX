package com.example.firstjavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
        });
    }
}
