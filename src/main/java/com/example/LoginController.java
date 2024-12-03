package com.example;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    private TextField accountNumber;
    @FXML
    private PasswordField pin;

    @FXML
    private void handleLogin() throws IOException {
        // For testing, using the hardcoded values from your original code
        if (accountNumber.getText().equals("2222") && pin.getText().equals("123456")) {
            // Load main menu
            Parent mainMenu = FXMLLoader.load(getClass().getResource("/fxml/MainMenu.fxml"));
            Scene scene = new Scene(mainMenu);
            Stage stage = (Stage) accountNumber.getScene().getWindow();
            stage.setScene(scene);
        } else {
            // Show error message
            // You might want to add a label to show this message in the UI
            System.out.println("Invalid account number or PIN");
        }
    }
}