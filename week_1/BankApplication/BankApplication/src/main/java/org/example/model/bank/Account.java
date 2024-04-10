package org.example.model.bank;

import org.example.model.user.Customer;

public class Account {
    private String accountNum;
    private Customer customer;
    private Integer balance;

    private Account(String  accountNum, Customer customer) {
        this.accountNum = accountNum;
        this.customer = customer;
        this.balance = 0;
    }

    public static Account accountNumFrom(String  accountNum, Customer customer) { //정적 팩토리 메서드 패턴 이용
        return new Account(accountNum, customer);
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {this.balance = balance; }

    public String getAccountNum() {
        return accountNum;
    }

    public String getCustomerName() {
        return customer.getName();
    }

}
