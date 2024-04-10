package org.example.view;

public class OutputView {

    public static void canNotWithdraw() {
        System.out.println("계좌 잔액이 0원이므로 출금이 불가합니다.");
    }

    public static void invalidValue() {
        System.out.println("**잘못된 입력값입니다. 1-3 중의 하나의 숫자를 입력해수세요.**");

    }

    public static void printCurrnetBalance(Integer balance) {
        System.out.println("현재 잔액은 " + balance + "입니다.");
    }

}
