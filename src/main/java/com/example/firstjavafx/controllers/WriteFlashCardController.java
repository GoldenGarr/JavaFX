package com.example.firstjavafx.controllers;

import com.example.firstjavafx.HelloApplication;
import com.example.firstjavafx.util.CustomController;
import com.example.firstjavafx.util.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class WriteFlashCardController extends CustomController {
    @FXML
    private Button add_button;

    @FXML
    private TextField definition_text;

    @FXML
    private CheckBox star_check;

    @FXML
    private TextField term_text;

    @FXML
    private Label title_label;
}
