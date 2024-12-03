package com.example;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    public void getLogin() throws IOException {
        int x = 1;
        do {
            try {
                data.put(2222, 123456);

                System.out.println("Welcome to the ATM Project");
                System.out.println("Enter your account number: ");
                setAccountNumber(menuInput.nextInt());

                System.out.println("Enter your pin: ");
                setPin(menuInput.nextInt());
            } catch (Exception e) {
                System.out.println("\nInvalid account number or pin\n");
                x = 2;
            }
            int cn = getAccountNumber();
            int pn = getPin();

            if (data.containsKey(cn) && data.get(cn) == pn) {
                getAccountType();
            } else
                System.out.println("\nInvalid account number or pin\n");
        } while (x == 1);
    }

    public void getAccountType() {
        System.out.println("Select the type of account you want to access: ");
        System.out.println("Type 1 - Checking Account");
        System.out.println("Type 2 - Savings Account");
        System.out.println("Type 3 - Exit");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                getChecking();
                break;
            case 2:
                getSavings();
                break;
            case 3:
                System.out.println("Thank you for using the ATM, goodbye!");
                break;
            default:
                System.out.println("\nInvalid option. Please try again.\n");
                getAccountType();
        }
    }

    public void getChecking() {
        System.out.println("Checking Account: ");
        System.out.println("Type 1 - View balance");
        System.out.println("Type 2 - Withdraw funds");
        System.out.println("Type 3 - Deposit funds");
        System.out.println("Type 4 - Exit");
        System.out.println("Enter a choice: ");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Checking account balance: " + moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;
            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank you for using the ATM, goodbye!");
                break;
            default:
                System.out.println("\nInvalid option. Please try again.\n");
                getChecking();
        }
    }

    public void getSavings() {
        System.out.println("Savings Account: ");
        System.out.println("Type 1 - View balance");
        System.out.println("Type 2 - Withdraw funds");
        System.out.println("Type 3 - Deposit funds");
        System.out.println("Type 4 - Exit");
        System.out.println("Enter a choice: ");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Savings account balance: " + moneyFormat.format(getSavingsBalance()));
                getAccountType();
                break;
            case 2:
                getSavingsWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingsDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank you for using the ATM, goodbye!");
                break;
            default:
                System.out.println("\nInvalid option. Please try again.\n");
                getSavings();
        }
    }

    public boolean validateLogin(int accountNumber, int pin) {
        if (data.isEmpty()) {
            data.put(2222, 123456);
        }
        return data.containsKey(accountNumber) && data.get(accountNumber) == pin;
    }
}
