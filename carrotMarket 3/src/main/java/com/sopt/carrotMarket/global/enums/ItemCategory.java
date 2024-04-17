package com.sopt.carrotMarket.global.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ItemCategory {
    DIGITAL(0, "디지털기기"),
    HOUSE_APPLIANCE(1, "생활가전"),
    FURNITURE_INTERIOR(2, "가구/인테리어"),
    KITCHEN(3, "생활/주방"),
    CHILD_THINGS(4, "유아동"),
    CHILD_BOOK(5, "유아도서"),
    GIRLS_FASHION(6, "여성의류"),
    GIRLS_THINGS(7, "여성잡화"),
    MANS_THINGS(8, "남성패션/잡화"),
    BEAUTY(9, "뷰티/미용"),
    SPORTS(10, "스포츠/레저"),
    HOBBY(11, "취미/게임/음반"),
    BOOK(12, "도서"),
    TICKET(13, "티켓/교환권"),
    PROCESSED_FOOD(14, "가공식품"),
    PET_SUPPLIES(15, "반려동물용품"),
    PLANT(16, "식물"),
    ETC(17, "기타 중고물품"),
    BUY(18, "삽니다");

    private final int value;
    private final String category;
}
