package org.example;

import org.example.classes.Person;
import org.example.classes.PersonBuilder;

public class Main {
    public static void main(String[] args) {
        //Person 클래스의 객체 생성
        Person person = new Person("신정윤", 24, "female");

        //Person 클래스 내부 메소드 호출
        person.walk();

        System.out.println(person.getName());

        Person personWithBuilder = new
                PersonBuilder()
                .name("신정윤")
                .age(24)
                .sex("female")
                .build();
    }
}