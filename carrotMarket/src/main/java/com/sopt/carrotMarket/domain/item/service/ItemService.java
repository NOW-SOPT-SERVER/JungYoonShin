package com.sopt.carrotMarket.domain.item.service;

import com.sopt.carrotMarket.domain.item.entity.Item;
import com.sopt.carrotMarket.domain.item.entity.ItemRepository;
import com.sopt.carrotMarket.domain.item.service.dto.ItemPostRequest;
import com.sopt.carrotMarket.domain.user.entity.User;
import com.sopt.carrotMarket.domain.user.repository.UserRepository;
import com.sopt.carrotMarket.global.enums.ItemCategory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    @Transactional
    public void createPost(ItemPostRequest request, Long memberId) {
        ItemCategory itemCategory = findCategory(request.category());

        User user = User.create("아무개", "333@naver.com", "000", "11111");
        userRepository.save(user);

//        User user = userRepository.findById(memberId)
//                .orElseThrow(()-> new CustomException(ErrorCode.MEMBER_NOT_FOUND));

        Item item = Item.create(user, request.title(), request.description(), itemCategory);
        itemRepository.save(item);
    }

    public ItemCategory findCategory(int category) {
        ItemCategory categoryType = Arrays.stream(ItemCategory.values())
            .filter(c -> c.getValue() == category)
            .findAny().get();
        return categoryType;
    }
}

