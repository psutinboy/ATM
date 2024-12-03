package com.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMenuController {
    @FXML
    private void handleChecking(ActionEvent event) throws IOException {
        Parent checkingAccount = FXMLLoader.load(getClass().getResource("/fxml/CheckingAccount.fxml"));
        Scene scene = new Scene(checkingAccount);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void handleSavings(ActionEvent event) throws IOException {
        Parent savingsAccount = FXMLLoader.load(getClass().getResource("/fxml/SavingsAccount.fxml"));
        Scene scene = new Scene(savingsAccount);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void handleLogout(ActionEvent event) throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
        Scene scene = new Scene(login);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
}