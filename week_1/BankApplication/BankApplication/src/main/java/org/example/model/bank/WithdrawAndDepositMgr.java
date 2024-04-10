package org.example.model.bank;

import org.example.view.InputView;
import org.example.view.OutputView;

public class WithdrawAndDepositMgr {
    private AccountMgr accountMgr;
    public WithdrawAndDepositMgr(AccountMgr accountMgr) {this.accountMgr = accountMgr;}

    public Integer withdraw(String accountNum, String customerName, Integer withdrawAmount) {
        Account account = accountMgr.findAccount(accountNum, customerName);
        if(account.getBalance() == 0 ){
            OutputView.canNotWithdraw();
            return 0;
        }
        account.setBalance(account.getBalance() - withdrawAmount);
        return account.getBalance();
    }

    public Integer deposit(String accountNum, String customerName, Integer depositAmount) {
        Account account = accountMgr.findAccount(accountNum, customerName);
        account.setBalance(account.getBalance() + depositAmount);

        return account.getBalance();
    }


}
