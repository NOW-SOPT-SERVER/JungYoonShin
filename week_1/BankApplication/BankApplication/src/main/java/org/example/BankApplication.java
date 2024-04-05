package org.example;

import org.example.bank.Bank;
import org.example.bank.WooriBank;
import org.example.view.InputView;

import java.util.Arrays;
import java.util.HashMap;

public class BankApplication {
    public static void main(String[] args) {
        Boolean doOrNot = true;
        Bank bank = WooriBank.getInstance();
        do {
            int userOption = InputView.askOption();
            switch (userOption) {
                case 1:
                    HashMap<String, String> accountInfo = InputView.createAccount();
                    bank.createAccount(accountInfo.get("accountNum"), accountInfo.get("userName"));
                    break;
                case 5:
                    doOrNot = false;
                    break;
            }
        } while (doOrNot);
    }
}