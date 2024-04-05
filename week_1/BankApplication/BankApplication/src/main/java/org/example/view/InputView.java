package org.example.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner input = new Scanner(System.in);

    public static Integer askOption() {
        System.out.println("==== 은행 예적금 거래 프로그램 ====");
        System.out.println("1. 계좌개설(신규고객)");
        System.out.println("2. 예금");
        System.out.println("3. 입금");
        System.out.println("4. 출금");
        System.out.println("5. 종료");

        return Integer.parseInt(input.nextLine());
    }

    public static HashMap<String, String> createAccount() {
        System.out.print("계좌번호: ");
        String accountNum = input.nextLine();

        System.out.print("이름: ");
        String name = input.nextLine();

        HashMap<String, String> accountInfo = new HashMap<>();
        accountInfo.put("accountNum", accountNum);
        accountInfo.put("userName", name);

        return accountInfo;
    }

}
