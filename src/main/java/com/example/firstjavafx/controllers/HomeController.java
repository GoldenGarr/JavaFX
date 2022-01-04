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
    private User receiveData(MouseEvent event) {
        // Step 1
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        // Step 2
        // Step 3
        return (User) stage.getUserData();
    }

    @FXML
    void initialize() {
        image_frog.setOnMouseClicked(mouseEvent -> {
            User received_user = receiveData(mouseEvent);
            System.out.println("ID: " + received_user.getUser_id() + ", USERNAME: " + received_user.getUsername()
                    + ", PASSWORD: " + received_user.getPassword());
        });
    }
}
