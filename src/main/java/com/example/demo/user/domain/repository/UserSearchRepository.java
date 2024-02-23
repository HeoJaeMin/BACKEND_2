package com.example.demo.user.domain.repository;

import com.example.demo.user.domain.dto.CustomUserDetail;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserSearchRepository {
    Optional<CustomUserDetail> findByUserName(String userName);
}
