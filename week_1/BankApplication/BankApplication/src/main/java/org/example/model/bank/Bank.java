package org.example.model.bank;

import org.example.model.user.Customer;

import java.util.ArrayList;
import java.util.List;

public abstract class Bank {
    private static int index = 0;
    static AccountMgr accountMgr = new AccountMgr();
    static WithdrawAndDepositMgr withdrawAndDepositMgr = new WithdrawAndDepositMgr(accountMgr);
    static List<Account> accounts = new ArrayList<>();
    static List<Customer> customers = new ArrayList<>();
    public void createAccount(String accountNum, String customerName) {
        accountMgr.createAccount(accountNum, customerName);
    }

    public void findAccount(String accountNum, String customerName) {
        accountMgr.findAccount(accountNum, customerName);
    }

    public Integer withdraw(String accountNum, String customerName, Integer withdrawAmount) {
        return withdrawAndDepositMgr.withdraw(accountNum, customerName, withdrawAmount);
    }

    public abstract Integer deposit(String accountNum, String customerName, Integer depositAmount);

}
