package org.example;

import org.example.model.bank.Account;
import org.example.model.bank.Bank;
import org.example.model.bank.WooriBank;
import org.example.view.InputView;
import org.example.view.OutputView;

import java.util.HashMap;

public class BankApplication {
    public static void main(String[] args) throws Exception {
        Boolean doOrNot = true;
        HashMap<String, String> accountInfo = null;
        Bank bank = WooriBank.getInstance();
        Integer withdrawAmount = 0;
        Integer depositAmount = 0;
        Integer currentBalance = 0;
        do {
            int userOption = InputView.askOption();
            switch (userOption) {
                case 1:
                    accountInfo = InputView.askAccount();
                    bank.createAccount(accountInfo.get("accountNum"), accountInfo.get("userName"));
                    break;
                case 2:
                    accountInfo = InputView.askAccount();
                    depositAmount = InputView.askDepositAmount();
                    currentBalance = bank.deposit(accountInfo.get("accountNum"), accountInfo.get("userName"), depositAmount);
                    OutputView.printCurrnetBalance(currentBalance);
                    break;
                case 3:
                    accountInfo = InputView.askAccount();
                    withdrawAmount = InputView.askWithdrawAmount();
                    currentBalance = bank.withdraw(accountInfo.get("accountNum"), accountInfo.get("userName"), withdrawAmount);
                    OutputView.printCurrnetBalance(currentBalance);
                    break;
                case 4:
                    doOrNot = false;
                    break;
                default:
                    OutputView.invalidValue();
                    break;
            }
        } while (doOrNot);
    }
}