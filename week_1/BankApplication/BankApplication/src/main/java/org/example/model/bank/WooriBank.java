package org.example.model.bank;

public class WooriBank extends Bank {
    private static final String bankName = "우리은행";
    private static final double INTEREST_RATE = 3.2;
    private static final BankType bankType = BankType.WOORIBANK;
    private static final WooriBank wooriBankInstance = new WooriBank();

    public static WooriBank getInstance() {
        return wooriBankInstance;
    }

    @Override
    public Integer deposit(String accountNum, String customerName, Integer depositAmount) {
        return withdrawAndDepositMgr.deposit(accountNum, customerName, depositAmount);
    }

}
