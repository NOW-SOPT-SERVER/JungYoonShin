package com.sopt.carrotMarket.domain.user.repository;

import com.sopt.carrotMarket.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, Long> {

}
