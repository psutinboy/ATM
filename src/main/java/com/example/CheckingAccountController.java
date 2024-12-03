package com.example;

import java.io.IOException;
import java.text.DecimalFormat;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CheckingAccountController {
    private Account account = new Account();
    private DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    @FXML
    private Label balanceLabel;
    @FXML
    private TextField amountField;

    @FXML
    public void initialize() {
        updateBalance();
    }

    private void updateBalance() {
        balanceLabel.setText("Balance: " + moneyFormat.format(account.getCheckingBalance()));
    }

    @FXML
    private void handleWithdraw() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            account.calcCheckingWithdraw(amount);
            updateBalance();
            amountField.clear();
        } catch (NumberFormatException e) {
            // Handle invalid input
        }
    }

    @FXML
    private void handleDeposit() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            account.calcCheckingDeposit(amount);
            updateBalance();
            amountField.clear();
        } catch (NumberFormatException e) {
            // Handle invalid input
        }
    }

    @FXML
    private void handleBack() throws IOException {
        Parent mainMenu = FXMLLoader.load(getClass().getResource("/fxml/MainMenu.fxml"));
        Scene scene = new Scene(mainMenu);
        Stage stage = (Stage) balanceLabel.getScene().getWindow();
        stage.setScene(scene);
    }
} 