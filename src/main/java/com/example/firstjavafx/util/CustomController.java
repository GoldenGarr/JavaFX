package com.example.firstjavafx.util;

import com.example.firstjavafx.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomController {

    protected void openScene(String window_address, Node node) {
        node.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource(window_address));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    protected void sendUserData(String window_address, Node node, User user) {
        node.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource(window_address));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();

        stage.setUserData(user);

        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
}
