package org.example.bank;

import org.example.user.Customer;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String bankName;
    private double interestRate;
    private static int index = 0;
    private List<Account> accounts = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();

    public Bank(String bankName, double interestRate) {
        this.bankName = bankName;
        this.interestRate = interestRate;
    }

    public void createAccount(String accountNum, String userName) {
        Account account = Account.accountNumFrom(accountNum, new Customer(userName));
        accounts.add(account);
    }
}
