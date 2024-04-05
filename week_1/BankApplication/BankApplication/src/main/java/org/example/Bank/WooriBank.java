package org.example.Bank;

public class WooriBank extends Bank {
    private static final double INTEREST_RATE = 3.2;
    private static final BankType bankType = BankType.WOORIBANK;
    private static final WooriBank wooriBankInstance = new WooriBank(bankType.getBank(), INTEREST_RATE);

    private WooriBank(String bankName, Double interestRate) {
        super(bankName, interestRate);
    }

    public static WooriBank getInstance() {
        return wooriBankInstance;
    }

}
