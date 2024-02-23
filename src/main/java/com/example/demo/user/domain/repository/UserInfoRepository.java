package com.example.demo.user.domain.repository;

import com.example.demo.user.domain.enitty.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, String> {
}
