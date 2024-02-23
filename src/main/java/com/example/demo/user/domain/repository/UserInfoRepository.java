package com.example.demo.user.domain.repository;

import com.example.demo.user.domain.enitty.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

    Optional<UserInfo> findByUserName(String userName);
}
