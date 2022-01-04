package com.example.firstjavafx.controllers;

import com.example.firstjavafx.util.User;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class HomeController {
    @FXML
    private ImageView image_frog;

    @FXML
    private Label title_label;

    @FXML
    private void receiveData(MouseEvent event) {
        // Step 1
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        // Step 2
        User u = (User) stage.getUserData();
        // Step 3
        System.out.println(u.getUsername());
    }

    @FXML
    void initialize() {
        image_frog.setOnMouseClicked(this::receiveData);
    }
}
