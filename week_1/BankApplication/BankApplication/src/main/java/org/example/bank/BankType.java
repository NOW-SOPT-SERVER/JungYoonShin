package org.example.bank;

public enum BankType {
    WOORIBANK("우리은행");

    public String bankType;

    BankType(String bank) {this.bankType = bankType;}

    public String getBank() {return this.bankType;}
}
