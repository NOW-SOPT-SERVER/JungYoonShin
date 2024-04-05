package org.example.bank;

import org.example.user.Customer;

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

}
