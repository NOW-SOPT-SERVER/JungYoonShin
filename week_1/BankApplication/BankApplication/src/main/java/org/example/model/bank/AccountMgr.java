package org.example.model.bank;

import org.example.model.user.Customer;

import java.util.ArrayList;
import java.util.List;

public class AccountMgr {

    public void createAccount(String accountNum, String userName) {
        Account account = Account.accountNumFrom(accountNum, new Customer(userName));
        Bank.accounts.add(account);
    }

    public Account findAccount(String accountNum, String customerName) {
        return Bank.accounts.stream()
                .filter(ac -> ac.getAccountNum().equals(accountNum))
                .filter(ac -> ac.getCustomerName().equals(customerName))
                .findAny().orElseThrow(() -> new IllegalArgumentException("정보에 해당하는 계좌를 찾을 수 없습니다."));
    }
}
