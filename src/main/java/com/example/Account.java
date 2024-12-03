package com.example;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    private int accountNumber;
    private int pin;
    private double checkingBalance = 0;
    private double savingsBalance = 0;

    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    // Getters and setters for account number and PIN
    public int setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
        return accountNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int setPin(int pin) {
        this.pin = pin;
        return pin;
    }

    public int getPin() {
        return pin;
    }

    // Checking account methods
    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double calcCheckingWithdraw(double amount) {
        if (amount <= checkingBalance) {
            checkingBalance = checkingBalance - amount;
        } else {
            System.out.println("Insufficient funds");
        }
        return checkingBalance;
    }

    public double calcCheckingDeposit(double amount) {
        checkingBalance = checkingBalance + amount;
        return checkingBalance;
    }

    // Savings account methods
    public double getSavingsBalance() {
        return savingsBalance;
    }

    public double calcSavingsWithdraw(double amount) {
        if (amount <= savingsBalance) {
            savingsBalance = savingsBalance - amount;
        } else {
            System.out.println("Insufficient funds");
        }
        return savingsBalance;
    }

    public double calcSavingsDeposit(double amount) {
        savingsBalance = savingsBalance + amount;
        return savingsBalance;
    }

    public void getCheckingWithdrawInput() {
        System.out.println("Checking account balance: " + moneyFormat.format(checkingBalance));
        System.out.println("Amount you want to withdraw from checking account: ");
        double amount = input.nextDouble();

        if (amount <= checkingBalance) {
            calcCheckingWithdraw(amount);
            System.out.println("New checking account balance: " + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public void getCheckingDepositInput() {
        System.out.println("Checking account balance: " + moneyFormat.format(checkingBalance));
        System.out.println("Amount you want to deposit into checking account: ");
        double amount = input.nextDouble();

        if (amount > 0) {
            calcCheckingDeposit(amount);
            System.out.println("New checking account balance: " + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Amount must be greater than zero");
        }
    }

    public void getSavingsWithdrawInput() {
        System.out.println("Savings account balance: " + moneyFormat.format(savingsBalance));
        System.out.println("Amount you want to withdraw from savings account: ");
        double amount = input.nextDouble();

        if (amount <= savingsBalance) {
            calcSavingsWithdraw(amount);
            System.out.println("New savings account balance: " + moneyFormat.format(savingsBalance));
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public void getSavingsDepositInput() {
        System.out.println("Savings account balance: " + moneyFormat.format(savingsBalance));
        System.out.println("Amount you want to deposit into savings account: ");
        double amount = input.nextDouble();

        if (amount > 0) {
            calcSavingsDeposit(amount);
            System.out.println("New savings account balance: " + moneyFormat.format(savingsBalance));
        } else {
            System.out.println("Amount must be greater than zero");
        }
    }
}
