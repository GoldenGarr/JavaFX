package com.example.firstjavafx.controllers;

import com.example.firstjavafx.db_util.DBWorker;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class SignUpController {
    @FXML
    private CheckBox female_check;

    @FXML
    private TextField login_filed;

    @FXML
    private CheckBox male_check;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button signup_button;

    @FXML
    private TextField signup_country;

    @FXML
    private TextField signup_name;

    @FXML
    private TextField signup_surname;

    @FXML
    private Label title_label;

    @FXML
    void initialize() {
        DBWorker worker = new DBWorker();
        signup_button.setOnAction(event -> {
            worker.signupUser(signup_name.getText(), signup_surname.getText(),
                    login_filed.getText(), password_field.getText(), signup_country.getText(), "male");
        });
    }
}
