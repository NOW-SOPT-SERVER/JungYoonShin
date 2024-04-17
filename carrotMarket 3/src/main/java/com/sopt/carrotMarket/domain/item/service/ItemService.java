package com.sopt.carrotMarket.domain.item.service;

import com.sopt.carrotMarket.domain.item.entity.ItemRepository;
import com.sopt.carrotMarket.domain.item.service.dto.ItemPostRequest;
import com.sopt.carrotMarket.domain.user.repository.UserRepository;
import com.sopt.carrotMarket.global.enums.ItemCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final UserRepository userRepository;
    private final ItemRepository postRepository;
    public void createPost(ItemPostRequest request) {
//        ItemCategory postCategory = findCategory(request.getCategory());
//        Item post = request.toEntity(a, postCategory);
//        postRepository.save(post);

    }

    public ItemCategory findCategory(int category) {
        ItemCategory categoryType = Arrays.stream(ItemCategory.values())
            .filter(c -> c.getValue() == category)
            .findAny().get();
        return categoryType;
    }
}

